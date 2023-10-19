public class Pasador extends Jugador {
    private int pases;  // Cantidad de pases efectivos realizados por el pasador
    private int fintas;  // Cantidad de fintas efectivas realizadas por el pasador

    // Constructor para crear una instancia de Pasador, que hereda de Jugador
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios);  // Llama al constructor de la clase base (Jugador)
        this.pases = pases;
        this.fintas = fintas;
    }

    // Getter y Setter para la cantidad de pases efectivos
    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    // Getter y Setter para la cantidad de fintas efectivas
    public int getFintas() {
        return fintas;
    }

    public void setFintas(int fintas) {
        this.fintas = fintas;
    }

    // Metodo para calcular la efectividad de un pasador (sobrescribe el metodo de la clase base)
    @Override
    public double calcularEfectividad() {
        double efectividad = super.calcularEfectividad();  // Llama al metodo de la clase base

        // Verifica si el total de servicios es mayor que 0 para evitar divisiones por cero
        if (totalServicios > 0) {
            efectividad += ((pases + fintas - errores) * 100.0) / (pases + fintas + errores);
        }

        return efectividad;
    }
}
