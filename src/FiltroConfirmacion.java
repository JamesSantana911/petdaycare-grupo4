public class FiltroConfirmacion implements Filtro {
    private Notificador notificador;

    public FiltroConfirmacion(Notificador notificador) { this.notificador = notificador; }

    public void procesar(Reserva r) {
        r.confirmar();
        notificador.enviar(r.getCliente().getCorreo(), "Reserva de " + r.getMascota().getNombre() + " confirmada");
    }
}
