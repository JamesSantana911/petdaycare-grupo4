import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("######## PLATAFORMA MOVIL ########");
        probar(new FabricaMovil());
        System.out.println("\n######## PLATAFORMA WEB ########");
        probar(new FabricaWeb());
    }

    static void probar(FabricaPlataforma fabrica) {
        ControladorReservas app = new ControladorReservas(fabrica);
        Centro centro = new Centro("PetDayCare Norte");
        Administrador admin = new Administrador("Ana", "ana@petdaycare.com", centro);
        Cliente cliente = new Cliente("Luis", "luis@mail.com");
        Mascota firu = new Mascota("Firu", "Perro", "Labrador", 3, "Grande", "Alergia al pollo", "Prefiere trato tranquilo");
        Cuidador marta = new Cuidador("Marta");

        System.out.println("== 1. Configurar servicios ==");
        admin.configurarServicio("Guarderia diurna", "Guarderia", 15.0, 5, 1);
        admin.configurarServicio("Hospedaje", "Hospedaje", 30.0, 2, 7);
        centro.agregarCuidador(marta);

        System.out.println("== 2. Registrar mascota y reservar ==");
        cliente.registrarMascota(firu);
        Servicio elegido = centro.buscarServicio("Guarderia");
        Reserva reserva = new Reserva(cliente, firu, elegido, LocalDate.now().plusDays(2));
        reserva.asignarCuidador(marta);
        reserva.agregarComplemento("Reporte en tiempo real", 5.0);
        app.reservar(reserva);

        System.out.println("== 3. Pagar y confirmar ==");
        app.pagar(reserva, 20.0);

        System.out.println("== 4. Incidente simple (lo resuelve el personal) ==");
        app.reportarIncidente(reserva, "Cambio de ultima hora", false);

        System.out.println("== 5. Incidente complejo (se escala) ==");
        app.reportarIncidente(reserva, "Mal trato a la mascota", true);

        System.out.println("== 6. Cancelar reserva ==");
        app.cancelar(reserva);
    }
}
