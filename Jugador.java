public class Jugador {
    private String nombre;           // Nombre del jugador
    private String pais;             // Pais de origen del jugador
    private int aces;                // Cantidad de aces (puntos directos por servicios)
    protected int errores;           // Cantidad de errores cometidos por el jugador
    protected int totalServicios;    // Total de servicios realizados por el jugador

    // Constructor para crear una instancia de Jugador
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    // Getter y Setter para el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para el país del jugador
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Getter y Setter para la cantidad de errores
    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    // Getter y Setter para la cantidad de aces
    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    // Getter y Setter para el total de servicios
    public int getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    // Metodo para calcular la efectividad del jugador
    public double calcularEfectividad() {
        double efectividad = 0.0;

        // Verificar si el total de servicios y errores es mayor que 0 para evitar divisiones por cero
        if (totalServicios + errores > 0) {
            efectividad = ((totalServicios - errores) * 100.0) / (totalServicios + errores);
        }

        return efectividad;
    }
}
