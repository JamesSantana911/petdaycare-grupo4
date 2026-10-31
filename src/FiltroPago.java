public class FiltroPago implements Filtro {
    public void procesar(Reserva r) {
        if (r.getEstado() != EstadoServicio.EN_ESPERA) throw new IllegalStateException("La reserva no esta en espera de pago");
        if (r.vencida()) {
            r.getServicio().liberarCupo();
            r.cancelar();
            throw new IllegalStateException("El bloqueo vencio, cupo liberado");
        }
        if (r.getMontoPagado() < r.getTotal()) throw new IllegalStateException("Pago insuficiente");
    }
}
