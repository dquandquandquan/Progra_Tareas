import java.util.Date;
import java.util.Scanner;

/**
 * Programa principal (Main) para la gestión de ventas de tickets en un teatro.
 * Creado por: Diego Quan
 * Fecha de creación: 26/07/2024
 * Última modificación: 29/07/2024
 * Créditos: https://codegym.cc/es/groups/posts/es.660.clase-java-util-date
 */

public class Principal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Teatro teatro = new Teatro("Teatro Nacional", 300, new Date());
        Reportes reportes = new Reportes(teatro.getSecciones().length);

        mostrarMenu();
        int opcion = scanner.nextInt();
        while (opcion!=5) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Cliente cliente = solicitarDatosCliente(scanner);
                    int indiceSeccion = seleccionarSeccion(scanner);
                    if (teatro.validarDisponibilidad(indiceSeccion, cliente.getCantidadTickets())) {
                        Ticket ticket = teatro.venderTicket(cliente, indiceSeccion, cliente.getCantidadTickets());
                        if (ticket != null) {
                            System.out.println("Venta exitosa. Detalles del ticket:\n" + ticket.getTicketInfo());
                            reportes.nuevoReporte(ticket, indiceSeccion);
                        } else {
                            System.out.println("Compra fallida. Verifique presupuesto o disponibilidad.");
                        }
                    } else {
                        System.out.println("No hay suficientes boletos disponibles en la sección elegida.");
                    }
                    break;
                case 2:
                    System.out.println("Disponibilidad total:\n" + teatro.consultarDisponibilidadTotal());
                    break;
                case 3:
                    indiceSeccion = seleccionarSeccion(scanner);
                    System.out.println(teatro.consultarDisponibilidadIndividual(indiceSeccion));
                    break;
                case 4:
                    System.out.println("Total de ingresos: Q" + reportes.getTotalIngresos());
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 5.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nSistema de Ventas de Tickets");
        System.out.println("1. Comprar Boletos");
        System.out.println("2. Consultar Disponibilidad Total");
        System.out.println("3. Consultar Disponibilidad Individual");
        System.out.println("4. Reporte de Caja");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * @param scanner
     * @return Un objeto Cliente con los datos proporcionados por el usuario.
     */
    private static Cliente solicitarDatosCliente(Scanner scanner) {
        System.out.println("Ingrese el nombre del comprador: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el email del comprador: ");
        String email = scanner.nextLine();

        System.out.println("Ingrese la cantidad de tickets a comprar (máximo 6): ");
        int cantidadTickets = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el presupuesto máximo: ");
        float presupuesto = scanner.nextFloat();
        scanner.nextLine();

        return new Cliente(nombre, email, cantidadTickets, presupuesto);
    }

    /**
     * @param scanner
     * @return El índice de la sección seleccionada.
     */
    private static int seleccionarSeccion(Scanner scanner) {
        System.out.println("Seleccione la sección:");
        System.out.println("1. Balcón 2");
        System.out.println("2. Platea");
        System.out.println("3. Balcón 1/VIP");
        System.out.print("Ingrese el número de la sección: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        return seleccion - 1; 
    }
}
