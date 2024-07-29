import java.util.Date;

public class Teatro {
    private String nombre;
    private int capacidad;
    private Localidades[] secciones;
    private Date fecha;
    private static int ticketCounter = 1;

    /**
     * @param nombre  
     * @param capacidad 
     * @param fecha    
     */
    public Teatro(String nombre, int capacidad, Date fecha) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.secciones = new Localidades[]{
                new Localidades("Balcón 2", capacidad / 3, 300),
                new Localidades("Platea", capacidad / 3, 600),
                new Localidades("Balcón 1/VIP", capacidad / 3, 1800)
        };
    }

    /**
     * @param indiceSeccion 
     * @param cantidad     
     * @return true si hay suficiente disponibilidad, false si no.
     */
    public boolean validarDisponibilidad(int indiceSeccion, int cantidad) {
        if (cantidad > 6) {
            return false;
        }
        if (indiceSeccion >= 0 && indiceSeccion < secciones.length) {
            return secciones[indiceSeccion].ticketsDisponibles(cantidad);
        }
        return false;
    }

    /**
     * @param cliente       
     * @param indiceSeccion 
     * @param cantidad  
     * @return Un objeto Ticket si la venta es exitosa, null si no.
     */
    public Ticket venderTicket(Cliente cliente, int indiceSeccion, int cantidad) {
        if (indiceSeccion >= 0 && indiceSeccion < secciones.length) {
            Localidades seccion = secciones[indiceSeccion];
            if (seccion.ticketsDisponibles(cantidad) && cliente.validarPresupuesto(seccion.getPrecioTicket() * cantidad)) {
                seccion.venderTickets(cantidad);
                // Incrementa el contador y genera un nuevo ticket
                return new Ticket(cliente, seccion, cantidad, new Date(), ticketCounter++);
            }
        }
        return null;
    }

    /**
     * @return Un String que describe la disponibilidad total de boletos.
     */
    public String consultarDisponibilidadTotal() {
        StringBuilder disponibilidad = new StringBuilder();
        for (Localidades seccion : secciones) {
            disponibilidad.append(seccion.getNombre())
                    .append(": Vendidos = ")
                    .append(seccion.getTicketsVendidos())
                    .append(", Disponibles = ")
                    .append(seccion.getCapacidad() - seccion.getTicketsVendidos())
                    .append("\n");
        }
        return disponibilidad.toString();
    }

    /**
     * @param indiceSeccion 
     * @return Un String con la disponibilidad de boletos en la sección especificada.
     */
    public String consultarDisponibilidadIndividual(int indiceSeccion) {
        if (indiceSeccion >= 0 && indiceSeccion < secciones.length) {
            Localidades seccion = secciones[indiceSeccion];
            return seccion.getNombre() + ": " + (seccion.getCapacidad() - seccion.getTicketsVendidos()) + " boletos disponibles\n";
        }
        return "Sección no encontrada.";
    }

    public Localidades[] getSecciones() {
        return secciones;
    }

    public Date getFecha() {
        return fecha;
    }
}
