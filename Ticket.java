import java.util.Date;

public class Ticket {
    private String correlativo;
    private Date fecha;
    private float precio;
    private String seccion;
    private Cliente cliente;

    /**
     * @param cliente   
     * @param seccion   
     * @param cantidad 
     * @param fecha     
     * @param correlativo 
     */
    public Ticket(Cliente cliente, Localidades seccion, int cantidad, Date fecha, int correlativo) {
        this.fecha = fecha;
        this.seccion = seccion.getNombre();
        this.precio = seccion.getPrecioTicket() * cantidad;
        this.cliente = cliente;
        generarCorrelativo(fecha, correlativo);
    }

    /**
     * @param fecha     
     * @param correlativo 
     */
    private void generarCorrelativo(Date fecha, int correlativo) {
        this.correlativo = String.format("%1$td%1$tm%1$tY", fecha) + String.format("%03d", correlativo);
    }

    /**
     * @return Un String que representa la información del ticket.
     */
    public String getTicketInfo() {
        return "Ticket N°: " + correlativo + "\n" +
                "Fecha: " + fecha + "\n" +
                "Sección: " + seccion + "\n" +
                "Precio: Q" + precio + "\n" +
                "Cliente: " + cliente.getNombre();
    }

    public float getPrecio() {
        return precio;
    }
}
