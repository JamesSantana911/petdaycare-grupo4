public class Servicio {
    private String categoria;
    private String nombre;
    private double precio;
    private int cupos;
    private int diasReembolso;

    public Servicio(String categoria, String nombre, double precio, int cupos, int diasReembolso) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.cupos = cupos;
        this.diasReembolso = diasReembolso;
    }

    public boolean hayCupo() { return cupos > 0; }
    public void bloquearCupo() { cupos--; }
    public void liberarCupo() { cupos++; }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCupos() { return cupos; }
    public int getDiasReembolso() { return diasReembolso; }
}
