import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControladorReservas {
    private Flujo flujoReserva;
    private Flujo flujoPago;
    private List<Reserva> reservas = new ArrayList<>();
    private Notificador notificador;
    private Vista vista;

    public ControladorReservas(FabricaPlataforma fabrica) {
        notificador = fabrica.crearNotificador();
        vista = fabrica.crearVista();
        flujoReserva = new Flujo(Arrays.asList(new FiltroDisponibilidad(), new FiltroBloqueo()));
        flujoPago = new Flujo(Arrays.asList(new FiltroPago(), new FiltroConfirmacion(notificador)));
    }

    public boolean reservar(Reserva r) {
        liberarVencidas();
        String error = flujoReserva.ejecutar(r);
        if (error != null) {
            vista.mostrar("No se pudo reservar: " + error);
            return false;
        }
        reservas.add(r);
        vista.mostrar("Reserva en espera. Total a pagar: $" + r.getTotal());
        return true;
    }

    public boolean pagar(Reserva r, double monto) {
        r.registrarPago(monto);
        String error = flujoPago.ejecutar(r);
        if (error != null) {
            vista.mostrar("No se pudo pagar: " + error);
            return false;
        }
        vista.mostrar("Pago recibido, reserva confirmada");
        return true;
    }

    private void liberarVencidas() {
        for (Reserva r : reservas) {
            if (r.getEstado() == EstadoServicio.EN_ESPERA && r.vencida()) {
                r.getServicio().liberarCupo();
                r.cancelar();
            }
        }
    }

    public double cancelar(Reserva r) {
        if (r.getEstado() != EstadoServicio.EN_ESPERA && r.getEstado() != EstadoServicio.OCUPADO) return 0;
        boolean pagada = r.getEstado() == EstadoServicio.OCUPADO;
        r.getServicio().liberarCupo();
        r.cancelar();
        double reembolso = 0;
        if (pagada && r.diasFaltantes() >= r.getServicio().getDiasReembolso()) reembolso = r.getTotal();
        notificador.enviar(r.getCliente().getCorreo(), "Reserva cancelada. Reembolso: $" + reembolso);
        vista.mostrar("Reserva cancelada. Reembolso: $" + reembolso);
        return reembolso;
    }

    public Incidente reportarIncidente(Reserva r, String descripcion, boolean complejo) {
        Incidente i = new Incidente(r, descripcion);
        if (complejo) i.escalar();
        i.resolver();
        notificador.enviar(r.getCliente().getCorreo(), "Su incidente fue resuelto por: " + i.getAtendidoPor());
        vista.mostrar("Incidente resuelto por: " + i.getAtendidoPor());
        return i;
    }
}
