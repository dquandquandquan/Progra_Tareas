public class Localidades {
    private String nombre;
    private int capacidad;
    private int ticketsVendidos;
    private float precioTicket;

    /**
     * @param nombre     
     * @param capacidad   
     * @param precioTicket 
     */
    public Localidades(String nombre, int capacidad, float precioTicket) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioTicket = precioTicket;
        this.ticketsVendidos = 0;
    }

    /**
     * @param pedidosTickets 
     * @return
     */
    public boolean ticketsDisponibles(int pedidosTickets) {
        return (capacidad - ticketsVendidos) >= pedidosTickets;
    }

    /**
     * @param cantidad 
     */
    public void venderTickets(int cantidad) {
        this.ticketsVendidos += cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTicketsVendidos() {
        return ticketsVendidos;
    }

    public float getPrecioTicket() {
        return precioTicket;
    }
}
