public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String tamano;
    private String necesidadesEspeciales;
    private String preferenciasTrato;

    public Mascota(String nombre, String especie, String raza, int edad, String tamano,
                   String necesidadesEspeciales, String preferenciasTrato) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
        this.necesidadesEspeciales = necesidadesEspeciales;
        this.preferenciasTrato = preferenciasTrato;
    }

    public String getNombre() { return nombre; }
}
