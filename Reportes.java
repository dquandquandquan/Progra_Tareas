public class Reportes {
    private float ingresos;
    private int[] ticketsSeccion;

    /**
     * @param numSecciones
     */
    public Reportes(int numSecciones) {
        this.ticketsSeccion = new int[numSecciones];
    }

    /**
     * @param ticket
     */
    public void nuevoReporte(Ticket ticket, int indiceSeccion) {
        ingresos += ticket.getPrecio();
        ticketsSeccion[indiceSeccion]++;
    }

    /**
     * @return El total de ingresos.
     */
    public float getTotalIngresos() {
        return ingresos;
    }

    /**

     * @param secciones 
     * @return Un String que representa la disponibilidad de boletos por sección.
     */
    public String getSeccionDisponibilidad(Localidades[] secciones) {
        StringBuilder disponibilidad = new StringBuilder();
        for (int i = 0; i < secciones.length; i++) {
            disponibilidad.append(secciones[i].getNombre())
                    .append(": Vendidos = ")
                    .append(ticketsSeccion[i])
                    .append(", Disponibles = ")
                    .append(secciones[i].getCapacidad() - ticketsSeccion[i])
                    .append("\n");
        }
        return disponibilidad.toString();
    }
}
