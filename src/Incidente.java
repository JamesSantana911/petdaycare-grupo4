public class Incidente {
    private Reserva reserva;
    private String descripcion;
    private String atendidoPor = "Personal del centro";
    private boolean resuelto;

    public Incidente(Reserva reserva, String descripcion) {
        this.reserva = reserva;
        this.descripcion = descripcion;
    }

    public void escalar() { atendidoPor = "Atencion general"; }
    public void resolver() { resuelto = true; }

    public String getAtendidoPor() { return atendidoPor; }
}
