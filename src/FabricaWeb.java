public class FabricaWeb implements FabricaPlataforma {
    public Notificador crearNotificador() { return new NotificadorCorreo(); }
    public Vista crearVista() { return new VistaWeb(); }
}
