import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.stream.Collectors;

public class TorneoVoleibol {
    private ArrayList<Jugador> jugadores;

    public TorneoVoleibol() {
        jugadores = new ArrayList<>();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Mostrar Jugadores Inscritos");
            System.out.println("3. Mostrar 3 Mejores Liberos");
            System.out.println("4. Contar Pasadores Efectivos (mas del 80% de efectividad)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    mostrarMejoresLiberos(jugadores);
                    break;
                case 4:
                    contarPasadoresEfectivos(jugadores);
                    break;
                case 5:
                    System.out.println("Gracias por usar el programa!");
                    break;
                default:
                    System.out.println("Por favor, seleccione una opcion valida");
            }
        } while (opcion != 5);
    }

    public void registrarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
    System.out.print("Ingrese el nombre del jugador: ");
    String nombre = scanner.next();
    System.out.print("Ingrese el pais del jugador: ");
    String pais = scanner.next();
    System.out.print("Ingrese la cantidad de errores del jugador: ");
    int errores = scanner.nextInt();
    System.out.print("Ingrese la cantidad de aces del jugador: ");
    int aces = scanner.nextInt();
    System.out.print("Ingrese el total de servicios del jugador: ");
    int totalServicios = scanner.nextInt();

    System.out.println("Seleccione el tipo de jugador:");
    System.out.println("1. Libero");
    System.out.println("2. Pasador");
    System.out.println("3. Auxiliar/Opuesto");
    int tipoJugador = scanner.nextInt();

    Jugador jugador = null;

    if (tipoJugador == 1) {
        System.out.print("Ingrese la cantidad de recibos del libero: ");
        int recibos = scanner.nextInt();
        jugador = new Libero(nombre, pais, errores, aces, totalServicios, recibos);
    } else if (tipoJugador == 2) {
        System.out.print("Ingrese la cantidad de pases del pasador: ");
        int pases = scanner.nextInt();
        System.out.print("Ingrese la cantidad de fintas del pasador: ");
        int fintas = scanner.nextInt();
        jugador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas);
    } else if (tipoJugador == 3) {
        System.out.print("Ingrese la cantidad de ataques del auxiliar/opuesto: ");
        int ataques = scanner.nextInt();
        System.out.print("Ingrese la cantidad de bloqueos efectivos del auxiliar/opuesto: ");
        int bloqueosEfectivos = scanner.nextInt();
        System.out.print("Ingrese la cantidad de bloqueos fallidos del auxiliar/opuesto: ");
        int bloqueosFallidos = scanner.nextInt();
        jugador = new AuxiliarOpuesto(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
    }

    jugadores.add(jugador);
    System.out.println("Jugador registrado con exito.");
    }

    public void mostrarJugadores(ArrayList<Jugador> jugadores) {
    System.out.println("Lista de Jugadores Inscritos:");
    
    for (Jugador jugador : jugadores) {
        System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Pais: " + jugador.getPais());
        System.out.println("Errores: " + jugador.getErrores());
        System.out.println("Aces: " + jugador.getAces());
        System.out.println("Total de Servicios: " + jugador.getTotalServicios());

        // Comprobar el tipo de jugador para mostrar datos especificos
        if (jugador instanceof Libero) {
            Libero libero = (Libero) jugador;
            System.out.println("Recibos: " + libero.getRecibos());
        } else if (jugador instanceof Pasador) {
            Pasador pasador = (Pasador) jugador;
            System.out.println("Pases: " + pasador.getPases());
            System.out.println("Fintas: " + pasador.getFintas());
        } else if (jugador instanceof AuxiliarOpuesto) {
            AuxiliarOpuesto auxiliarOpuesto = (AuxiliarOpuesto) jugador;
            System.out.println("Ataques: " + auxiliarOpuesto.getAtaques());
            System.out.println("Bloqueos Efectivos: " + auxiliarOpuesto.getBloqueosEfectivos());
            System.out.println("Bloqueos Fallidos: " + auxiliarOpuesto.getBloqueosFallidos());
        }
        
        System.out.println("Efectividad: " + jugador.calcularEfectividad());
        System.out.println("------------");
    }
    }

    public void mostrarMejoresLiberos(ArrayList<Jugador> jugadores) {
    // Filtrar y ordenar la lista de jugadores para obtener solo a los liberos
    List<Libero> liberos = jugadores.stream()
        .filter(jugador -> jugador instanceof Libero)
        .map(jugador -> (Libero) jugador)
        .collect(Collectors.toList());

    // Ordenar la lista de liberos por efectividad en orden descendente
    Collections.sort(liberos, (libero1, libero2) -> Double.compare(libero2.calcularEfectividad(), libero1.calcularEfectividad()));

    System.out.println("Los 3 Mejores Liberos:");

    int contador = 0;
    for (Libero libero : liberos) {
        System.out.println("Nombre: " + libero.getNombre());
        System.out.println("Efectividad: " + libero.calcularEfectividad());
        System.out.println("------------");
        
        contador++;
        if (contador >= 3) {
            break; // Mostrar solo los 3 mejores liberos
        }
    }
    }

    public void contarPasadoresEfectivos(ArrayList<Jugador> jugadores) {
    int contadorPasadoresEfectivos = 0;

    for (Jugador jugador : jugadores) {
        if (jugador instanceof Pasador) {
            Pasador pasador = (Pasador) jugador;
            if (pasador.calcularEfectividad() > 80.0) {
                contadorPasadoresEfectivos++;
            }
        }
    }

    System.out.println("Cantidad de Pasadores con efectividad superior al 80%: " + contadorPasadoresEfectivos);
    }

    public static void main(String[] args) {
        TorneoVoleibol torneo = new TorneoVoleibol();
        torneo.menu();
    }
}