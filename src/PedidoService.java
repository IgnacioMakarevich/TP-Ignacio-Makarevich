import java.util.Scanner;
public class PedidoService {
    public static void aprobarPedido(Usuario usuario, Pedido pedido, Scanner scanner) {
        System.out.println("\nAprobar pedido:");

        System.out.print("Ingrese el nombre del usuario administrador para la aprobación: ");
        String nombreAdmin = scanner.nextLine();
        Usuario usuarioAdmin = new Usuario(nombreAdmin, true);
        if (usuarioAdmin.esResponsable()) {
            if (pedido.getEstado() == FlujoPedido.PENDIENTE_DE_APROBACION) {
                System.out.print("¿Desea aprobar el pedido? (s/n): ");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    pedido.setEstado(FlujoPedido.APROBADO);
                    System.out.println("El pedido ha sido aprobado. Estado actual: " + pedido.getEstado());
                } else {
                    pedido.setEstado(FlujoPedido.RECHAZADO);
                    System.out.println("El pedido ha sido rechazado. Estado actual: " + pedido.getEstado());
                }
            } else {
                System.out.println("El pedido no se puede aprobar porque no está en estado Pendiente de aprobacion.");
            }
        } else {
            System.out.println("El usuario ingresado no es administrador. No tiene permisos para aprobar pedidos.");
        }
    }
}