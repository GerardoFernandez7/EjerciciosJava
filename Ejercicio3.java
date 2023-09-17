/**
* FileName: Ejercicio3
* Author: Gerardo Fernandez
* Date: 6/9/2023
* Description: Este programa se encarga de recopilar las notas de los estudiantes, y las sedes en las que
 estos estan basados en su universidad, ademas, hace un analisis estadistico con todos los datos.
*/ 

package Modulo1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio3 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
    Universidad universidad = new Universidad();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("==== Menú Principal ====");
        System.out.println("1. Agregar Sede");
        System.out.println("2. Registrar Estudiante y Agregar Notas");
        System.out.println("3. Mostrar Estadísticas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre de la sede: ");
                String nombreSede = scanner.nextLine();
                universidad.agregarSede(nombreSede);
                System.out.println("Sede " + nombreSede + " agregada.");
                break;
            case 2:
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombreEstudiante = scanner.nextLine();
                System.out.print("Ingrese el apellido del estudiante: ");
                String apellidoEstudiante = scanner.nextLine();
                System.out.print("Ingrese el correo electrónico del estudiante: ");
                String correoEstudiante = scanner.nextLine();
                System.out.print("Ingrese el ID del estudiante: ");
                int idEstudiante = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Ingrese el nombre de la sede donde desea registrar al estudiante: ");
                String sedeEstudiante = scanner.nextLine();

                Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, correoEstudiante, idEstudiante);
                universidad.registrarEstudianteEnSede(nuevoEstudiante, sedeEstudiante);

                // Agregar notas al estudiante
                System.out.println("Ingrese las notas para el estudiante en las siguientes materias:");
                for (String materia : Estudiante.MATERIAS) {
                    System.out.print(materia + ": ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea
                    nuevoEstudiante.agregarNota(materia, nota);
                }
                System.out.println("Estudiante registrado en la sede " + sedeEstudiante + ".");
                break;
            case 3:
                mostrarEstadisticas(universidad);
                break;
            case 4:
                System.out.println("Saliendo del programa.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }


    private static void mostrarEstadisticas(Universidad universidad) {
        for (Sede sede : universidad.getSedes().values()) {
            System.out.println("Estadísticas para la sede " + sede.getNombreSede() + ":");
            List<Estudiante> estudiantesRegistrados = sede.getEstudiantesRegistrados();
            System.out.println("Cantidad de alumnos registrados: " + estudiantesRegistrados.size());
            System.out.println("Estadísticas de notas:");
    
            for (String materia : Estudiante.MATERIAS) {
                double[] notas = new double[estudiantesRegistrados.size()];
    
                int i = 0;
                for (Estudiante estudiante : estudiantesRegistrados) {
                    double nota = estudiante.getNotas().get(materia);
                    notas[i] = nota;
                    i++;
                }
    
                double promedio = calcularPromedio(notas);
                double mediana = calcularMediana(notas);
                double moda = calcularModa(notas);
                double desviacionEstandar = calcularDesviacionEstandar(notas);
                double notaMinima = calcularNotaMinima(notas);
                double notaMaxima = calcularNotaMaxima(notas);
    
                System.out.println("Materia: " + materia);
                System.out.println("Promedio: " + promedio);
                System.out.println("Mediana: " + mediana);
                System.out.println("Moda: " + moda);
                System.out.println("Desviación Estándar: " + desviacionEstandar);
                System.out.println("Nota Mínima: " + notaMinima);
                System.out.println("Nota Máxima: " + notaMaxima);
                System.out.println();
            }
        }
    }

    private static double calcularPromedio(double[] datos) {
        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        return suma / datos.length;
    }

    private static double calcularMediana(double[] datos) {
        Arrays.sort(datos);
        int n = datos.length;
        if (n % 2 == 0) {
            return (datos[n / 2 - 1] + datos[n / 2]) / 2.0;
        } else {
            return datos[n / 2];
        }
    }

    private static double calcularModa(double[] datos) {
        Map<Double, Integer> frecuencias = new HashMap<>();
        for (double dato : datos) {
            frecuencias.put(dato, frecuencias.getOrDefault(dato, 0) + 1);
        }
        double moda = 0;
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                moda = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }
        return moda;
    }

    private static double calcularDesviacionEstandar(double[] datos) {
        double promedio = calcularPromedio(datos);
        double sumaDeSquares = 0;
        for (double dato : datos) {
            sumaDeSquares += Math.pow(dato - promedio, 2);
        }
        double varianza = sumaDeSquares / datos.length;
        return Math.sqrt(varianza);
    }


private static double calcularNotaMinima(double[] datos) {
    double minima = datos[0];
    for (double dato : datos) {
        if (dato < minima) {
            minima = dato;
        }
    }
    return minima;
}

private static double calcularNotaMaxima(double[] datos) {
    double maxima = datos[0];
    for (double dato : datos) {
        if (dato > maxima) {
            maxima = dato;
        }
    }
    return maxima;
}
}
class Estudiante {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private int id;
    private Map<String, Double> notas; // Diccionario de notas, donde la clave es el nombre de la materia y el valor es la nota

    public static final List<String> MATERIAS = Arrays.asList("Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística");

    public Estudiante(String nombre, String apellido, String correoElectronico, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.id = id;
        this.notas = new HashMap<>(); // Inicializamos el diccionario de notas
        // Inicializamos las notas para las materias especificadas con valores predeterminados
        notas.put("Matemática", 0.0);
        notas.put("Lenguaje", 0.0);
        notas.put("Química", 0.0);
        notas.put("Física", 0.0);
        notas.put("Comprensión Lectora", 0.0);
        notas.put("Estadística", 0.0);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getId() {
        return id;
    }

    public Map<String, Double> getNotas() {
        return notas;
    }

    public void agregarNota(String materia, double nota) {
        if (notas.containsKey(materia)) {
            notas.put(materia, nota);
        } else {
            System.out.println("La materia " + materia + " no existe para este estudiante.");
        }
    }
}

class Sede {
private String nombreSede;
    private List<Estudiante> estudiantesRegistrados;

    public Sede(String nombreSede) {
        this.nombreSede = nombreSede;
        this.estudiantesRegistrados = new ArrayList<>();
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public List<Estudiante> getEstudiantesRegistrados() {
        return estudiantesRegistrados;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantesRegistrados.add(estudiante);
    }
}
 
class Universidad {
private Map<String, Sede> sedes;

    public Universidad() {
        this.sedes = new HashMap<>();
    }

    public Map<String, Sede> getSedes() {
        return sedes;
    }

    public void agregarSede(String nombreSede) {
        Sede nuevaSede = new Sede(nombreSede);
        sedes.put(nombreSede, nuevaSede);
    }

    public void registrarEstudianteEnSede(Estudiante estudiante, String nombreSede) {
        if (sedes.containsKey(nombreSede)) {
            Sede sede = sedes.get(nombreSede);
            sede.agregarEstudiante(estudiante);
        } else {
            System.out.println("La sede " + nombreSede + " no existe en la universidad.");
        }
    }
}