public class NotificadorCorreo implements Notificador {
    public void enviar(String destino, String mensaje) {
        System.out.println("  [CORREO a " + destino + "] " + mensaje);
    }
}
