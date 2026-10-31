import java.util.List;

public class Flujo {
    private List<Filtro> filtros;

    public Flujo(List<Filtro> filtros) { this.filtros = filtros; }

    public String ejecutar(Reserva r) {
        try {
            for (Filtro f : filtros) f.procesar(r);
            return null;
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    }
}
