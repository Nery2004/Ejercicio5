public class AuxiliarOpuesto extends Jugador {
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    public int getAtaques() {
        return ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    @Override
    public double calcularEfectividad() {
        // Implementación de la lógica para calcular la efectividad de un auxiliar/opuesto.
        double efectividad = super.calcularEfectividad();

        if (totalServicios > 0) {
            efectividad += ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100.0) / (ataques + bloqueosEfectivos + bloqueosFallidos + errores);
        }

        return efectividad;
    }
}
