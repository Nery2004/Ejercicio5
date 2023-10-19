public class Libero extends Jugador {
    private int recibos;  // Cantidad de recibos efectivos realizados por el libero

    // Constructor para crear una instancia de Libero, que hereda de Jugador
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibos) {
        super(nombre, pais, errores, aces, totalServicios);  // Llama al constructor de la clase base (Jugador)
        this.recibos = recibos;
    }

    // Getter y Setter para la cantidad de recibos efectivos
    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    // Metodo para calcular la efectividad de un libero (sobrescribe el metodo de la clase base)
    @Override
    public double calcularEfectividad() {
        double efectividad = super.calcularEfectividad();  // Llama al metodo de la clase base

        // Verifica si el total de servicios es mayor que 0 para evitar divisiones por cero
        if (totalServicios > 0) {
            efectividad += (recibos * 100.0) / totalServicios;
        }

        return efectividad;
    }
}
