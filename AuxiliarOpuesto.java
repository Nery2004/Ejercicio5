public class AuxiliarOpuesto extends Jugador {
    private int ataques;           // Cantidad de ataques realizados por el auxiliar/opuesto
    private int bloqueosEfectivos; // Cantidad de bloqueos efectivos realizados por el auxiliar/opuesto
    private int bloqueosFallidos;  // Cantidad de bloqueos fallidos realizados por el auxiliar/opuesto

    // Constructor para crear una instancia de AuxiliarOpuesto, que hereda de Jugador
    public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);  // Llama al constructor de la clase base (Jugador)
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    // Getter y Setter para la cantidad de ataques realizados
    public int getAtaques() {
        return ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    // Getter y Setter para la cantidad de bloqueos efectivos
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    // Getter y Setter para la cantidad de bloqueos fallidos
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    // Metodo para calcular la efectividad de un auxiliar/opuesto (sobrescribe el metodo de la clase base)
    @Override
    public double calcularEfectividad() {
        double efectividad = super.calcularEfectividad();  // Llama al metodo de la clase base

        // Verifica si el total de servicios es mayor que 0 para evitar divisiones por cero
        if (totalServicios > 0) {
            efectividad += ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100.0) / (ataques + bloqueosEfectivos + bloqueosFallidos + errores);
        }

        return efectividad;
    }
}