package Modulo1;
/**
* FileName: Ejercicio5
* Author: Gerardo Fernandez
* Date: 16/10/2023
* Description: Este programa permite registrar automaticamente a jugadores de un torneo internacional. Ademas, permite calcular la efectividad 
de los liberos y los pasadores.
*/ 

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase representa un torneo de voleibol y proporciona funcionalidades para agregar jugadores,
 * listar los mejores líberos y contar pasadores con efectividad superior al 80%.
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo("Ej5.csv");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Listar los tres mejores líberos");
            System.out.println("3. Cantidad de pasadores con efectividad > 80%");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = obtenerEnteroValidado(scanner);

            switch (opcion) {
                case 1:
                    System.out.println("\nSelecciona la posición del jugador:");
                    System.out.println("1. Libero");
                    System.out.println("2. Pasador");
                    System.out.println("3. Auxiliar Opuesto");
                    System.out.print("Ingresa la posición del jugador: ");
                    int posicionJugador = obtenerEnteroValidado(scanner);

                    System.out.print("Nombre del jugador: ");
                    String nombre = scanner.nextLine();

                    System.out.print("País del jugador: ");
                    String pais = scanner.nextLine();

                    System.out.print("Errores del jugador: ");
                    int errores = obtenerEnteroValidado(scanner);

                    System.out.print("Aces del jugador: ");
                    int aces = obtenerEnteroValidado(scanner);

                    System.out.print("Total de servicios del jugador: ");
                    int totalServicios = obtenerEnteroValidado(scanner);

                    if (posicionJugador == 1) {
                        System.out.print("Recibos efectivos del líbero: ");
                        int recibosEfectivos = obtenerEnteroValidado(scanner);

                        Libero libero = new Libero(nombre, pais, errores, aces, totalServicios);
                        libero.setRecibosEfectivos(recibosEfectivos);

                        torneo.agregarJugador(libero);
                    } else if (posicionJugador == 2) {
                        System.out.print("Pases del pasador: ");
                        int pases = obtenerEnteroValidado(scanner);

                        System.out.print("Fintas efectivas del pasador: ");
                        int fintasEfectivas = obtenerEnteroValidado(scanner);

                        Pasador pasador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas);

                        torneo.agregarJugador(pasador);
                    } else if (posicionJugador == 3) {
                        System.out.print("Ataques del auxiliar/opuesto: ");
                        int ataques = obtenerEnteroValidado(scanner);

                        System.out.print("Bloqueos efectivos del auxiliar/opuesto: ");
                        int bloqueosEfectivos = obtenerEnteroValidado(scanner);

                        System.out.print("Bloqueos fallidos del auxiliar/opuesto: ");
                        int bloqueosFallidos = obtenerEnteroValidado(scanner);

                        AuxiliarOpuesto auxiliarOpuesto = new AuxiliarOpuesto(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);

                        torneo.agregarJugador(auxiliarOpuesto);
                    } else {
                        System.out.println("Opción no válida. Introduce una posición válida.");
                    }
                    break;

                case 2:
                    torneo.MejoresLiberos();
                    break;

                case 3:
                    int cantidadPasadores = torneo.PasadoresConEfectividad80Plus();
                    System.out.println("Cantidad de pasadores con efectividad mayor al 80%: " + cantidadPasadores);
                    break;

                case 4:
                    scanner.close();
                    System.out.println("¡Hasta luego!");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Introduce una opción válida.");
            }
        }
    }

    // Método para obtener un entero validado
    private static int obtenerEnteroValidado(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        }
    }
}

/**
 * Esta clase representa un jugador de voleibol genérico con atributos comunes, como nombre, país, errores, aces y total de servicios.
 */
class Jugador {

private String nombre;
private String pais;
protected int errores;
protected int aces;
protected int totalServicios;

/**
     * Constructor para la clase Jugador.
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores del jugador.
     * @param aces Número de aces del jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     */
public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
    this.nombre = nombre;
    this.pais = pais;
    this.errores = errores;
    this.aces = aces;
    this.totalServicios = totalServicios;
}

/**
     * Obtiene el nombre del jugador.
     * @return Nombre del jugador.
     */
public String getNombre() {
        return nombre;
    }

/**
     * Obtiene el país del jugador.
     * @return País del jugador.
     */
public String getPais() {
    return pais;
}

/**
     * Obtiene el número de errores del jugador.
     * @return Número de errores del jugador.
     */
public int getErrores() {
    return errores;
}

/**
     * Obtiene el número de aces del jugador.
     * @return Número de aces del jugador.
     */
public int getAces() {
    return aces;
}

/**
     * Obtiene el total de servicios realizados por el jugador.
     * @return Total de servicios realizados por el jugador.
     */
public int getTotalServicios() {
    return totalServicios;
}

/**
     * Establece el nombre del jugador.
     * @param nombre Nombre del jugador.
     */
public void setNombre(String nombre) {
    this.nombre = nombre;
}

/**
     * Establece el país del jugador.
     * @param pais País del jugador.
     */
public void setPais(String pais) {
    this.pais = pais;
}

/**
     * Establece el número de errores del jugador.
     * @param errores Número de errores del jugador.
     */
public void setErrores(int errores) {
    this.errores = errores;
}

/**
     * Establece el número de aces del jugador.
     * @param aces Número de aces del jugador.
     */
public void setAces(int aces) {
    this.aces = aces;
}

/**
     * Establece el total de servicios realizados por el jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     */
public void setTotalServicios(int totalServicios) {
    this.totalServicios = totalServicios;
}

/**
     * Método para calcular la efectividad de acuerdo a la posición del jugador.
     * @return Valor de efectividad del jugador.
     */
    public float calcularEfectividad() {
        // Este método se sobrescribirá en las subclases (Libero, Pasador, AuxiliarOpuesto)
        return 0.0f;
}

}

/**
 * Esta clase representa a un jugador de posición "Libero" en el voleibol, con atributos específicos
 * como recibos efectivos y efectividad.
 */
class Libero extends Jugador{

private int recibosEfectivos;
private float efectividad;

/**
     * Constructor para la clase Libero.
     * @param nombre Nombre del líbero.
     * @param pais País del líbero.
     * @param errores Número de errores del líbero.
     * @param aces Número de aces del líbero.
     * @param totalServicios Total de servicios realizados por el líbero.
     */
public Libero(String nombre, String pais, int errores, int aces, int totalServicios) {
    super(nombre, pais, errores, aces, totalServicios);
}

    /**
     * Obtiene el número de recibos efectivos del líbero.
     * @return Número de recibos efectivos.
     */
    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    /**
     * Establece el número de recibos efectivos del líbero.
     * @param recibosEfectivos Número de recibos efectivos.
     */
    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * Obtiene el valor de efectividad del líbero.
     * @return Valor de efectividad del líbero.
     */
    public float getEfectividad() {
        return efectividad;
    }

    /**
     * Establece el valor de efectividad del líbero.
     * @param efectividad Valor de efectividad del líbero.
     */
    public void setEfectividad(float efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * Método para calcular la efectividad específica para los líberos.
     * @return Valor de efectividad del líbero.
     */
    @Override
    public float calcularEfectividad() {
        float efectividadRecibos = ((recibosEfectivos - errores) * 100.0f) / (recibosEfectivos + errores);
        float efectividadAces = (aces * 100.0f) / totalServicios;
        efectividad = (efectividadRecibos + efectividadAces) / 2;
        return efectividad;
    }
}

/**
 * Esta clase representa a un jugador de posición "Pasador" en el voleibol, con atributos específicos
 * como pases, fintas efectivas y efectividad.
 */
class Pasador extends Jugador{

    /**
     * Constructor para la clase Pasador.
     * @param nombre Nombre del pasador.
     * @param pais País del pasador.
     * @param errores Número de errores del pasador.
     * @param aces Número de aces del pasador.
     * @param totalServicios Total de servicios realizados por el pasador.
     * @param pases Número de pases realizados por el pasador.
     * @param fintasEfectivas Número de fintas efectivas realizadas por el pasador.
     */
public Pasador(String nombre, String pais, int errores, int aces, int totalServicios) {
        super(nombre, pais, errores, aces, totalServicios);
    
    }

private int pases;
private int fintasEfectivas;
private float efectividad;

public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Obtiene el número de pases realizados por el pasador.
     * @return Número de pases realizados.
     */
    public int getPases() {
        return pases;
    }

    /**
     * Establece el número de pases realizados por el pasador.
     * @param pases Número de pases realizados.
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * Obtiene el número de fintas efectivas realizadas por el pasador.
     * @return Número de fintas efectivas realizadas.
     */
    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    /**
     * Establece el número de fintas efectivas realizadas por el pasador.
     * @param fintasEfectivas Número de fintas efectivas realizadas.
     */
    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Obtiene el valor de efectividad del pasador.
     * @return Valor de efectividad del pasador.
     */
    public float getEfectividad() {
        return efectividad;
    }

    /**
     * Establece el valor de efectividad del pasador.
     * @param efectividad Valor de efectividad del pasador.
     */
    public void setEfectividad(float efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * Método para calcular la efectividad específica para los pasadores.
     * @return Valor de efectividad del pasador.
     */
    @Override
    public float calcularEfectividad() {
        float efectividadPasesFintas = ((pases + fintasEfectivas - errores) * 100.0f) / (pases + fintasEfectivas + errores);
        float efectividadAces = (aces * 100.0f) / totalServicios;
        efectividad = (efectividadPasesFintas + efectividadAces) / 2;
        return efectividad;
    }
}

/**
 * Esta clase representa a un jugador de posición "AuxiliarOpuesto" en el voleibol, con atributos específicos
 * como ataques, bloqueos efectivos, bloqueos fallidos y efectividad.
 */
class AuxiliarOpuesto extends Jugador {

    /**
     * Constructor para la clase AuxiliarOpuesto.
     * @param nombre Nombre del auxiliar/opuesto.
     * @param pais País del auxiliar/opuesto.
     * @param errores Número de errores del auxiliar/opuesto.
     * @param aces Número de aces del auxiliar/opuesto.
     * @param totalServicios Total de servicios realizados por el auxiliar/opuesto.
     * @param ataques Número de ataques realizados por el auxiliar/opuesto.
     * @param bloqueosEfectivos Número de bloqueos efectivos realizados por el auxiliar/opuesto.
     * @param bloqueosFallidos Número de bloqueos fallidos realizados por el auxiliar/opuesto.
     */
public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios) {
        super(nombre, pais, errores, aces, totalServicios);
    
    }

private int ataques;
private int bloqueosEfectivos;
private int bloqueosFallidos;
private float efectividad;

public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Obtiene el número de ataques realizados por el auxiliar/opuesto.
     * @return Número de ataques realizados.
     */
    public int getAtaques() {
        return ataques;
    }

    /**
     * Establece el número de ataques realizados por el auxiliar/opuesto.
     * @param ataques Número de ataques realizados.
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    /**
     * Obtiene el número de bloqueos efectivos realizados por el auxiliar/opuesto.
     * @return Número de bloqueos efectivos realizados.
     */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    /**
     * Establece el número de bloqueos efectivos realizados por el auxiliar/opuesto.
     * @param bloqueosEfectivos Número de bloqueos efectivos realizados.
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * Obtiene el número de bloqueos fallidos realizados por el auxiliar/opuesto.
     * @return Número de bloqueos fallidos realizados.
     */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    /**
     * Establece el número de bloqueos fallidos realizados por el auxiliar/opuesto.
     * @param bloqueosFallidos Número de bloqueos fallidos realizados.
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Obtiene el valor de efectividad del auxiliar/opuesto.
     * @return Valor de efectividad del auxiliar/opuesto.
     */
    public float getEfectividad() {
        return efectividad;
    }

    /**
     * Establece el valor de efectividad del auxiliar/opuesto.
     * @param efectividad Valor de efectividad del auxiliar/opuesto.
     */
    public void setEfectividad(float efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * Método para calcular la efectividad específica para los auxiliares/opuestos.
     * @return Valor de efectividad del auxiliar/opuesto.
     */
    @Override
    public float calcularEfectividad() {
        float efectividadAtaquesBloqueos = ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100.0f) / (ataques + bloqueosEfectivos + bloqueosFallidos + errores);
        float efectividadAces = (aces * 100.0f) / totalServicios;
        efectividad = (efectividadAtaquesBloqueos + efectividadAces) / 2;
        return efectividad;
    }
    
}

/**
 * Esta clase representa un torneo de voleibol y proporciona funcionalidades para agregar jugadores,
 * listar los mejores líberos y contar pasadores con efectividad superior al 80%.
 */
class Torneo {

private List<Jugador> jugadores;
private String ArchivoCSV;

    /**
     * Constructor para la clase Torneo.
     * @param ArchivoCSV Nombre del archivo CSV utilizado para cargar/guardar datos.
     */
    public Torneo(String ArchivoCSV) {
    this.ArchivoCSV = ArchivoCSV;
    jugadores = new ArrayList<>();
    cargarDesdeCSV();
}    

    /**
     * Agrega un jugador de tipo AuxiliarOpuesto al torneo.
     * @param auxiliarOpuesto Jugador de tipo AuxiliarOpuesto.
     */
    public void agregarJugador(AuxiliarOpuesto auxiliarOpuesto) {
        if (buscarJugador(auxiliarOpuesto.getNombre()) == null) {
            jugadores.add(auxiliarOpuesto);
        } else {
            // Si el jugador ya existe, actualiza sus datos
            actualizarJugador(auxiliarOpuesto);
        }
        guardarEnCSV();
    }

/**
     * Agrega un jugador de tipo Pasador al torneo.
     * @param pasador Jugador de tipo Pasador.
     */
public void agregarJugador(Pasador pasador) {
        if (buscarJugador(pasador.getNombre()) == null) {
            jugadores.add(pasador);
        } else {
            // Si el jugador ya existe, actualiza sus datos
            actualizarJugador(pasador);
        }
        guardarEnCSV();
    }

/**
     * Agrega un jugador de tipo Libero al torneo.
     * @param libero Jugador de tipo Libero.
     */
public void agregarJugador(Libero libero) {
        if (buscarJugador(libero.getNombre()) == null) {
            jugadores.add(libero);
        } else {
            // Si el jugador ya existe, actualiza sus datos
            actualizarJugador(libero);
        }
        guardarEnCSV();
    }

/**
     * Obtiene la lista de jugadores en el torneo.
     * @return Lista de jugadores en el torneo.
     */
    public void agregarJugador(Jugador jugador) {
    Jugador jugadorExistente = buscarJugador(jugador.getNombre());
    if (jugadorExistente != null) {
        // Actualiza los datos del jugador existente
        actualizarJugador(jugador);
    } else {
        // Agrega el nuevo jugador a la lista
        jugadores.add(jugador);
    }
}

    /**
 * Busca un jugador en la lista de jugadores por su nombre.
 *
 * @param nombre El nombre del jugador a buscar.
 * @return El jugador encontrado o null si no se encontró ningún jugador con el nombre especificado.
 */
    private Jugador buscarJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    /**
 * Actualiza los datos de un jugador existente en la lista de jugadores.
 *
 * @param nuevoJugador El jugador con los datos actualizados.
 */
    private void actualizarJugador(Jugador nuevoJugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugadorExistente = jugadores.get(i);
            if (jugadorExistente.getNombre().equalsIgnoreCase(nuevoJugador.getNombre())) {
                // Actualiza los datos del jugador existente
                jugadores.set(i, nuevoJugador);
                break;
            }
        }
    }
    
    /**
 * Encuentra y muestra los tres mejores líberos en la lista de jugadores.
 */
    public void MejoresLiberos() {
        List<Libero> liberos = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                liberos.add((Libero) jugador);
            }
        }
        
        // Ordena la lista de liberos por efectividad en orden descendente
        liberos.sort(Comparator.comparing(Libero::calcularEfectividad).reversed());
        System.out.println("Los tres mejores líberos son:");
        int contador = 0;
        for (Libero libero : liberos) {
            if (contador < 3) {
                System.out.println("Nombre: " + libero.getNombre());
                System.out.println("Efectividad: " + libero.calcularEfectividad());
                System.out.println("------------------------------");
                contador++;
            } else {
                break;
            }
        }
    }

    /**
 * Calcula la cantidad de pasadores con efectividad mayor al 80% en la lista de jugadores.
 *
 * @return La cantidad de pasadores con efectividad mayor al 80%.
 */
    public int PasadoresConEfectividad80Plus() {
        int pasadoresConEfectividad80Plus = 0;
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                Pasador pasador = (Pasador) jugador;
                if (pasador.calcularEfectividad() > 80.0f) {
                    pasadoresConEfectividad80Plus++;
                }
            }
        }
        return pasadoresConEfectividad80Plus;
    }

    /**
     * Guarda los datos de los jugadores en un archivo CSV.
     */
    public void guardarEnCSV() {
    try {
        FileWriter writer = new FileWriter(ArchivoCSV);
        writer.write("Nombre,Pais,Errores,Aces,TotalServicios,RecibosEfectivos,Pases,FintasEfectivas,Ataques,BloqueosEfectivos,BloqueosFallidos,Efectividad\n");

        for (Jugador jugador : jugadores) {
            writer.write(jugador.getNombre() + "," + jugador.getPais() + "," + jugador.getErrores() + "," + jugador.getAces() + ","
                    + jugador.getTotalServicios() + ",");

            if (jugador instanceof Libero) {
                Libero libero = (Libero) jugador;
                writer.write(libero.getRecibosEfectivos() + ",,,,,," + libero.calcularEfectividad() + "\n");
            } else if (jugador instanceof Pasador) {
                Pasador pasador = (Pasador) jugador;
                writer.write("," + pasador.getPases() + "," + pasador.getFintasEfectivas() + ",,," + pasador.calcularEfectividad() + "\n");
            } else if (jugador instanceof AuxiliarOpuesto) {
                AuxiliarOpuesto auxiliarOpuesto = (AuxiliarOpuesto) jugador;
                writer.write(",,," + auxiliarOpuesto.getAtaques() + "," + auxiliarOpuesto.getBloqueosEfectivos() + ","
                        + auxiliarOpuesto.getBloqueosFallidos() + "," + auxiliarOpuesto.calcularEfectividad() + "\n");
            }
        }

        writer.close();
        System.out.println("Datos guardados en " + ArchivoCSV);
    } catch (IOException e) {
        System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
    }
}


/**
     * Carga los datos de los jugadores desde un archivo CSV.
     */
    private void cargarDesdeCSV() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(ArchivoCSV));
        String linea;

        reader.readLine();  // Lee y descarta la primera línea, que contiene encabezados

        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length == 12) {
                String nombre = datos[0];
                String pais = datos[1];
                int errores = Integer.parseInt(datos[2]);
                int aces = Integer.parseInt(datos[3]);
                int totalServicios = Integer.parseInt(datos[4]);

                if (datos[5].isEmpty() && datos[6].isEmpty() && datos[7].isEmpty() && datos[8].isEmpty() && datos[9].isEmpty()) {
                    Libero libero = new Libero(nombre, pais, errores, aces, totalServicios);
                    libero.setRecibosEfectivos(Integer.parseInt(datos[5]));
                    jugadores.add(libero);
                } else if (datos[5].isEmpty() && datos[9].isEmpty()) {
                    int pases = Integer.parseInt(datos[6]);
                    int fintasEfectivas = Integer.parseInt(datos[7]);
                    Pasador pasador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas);
                    jugadores.add(pasador);
                } else {
                    int ataques = Integer.parseInt(datos[8]);
                    int bloqueosEfectivos = Integer.parseInt(datos[9]);
                    int bloqueosFallidos = Integer.parseInt(datos[10]);
                    AuxiliarOpuesto auxiliarOpuesto = new AuxiliarOpuesto(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
                    jugadores.add(auxiliarOpuesto);
                }
            }
        }
        reader.close();
        System.out.println("Datos cargados desde " + ArchivoCSV);
    } catch (IOException e) {
        System.err.println("Error al cargar el archivo CSV: " + e.getMessage());
    }
}
}