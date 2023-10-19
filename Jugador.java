public class Jugador {
    private String nombre;
    private String pais;
    private int aces;
    protected int errores;
    protected int totalServicios;

    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }
    public double calcularEfectividad() {
    double efectividad = 0.0;

    if (totalServicios + errores > 0) {
        efectividad = ((totalServicios - errores) * 100.0) / (totalServicios + errores);
    }

    return efectividad;
}
}
