/**
* FileName: Ejercicio4
* Author: Gerardo Fernandez
* Date: 24/9/2023
* Description: Este programa permite registrar a jugadores de un campeonato internacional. Ademas, permite calcular la efectividad 
de los porteros y los extremos.
*/ 

package Modulo1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

 /**
     * El método principal que inicia el programa.
     *
     * @param args
     */
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Campeonato campeonato = new Campeonato();

    while (true) {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar Jugador");
        System.out.println("2. Mostrar Jugadores");
        System.out.println("3. Obtener los 3 Mejores Porteros");
        System.out.println("4. Contar Extremos con Efectividad Mayor a 85%");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                agregarJugador(campeonato, scanner);
                break;
            case 2:
                campeonato.mostrarJugadores();
                break;
            case 3:
                obtenerMejoresPorteros(campeonato, scanner);
                break;
            case 4:
                contarExtremos(campeonato);
                break;
            case 5:
                System.out.println("Saliendo del programa.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}

/**
     * Permite al usuario agregar un jugador al campeonato.
     *
     * @param campeonato El campeonato al que se agregará el jugador.
     * @param scanner    El objeto Scanner para la entrada del usuario.
     */
private static void agregarJugador(Campeonato campeonato, Scanner scanner) {
    System.out.print("Nombre del jugador: ");
    String nombre = scanner.nextLine();

    System.out.print("País del jugador: ");
    String pais = scanner.nextLine();

    System.out.print("Faltas del jugador: ");
    int faltas = scanner.nextInt();

    System.out.print("Goles directos del jugador: ");
    int golesDir = scanner.nextInt();

    System.out.print("Total de lanzamientos del jugador: ");
    int totalLanzamientos = scanner.nextInt();

    scanner.nextLine(); // Consumir el salto de línea

    System.out.print("¿Es portero? (Sí/No): ");
    String Portero = scanner.nextLine().toLowerCase();

    if (Portero.equals("si")) {
        System.out.print("Paradas efectivas del portero: ");
        int paradasEfectivas = scanner.nextInt();

        System.out.print("Goles recibidos por el portero: ");
        int golesRecibidos = scanner.nextInt();

        campeonato.agregarJugador(new Portero(nombre, pais, faltas, golesDir, totalLanzamientos, paradasEfectivas, golesRecibidos));
    } else {
        System.out.print("Pases del extremo: ");
        int pases = scanner.nextInt();

        System.out.print("Asistencias efectivas del extremo: ");
        int asistenciasEfectivas = scanner.nextInt();

        campeonato.agregarJugador(new Extremo(nombre, pais, faltas, golesDir, totalLanzamientos, pases, asistenciasEfectivas));
    }

    System.out.println("Jugador agregado con éxito.");
}

 /**
     * Muestra los 3 mejores porteros en función de su efectividad.
     *
     * @param campeonato El campeonato del que se obtendrán los porteros.
     * @param scanner    El objeto Scanner para la entrada del usuario.
     */
private static void obtenerMejoresPorteros(Campeonato campeonato, Scanner scanner) {
    System.out.print("Los 3 mejores porteros son:\n");
    int cantidad = 3;
    List<Portero> mejoresPorteros = campeonato.obtenerMejoresPorteros(cantidad);
    for (Portero portero : mejoresPorteros) {
        System.out.println("Nombre: " + portero.getNombre());
        System.out.println("País: " + portero.getPais());
        System.out.println("Efectividad: " + portero.calcEfectividad() + "%\n");
    }
}

 /**
     * Cuenta la cantidad de extremos con efectividad mayor al 85%.
     *
     * @param campeonato El campeonato del que se contarán los extremos.
     */
private static void contarExtremos(Campeonato campeonato) {
    int cantidadExtremos = campeonato.contarExtremosConEfectividadMayorA85();
    System.out.println("Cantidad de extremos con efectividad mayor al 85%: " + cantidadExtremos);
}
}

/**
 * Clase base para representar a un jugador.
 */
class Jugador {

private String nombre;
private String pais;
private int faltas;
private int golesDir;
private int totalLanzamientos;


    /**
     * Constructor para crear un jugador.
     *
     * @param nombre          El nombre del jugador.
     * @param pais            El país del jugador.
     * @param faltas          La cantidad de faltas del jugador.
     * @param golesDir        La cantidad de goles directos del jugador.
     * @param totalLanzamientos El total de lanzamientos del jugador.
     */
public Jugador(String nombre, String pais, int faltas, int golesDir, int totalLanzamientos) {
    this.nombre = nombre;
    this.pais = pais;
    this.faltas = faltas;
    this.golesDir = golesDir;
    this.totalLanzamientos = totalLanzamientos;
}

// Getters y setters para los atributos de Jugador (nombre, país, faltas, golesDir, totalLanzamientos) aquí

    /**
     * Calcula la efectividad del jugador.
     *
     * @return La efectividad del jugador como un valor en porcentaje.
     */
public String getNombre() {
        return nombre;
    }

public String getPais() {
    return pais;
}

public int getFaltas() {
    return faltas;
}

public int getGolesDir() {
    return golesDir;
}

public int getTotalLanzamientos() {
    return totalLanzamientos;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setPais(String pais) {
    this.pais = pais;
}

public void setFaltas(int faltas) {
    this.faltas = faltas;
}

public void setGolesDir(int golesDir) {
    this.golesDir = golesDir;
}

public void setTotalLanzamientos(int totalLanzamientos) {
    this.totalLanzamientos = totalLanzamientos;
}
}

/**
 * Clase que representa a un portero, que es un tipo de jugador.
 */
class Portero extends Jugador{

private int paradasEfectivas;
private int golesRecibidos;

/**
     * Constructor para crear un portero.
     *
     * @param nombre          El nombre del portero.
     * @param pais            El país del portero.
     * @param faltas          La cantidad de faltas del portero.
     * @param golesDirectos   La cantidad de goles directos del portero.
     * @param totalLanzamientos El total de lanzamientos del portero.
     * @param paradasEfectivas  La cantidad de paradas efectivas del portero.
     * @param golesRecibidos    La cantidad de goles recibidos por el portero.
     */
public Portero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                int paradasEfectivas, int golesRecibidos) {
    super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
    this.paradasEfectivas = paradasEfectivas;
    this.golesRecibidos = golesRecibidos;
}

// Getters y setters para los atributos específicos de Portero (paradasEfectivas, golesRecibidos) aquí

    /**
     * Calcula la efectividad del portero.
     *
     * @return La efectividad del portero como un valor en porcentaje.
     */
public String getPais(String pais) {
    return pais;
}

public String getNombre(String nombre) {
    return nombre;
}

public int getParadasEfectivas() {
    return paradasEfectivas;
}

public int getGolesRecibidos() {
    return golesRecibidos;
}

public void setParadasEfectivas(int paradasEfectivas) {
    this.paradasEfectivas = paradasEfectivas;
}

public void setGolesRecibidos(int golesRecibidos) {
    this.golesRecibidos = golesRecibidos;
}

public double calcEfectividad() {
    double efectividad = ((paradasEfectivas - golesRecibidos) * 100.0) /
            (paradasEfectivas + golesRecibidos) + (getGolesDir() * 100.0) / getTotalLanzamientos();
    return efectividad;
}
}

/**
 * Clase que representa a un extremo, que es un tipo de jugador.
 */
class Extremo extends Jugador{

private int pases;
private int asistenciasEfectivas;

/**
     * Constructor para crear un extremo.
     *
     * @param nombre                El nombre del extremo.
     * @param pais                  El país del extremo.
     * @param faltas                La cantidad de faltas del extremo.
     * @param golesDirectos         La cantidad de goles directos del extremo.
     * @param totalLanzamientos     El total de lanzamientos del extremo.
     * @param pases                 La cantidad de pases del extremo.
     * @param asistenciasEfectivas  La cantidad de asistencias efectivas del extremo.
     */
public Extremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                int pases, int asistenciasEfectivas) {
    super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
    this.pases = pases;
    this.asistenciasEfectivas = asistenciasEfectivas;
}

// Getters y setters para los atributos específicos de Extremo (pases, asistenciasEfectivas) aquí

    /**
     * Calcula la efectividad del extremo.
     *
     * @return La efectividad del extremo como un valor en porcentaje.
     */
public int getPases() {
    return pases;
}

public int getAsistenciasEfectivas() {
    return asistenciasEfectivas;
}

public void setPases(int pases) {
    this.pases = pases;
}

public void setAsistenciasEfectivas(int asistenciasEfectivas) {
    this.asistenciasEfectivas = asistenciasEfectivas;
}

 // Getters y setters para los atributos específicos de Extremo (pases, asistenciasEfectivas) aquí

    /**
     * Calcula la efectividad del extremo.
     *
     * @return La efectividad del extremo como un valor en porcentaje.
     */
public double calcEfectividad() {
    double efectividad = (((pases + asistenciasEfectivas - getFaltas()) * 100.0) /
            (pases + asistenciasEfectivas + getFaltas())) + (getGolesDir() * 100.0) / getTotalLanzamientos();
    return efectividad;
}
}

/**
 * Clase que representa un campeonato de fútbol.
 */
class Campeonato {
private List<Jugador> jugadores;

    /**
     * Constructor para crear un campeonato.
     */
    public Campeonato() {
        jugadores = new ArrayList<>();
    }

    /**
     * Agrega un jugador al campeonato.
     *
     * @param jugador El jugador que se agregará al campeonato.
     */
    void agregarJugador(Jugador portero) {
        jugadores.add(portero);
    }

/**
 * Muestra la información de todos los jugadores en el campeonato, incluyendo su efectividad si es portero o extremo.
 */
void mostrarJugadores() {
for (Jugador jugador : jugadores) {
    System.out.println("Nombre: " + jugador.getNombre());
    System.out.println("País: " + jugador.getPais());
    System.out.println("Faltas: " + jugador.getFaltas());
    System.out.println("Goles Directos: " + jugador.getGolesDir());
    System.out.println("Total Lanzamientos: " + jugador.getTotalLanzamientos());
    
    // Verificar si es un Portero o Extremo antes de llamar a calcEfectividad()
    if (jugador instanceof Portero) {
        Portero portero = (Portero) jugador;
        System.out.println("Efectividad (Portero): " + portero.calcEfectividad() + "%");
    } else if (jugador instanceof Extremo) {
        Extremo extremo = (Extremo) jugador;
        System.out.println("Efectividad (Extremo): " + extremo.calcEfectividad() + "%");
    }

    System.out.println();
}
}

/**
     * Obtiene los mejores 3 porteros basados en su efectividad.
     *
     * @return Una lista de los mejores porteros.
     */
    public List<Portero> obtenerMejoresPorteros(int n) {
        List<Portero> mejoresPorteros = new ArrayList<>();
        List<Portero> todosPorteros = new ArrayList<>();

        // Filtrar y obtener solo los porteros
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Portero) {
                todosPorteros.add((Portero) jugador);
            }
        }

        // Ordenar los porteros por efectividad
        Collections.sort(todosPorteros, new Comparator<Portero>() {
            @Override
            public int compare(Portero p1, Portero p2) {
                double efectividad1 = p1.calcEfectividad();
                double efectividad2 = p2.calcEfectividad();
                return Double.compare(efectividad2, efectividad1); // Orden descendente
            }
        });

        // Tomar los primeros 3 porteros (los mejores)
        for (int i = 0; i < Math.min(n, todosPorteros.size()); i++) {
            mejoresPorteros.add(todosPorteros.get(i));
        }

        return mejoresPorteros;
    }

    /**
     * Cuenta la cantidad de extremos con efectividad mayor al 85%.
     *
     * @return La cantidad de extremos con efectividad mayor al 85%.
     */
    int contarExtremosConEfectividadMayorA85() {
        int contador = 0;

        for (Jugador jugador : jugadores) {
                    if (jugador instanceof Portero) {
            Portero portero = (Portero) jugador;
            System.out.println("Efectividad (Portero): " + portero.calcEfectividad() + "%");
        } else if (jugador instanceof Extremo) {
            Extremo extremo = (Extremo) jugador;
            System.out.println("Efectividad (Extremo): " + extremo.calcEfectividad() + "%");
        } else {
            System.out.println("No se puede calcular la efectividad para este jugador.");
        }

            }

        return contador;
    }
}