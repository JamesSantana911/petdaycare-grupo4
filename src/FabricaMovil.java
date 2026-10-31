public class FabricaMovil implements FabricaPlataforma {
    public Notificador crearNotificador() { return new NotificadorMensajeria(); }
    public Vista crearVista() { return new VistaMovil(); }
}
