public class FiltroBloqueo implements Filtro {
    public void procesar(Reserva r) {
        r.getServicio().bloquearCupo();
        r.bloquear(15);
        r.calcularTotal();
    }
}
