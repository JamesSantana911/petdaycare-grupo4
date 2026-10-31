public class NotificadorMensajeria implements Notificador {
    public void enviar(String destino, String mensaje) {
        System.out.println("  [MENSAJERIA a " + destino + "] " + mensaje);
    }
}
