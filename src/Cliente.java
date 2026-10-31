import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(String nombre, String correo) { super(nombre, correo); }

    public void registrarMascota(Mascota m) { mascotas.add(m); }

    public List<Mascota> getMascotas() { return mascotas; }
}
