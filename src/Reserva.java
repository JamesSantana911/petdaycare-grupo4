import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Cliente cliente;
    private Mascota mascota;
    private Servicio servicio;
    private Cuidador cuidador;
    private List<String> complementos = new ArrayList<>();
    private double costoComplementos;
    private LocalDate fecha;
    private EstadoServicio estado = EstadoServicio.DISPONIBLE;
    private LocalDateTime bloqueadoHasta;
    private double total;
    private double montoPagado;

    public Reserva(Cliente cliente, Mascota mascota, Servicio servicio, LocalDate fecha) {
        if (!cliente.getMascotas().contains(mascota)) throw new IllegalArgumentException("La mascota no pertenece al cliente");
        this.cliente = cliente;
        this.mascota = mascota;
        this.servicio = servicio;
        this.fecha = fecha;
    }

    public void asignarCuidador(Cuidador c) { this.cuidador = c; }

    public void agregarComplemento(String nombre, double costo) {
        complementos.add(nombre);
        costoComplementos += costo;
    }

    public double calcularTotal() {
        total = servicio.getPrecio() + costoComplementos;
        return total;
    }

    public void registrarPago(double monto) { montoPagado = monto; }

    public void bloquear(int minutos) {
        estado = EstadoServicio.EN_ESPERA;
        bloqueadoHasta = LocalDateTime.now().plusMinutes(minutos);
    }

    public int diasFaltantes() { return (int) ChronoUnit.DAYS.between(LocalDate.now(), fecha); }

    public boolean vencida() { return bloqueadoHasta != null && LocalDateTime.now().isAfter(bloqueadoHasta); }

    public void confirmar() { estado = EstadoServicio.OCUPADO; }
    public void cancelar() { estado = EstadoServicio.CANCELADO; }

    public Cliente getCliente() { return cliente; }
    public Mascota getMascota() { return mascota; }
    public Servicio getServicio() { return servicio; }
    public LocalDate getFecha() { return fecha; }
    public EstadoServicio getEstado() { return estado; }
    public double getTotal() { return total; }
    public double getMontoPagado() { return montoPagado; }
}
