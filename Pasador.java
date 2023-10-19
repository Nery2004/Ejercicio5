public class Pasador extends Jugador {
    private int pases;
    private int fintas;

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintas = fintas;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getFintas() {
        return fintas;
    }

    public void setFintas(int fintas) {
        this.fintas = fintas;
    }

    @Override
    public double calcularEfectividad() {
        double efectividad = super.calcularEfectividad();

        if (totalServicios > 0) {
            efectividad += ((pases + fintas - errores) * 100.0) / (pases + fintas + errores);
        }

        return efectividad;
    }
}
