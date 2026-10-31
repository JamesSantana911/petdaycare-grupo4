import java.time.LocalDate;

public class FiltroDisponibilidad implements Filtro {
    public void procesar(Reserva r) {
        if (r.getEstado() != EstadoServicio.DISPONIBLE) throw new IllegalStateException("La reserva ya fue procesada");
        if (r.getFecha().isBefore(LocalDate.now())) throw new IllegalStateException("La fecha ya paso");
        if (!r.getServicio().hayCupo()) throw new IllegalStateException("No hay cupo disponible");
    }
}
