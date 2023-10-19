public class Libero extends Jugador {
    private int recibos;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibos = recibos;
    }

    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    @Override
    public double calcularEfectividad() {
        // Implementación de la lógica para calcular la efectividad de un líbero.
        double efectividad = super.calcularEfectividad();
        
        if (totalServicios > 0) {
            efectividad += (recibos * 100.0) / totalServicios;
        }

        return efectividad;
    }
}
