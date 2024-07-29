public class Cliente {
    private String nombre;
    private String email;
    private int cantidadTickets;
    private float presupuesto;

    /**
     * @param nombre        
     * @param email           
     * @param cantidadTickets 
     * @param presupuesto     
     */
    public Cliente(String nombre, String email, int cantidadTickets, float presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadTickets = cantidadTickets;
        this.presupuesto = presupuesto;
    }

    /**
     * @param precioTotal 
     * @return 
     */
    public boolean validarPresupuesto(float precioTotal) {
        return presupuesto >= precioTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadTickets() {
        return cantidadTickets;
    }

    public float getPresupuesto() {
        return presupuesto;
    }
}
