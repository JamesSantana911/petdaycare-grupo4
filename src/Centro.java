import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String nombre;
    private List<Servicio> servicios = new ArrayList<>();
    private List<Cuidador> cuidadores = new ArrayList<>();

    public Centro(String nombre) { this.nombre = nombre; }

    public void agregarServicio(Servicio s) { servicios.add(s); }
    public void agregarCuidador(Cuidador c) { cuidadores.add(c); }

    public Servicio buscarServicio(String nombreServicio) {
        for (Servicio s : servicios) {
            if (s.getNombre().equalsIgnoreCase(nombreServicio)) return s;
        }
        return null;
    }
}
