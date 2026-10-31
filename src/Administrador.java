public class Administrador extends Usuario {
    private Centro centro;

    public Administrador(String nombre, String correo, Centro centro) {
        super(nombre, correo);
        this.centro = centro;
    }

    public Servicio configurarServicio(String categoria, String nombre, double precio, int cupos, int diasReembolso) {
        Servicio s = new Servicio(categoria, nombre, precio, cupos, diasReembolso);
        centro.agregarServicio(s);
        return s;
    }
}
