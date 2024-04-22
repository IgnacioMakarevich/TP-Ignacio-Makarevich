import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nombreUsuario, false);
        int opcion;
        Pedido pedido = null;
        do {
            if (pedido != null) {
                System.out.println("Estado del pedido: " + pedido.getEstado());
            }
            System.out.println("\nMenú Principal:");
            System.out.println("1. Iniciar un pedido");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    pedido = iniciarPedido(usuario, scanner);
                    break;
                case 2:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 2);

        scanner.close();
    }

    public static Pedido iniciarPedido(Usuario usuario, Scanner scanner) {
        System.out.println("\nIniciar un pedido:");

        Pedido pedido = new Pedido();
        System.out.println("Hola, " + usuario.getNombre() + ". Estado inicial del pedido: " + pedido.getEstado());
        int opcion;
        do {
            System.out.println("----Estado del pedido: " + pedido.getEstado() +"----");

            System.out.println("\nMenú del Pedido:");
            System.out.println("1. Enviar pedido");
            System.out.println("2. Aprobar pedido");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    if (pedido.getEstado() == FlujoPedido.BORRADOR) {
                        pedido.setEstado(FlujoPedido.PENDIENTE_DE_APROBACION);
                        System.out.println("El pedido ha sido enviado. Estado actual: " + pedido.getEstado());
                    } else {
                        System.out.println("El pedido solo puede ser enviado si está en estado Borrador.");
                    }
                    break;
                case 2:
                    PedidoService.aprobarPedido(usuario, pedido, scanner);
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);

        return pedido;
    }
}