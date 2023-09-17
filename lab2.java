/*
* FileName: lab2
* Author: Gerardo Fernandez
* Date: 12/9/2023
* Description: Este programa soluciona el problema que tiene la universidad con la asignacion de salones, especificamente el laboratorio 
de computación avanzada CIT 411.
*/ 

package Modulo1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase principal del programa que gestiona la asignación de cursos en el laboratorio.
 */
public class lab2 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
    Laboratorio laboratorio = new Laboratorio(30);
    Curso curso = new Curso(2008,"Programación Orientada a Objetos",2,"Jueves","papa",30,"Carlos");
    Profesor profesor = new Profesor("Carlos", 22873,"carlos@gmail.com", 37432101);
    HorarioDisponible horario = new HorarioDisponible("Jueves", "14:00", "16:00");
    HorarioDisponible nuevoHorario = new HorarioDisponible("Lunes", "10:00", "12:00");
    Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Asignar curso al horario del laboratorio");
            System.out.println("2. Visualizar información del curso en un horario específico");
            System.out.println("3. Eliminar un curso asignado en un horario específico");
            System.out.println("4. Cambiar horario de un curso");
            System.out.println("5. Mostrar profesor en un día y horario específico");
            System.out.println("6. Mostrar días y horarios en los que un profesor está al frente");
            System.out.println("7. Mostrar responsabilidad de los profesores en el laboratorio");
            System.out.println("8. Poner disponible el laboratorio para un nuevo semestre");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    laboratorio.asignarCurso(curso, horario);
                    break;
                case 2:
                    curso.mostrarInformacion();
                    break;
                case 3:
                    curso.eliminarHorario(null);
                    break;
                case 4:
                    curso.cambiarHorario(nuevoHorario, laboratorio);
                    break;
                case 5:
                System.out.print("Ingrese el día (por ejemplo, 'Lunes'): ");
                String dia = scanner.nextLine();
                System.out.print("Ingrese la hora de inicio (por ejemplo, '14:00'): ");
                String horaInicio = scanner.nextLine();
                System.out.print("Ingrese la hora de fin (por ejemplo, '16:00'): ");
                String horaFin = scanner.nextLine();
            
                HorarioDisponible horarioEspecifico = new HorarioDisponible(dia, horaInicio, horaFin);
                laboratorio.mostrarProfesorEnHorarioEspecifico(horarioEspecifico);
                break;
                case 6:
                    profesor.agregarCursos(curso);
                    profesor.mostrarHorariosDeLab(); 
                    break;
                case 7:
                    profesor.calcularResponsabilidad();
                    break;
                case 8:
                    laboratorio.nuevoSemestre();
                    break;
                case 0:
                System.out.println("Saliendo del programa.");
                scanner.close();
                System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

/**
 * Clase que representa a un profesor.
 */

class Profesor {

private String nombre;
private int carnet;
private String correo;
private int tel;
private ArrayList<Curso> cursos;

 /**
     * Constructor de la clase Profesor.
     * @param nombre Nombre del profesor.
     * @param carnet Carnet del profesor.
     * @param correo Correo electrónico del profesor.
     * @param tel Número de teléfono del profesor.
     */
public Profesor(String nombre, int carnet, String correo, int tel) {
    this.nombre = nombre;
    this.carnet = carnet;
    this.correo = correo;
    this.tel = tel;
    this.cursos = new ArrayList<Curso>();
}

/**
     * Obtiene el nombre del profesor.
     * @return Nombre del profesor.
     */
public String getNombre() {
        return nombre;
}

/**
     * Obtiene el carnet del profesor.
     * @return Carnet del profesor.
     */
public int getCarnet() {
    return carnet;
}

/**
     * Obtiene el correo electrónico del profesor.
     * @return Correo electrónico del profesor.
     */
public String getCorreo() {
    return correo;
}


    /**
     * Obtiene el número de teléfono del profesor.
     * @return Número de teléfono del profesor.
     */
public int getTel() {
    return tel;
}

 /**
     * Agrega un curso a la lista de cursos del profesor.
     * @param curso Curso a agregar.
     */
public void agregarCursos(Curso curso) {
        cursos.add(curso);
    }

    /**
     * Muestra los horarios de laboratorio asignados al profesor.
     */
void mostrarHorariosDeLab() {
    System.out.println("Horarios de laboratorio para el Profesor " + nombre + ":");
    for (Curso curso : cursos) {
        System.out.println("Curso: " + curso.getNombre());
        for (HorarioDisponible horario : curso.getHorarios()) {
            System.out.println("Día: " + horario.getDiaSemana() + ", Hora: " + horario.getHoraInicio() + " - " + horario.getHoraFin());
        }
    }
}

/**
     * Calcula la responsabilidad del profesor en el laboratorio.
     */
void calcularResponsabilidad() {
 int totalHorariosPosibles = 5 * 14; // 5 días a la semana, 14 horas por día (de 7 am a 9 pm)
        int totalHorariosAsignados = 10;

        for (Curso curso : cursos) {
            totalHorariosAsignados += curso.getHorarios().size();
        }

        double porcentajeResponsabilidad = (double) totalHorariosAsignados / totalHorariosPosibles * 100;

        System.out.println("Responsabilidad del Profesor " + nombre + ": " + porcentajeResponsabilidad + "%");
    }



    
/**
     * Obtiene la lista de cursos del profesor.
     * @return Lista de cursos del profesor.
     */
public ArrayList<Curso> getCursos() {
        return cursos;
    }
}

/**
 * Clase que representa un horario disponible.
 */
class HorarioDisponible {

private String diaSemana;
private String horaInicio;
private String horaFin;

/**
     * Constructor de la clase HorarioDisponible.
     * @param diaSemana Día de la semana del horario.
     * @param horaInicio Hora de inicio del horario.
     * @param horaFin Hora de fin del horario.
     */
public HorarioDisponible(String diaSemana, String horaInicio, String horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el día de la semana del horario.
     * @return Día de la semana del horario.
     */
public String getDiaSemana() {
    return diaSemana;
}

/**
     * Obtiene la hora de inicio del horario.
     * @return Hora de inicio del horario.
     */
public String getHoraInicio() {
    return horaInicio;
}

/**
     * Obtiene la hora de fin del horario.
     * @return Hora de fin del horario.
     */
public String getHoraFin() {
    return horaFin;
}

}

/**
 * Clase que representa un curso.
 */
class Curso {

private int codigo;
private String nombre;
private int periodosPorDia;
private String diaSemana;
private String horario;
private int cantidadEstudiantes;
private String profesor;
private ArrayList<HorarioDisponible> horarios;
private ArrayList<Curso> cursosAsignados;

/**
     * Constructor de la clase Curso.
     * @param codigo Código del curso.
     * @param nombre Nombre del curso.
     * @param periodosPorDia Número de periodos por día del curso.
     * @param diaSemana Día de la semana del curso.
     * @param horario Horario del curso.
     * @param cantidadEstudiantes Cantidad de estudiantes inscritos en el curso.
     * @param profesor Profesor asignado al curso.
     */
public Curso(int codigo, String nombre, int periodosPorDia, String diaSemana, String horario, int cantidadEstudiantes, String profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.periodosPorDia = periodosPorDia;
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.profesor = profesor;
        this.horarios = new ArrayList<HorarioDisponible>();
        this.cursosAsignados = new ArrayList<Curso>();
    }

    /**
     * Obtiene el código del curso.
     * @return Código del curso.
     */
public int getCodigo() {
    return codigo;
}

/**
     * Obtiene el nombre del curso.
     * @return Nombre del curso.
     */
public String getNombre() {
    return nombre;
}

/**
     * Obtiene el número de periodos por día del curso.
     * @return Número de periodos por día del curso.
     */
public int getPeriodosPorDia() {
    return periodosPorDia;
}

/**
     * Obtiene el día de la semana del curso.
     * @return Día de la semana del curso.
     */
public String getDiaSemana() {
    return diaSemana;
}

/**
     * Obtiene el horario del curso.
     * @return Horario del curso.
     */
public String getHorario() {
    return horario;
}

/**
     * Obtiene la cantidad de estudiantes inscritos en el curso.
     * @return Cantidad de estudiantes inscritos en el curso.
     */
public int getCantidadEstudiantes() {
    return cantidadEstudiantes;
}

/**
     * Obtiene el profesor asignado al curso.
     * @return Profesor asignado al curso.
     */
public String getProfesor() {
    return profesor;
}

/**
     * Obtiene la lista de horarios asignados al curso.
     * @return Lista de horarios asignados al curso.
     */
public ArrayList<HorarioDisponible> getHorarios() {
        return horarios;
    }

    /**
     * Agrega un horario al curso.
     * @param horario Horario a agregar.
     */
void agregarHorario(HorarioDisponible horario) {
    horarios.add(horario);
}

/**
     * Asigna un horario al curso si el laboratorio está disponible y la capacidad es suficiente.
     * @param nuevoHorario Horario a asignar.
     * @param laboratorio Laboratorio donde se realizará la asignación.
     */
void asignarHorario(HorarioDisponible nuevoHorario, Laboratorio laboratorio) {
    // Verifica si el laboratorio está disponible en el nuevo horario
    if (laboratorio.esHorarioDisponible(nuevoHorario)) {
        // Verifica si la cantidad de estudiantes inscritos es menor o igual a la capacidad del laboratorio
        if (cantidadEstudiantes <= laboratorio.getCantCompus() * 2) {
            // Asigna el nuevo horario al curso
            agregarHorario(nuevoHorario);
            System.out.println("Horario asignado con éxito.");
        } else {
            System.out.println("Error: Exceso de estudiantes para el nuevo horario.");
        }
    } else {
        System.out.println("Error: El laboratorio no está disponible en el nuevo horario.");
    }
}

/**
     * Cambia el horario del curso si el laboratorio está disponible y la capacidad es suficiente.
     * @param nuevoHorario Horario a asignar.
     * @param laboratorio Laboratorio donde se realizará la asignación.
     */
void cambiarHorario(HorarioDisponible nuevoHorario, Laboratorio laboratorio) {
    // Verifica si el laboratorio está disponible en el nuevo horario
    if (laboratorio.esHorarioDisponible(nuevoHorario)) {
        // Verifica si la cantidad de estudiantes inscritos es menor o igual a la capacidad del laboratorio
        if (cantidadEstudiantes <= laboratorio.getCantCompus() * 2) {
            // Elimina los horarios anteriores y asigna el nuevo horario
            horarios.clear();
            agregarHorario(nuevoHorario);
            System.out.println("Horario cambiado con éxito.");
        } else {
            System.out.println("Error: Exceso de estudiantes para el nuevo horario.");
        }
    } else {
        System.out.println("Error: El laboratorio no está disponible en el nuevo horario.");
    }
}

/**
     * Muestra la información del curso.
     */
void mostrarInformacion() {
    System.out.println("Información del Curso:");
    System.out.println("Código: " + codigo);
    System.out.println("Nombre: " + nombre);
    System.out.println("Períodos por Día: " + periodosPorDia);
    System.out.println("Cantidad de Estudiantes: " + cantidadEstudiantes);
    System.out.println("Profesor: " + profesor);
    System.out.println("Horarios Asignados:");
    for (HorarioDisponible horario : horarios) {
        System.out.println("Día: " + horario.getDiaSemana() + ", Hora: " + horario.getHoraInicio());
    }
}

/**
     * Valida si la capacidad de estudiantes inscritos en el curso es mayor que la capacidad del laboratorio.
     * @param laboratorio Laboratorio donde se realiza la validación.
     */
void validarCapacidadEstudiantes(Laboratorio laboratorio) {
    // Verifica si la cantidad de estudiantes inscritos es mayor que la capacidad del laboratorio
    if (cantidadEstudiantes > laboratorio.getCantCompus() * 2) {
        System.out.println("Error: Exceso de estudiantes en el curso. No se puede asignar.");
    }
}

/**
     * Verifica si el curso tiene un horario específico.
     * @param horario Horario a verificar.
     * @return true si el curso tiene el horario, false en caso contrario.
     */
public boolean tieneHorario(HorarioDisponible horario) {
    for (HorarioDisponible horarioAsignado : horarios) {
        if (horarioAsignado.equals(horario)) {
            return true;
        }
    }
    return false;
}

/**
     * Elimina un horario del curso.
     * @param horario Horario a eliminar.
     */
public void eliminarHorario(HorarioDisponible horario) {
    // Elimina el horario del curso, sin importar si está asignado o no
    horarios.remove(horario);
    System.out.println("Horario eliminado del curso.");
}

}

/**
 * Clase que representa un laboratorio.
 */
class Laboratorio {

private ArrayList<HorarioDisponible> horarioDisp;
private int cantCompus;
private ArrayList<Curso> cursosAsignados; // Agrega esta lista

/**
     * Constructor de la clase Laboratorio.
     * @param cantCompus Cantidad de computadoras disponibles en el laboratorio.
     */
public Laboratorio(int cantCompus) {
    this.cantCompus = cantCompus;
    this.horarioDisp = new ArrayList<HorarioDisponible>();
    this.cursosAsignados = new ArrayList<Curso>(); // Inicializa la lista
}

/**
     * Obtiene la cantidad de computadoras disponibles en el laboratorio.
     * @return Cantidad de computadoras disponibles en el laboratorio.
     */

public int getCantCompus() {
    return cantCompus;
}

/**
     * Asigna un curso a un horario en el laboratorio si el horario está disponible.
     * @param curso Curso a asignar.
     * @param horario Horario donde se asignará el curso.
     */
public void asignarCurso(Curso curso, HorarioDisponible horario) {
    // Verificar si el horario está disponible
    if (esHorarioDisponible(horario)) {
        // Asignar el curso al horario en el laboratorio
        curso.agregarHorario(horario);
        // Agregar el horario a la lista de horarios asignados en el laboratorio
        horarioDisp.add(horario);
        System.out.println("Curso asignado al horario en el laboratorio.");
    } else {
        System.out.println("Error: El horario no está disponible en el laboratorio.");
    }
}

/**
     * Libera un horario en el laboratorio eliminando la asignación.
     * @param horario Horario a liberar.
     */
public void liberarHorario(HorarioDisponible horario) {
    // Verificar si el horario está asignado en el laboratorio
    if (horarioDisp.contains(horario)) {
        // Liberar el horario eliminando la asignación
        horarioDisp.remove(horario);
        System.out.println("Horario liberado en el laboratorio.");
    } else {
        System.out.println("Error: El horario no está asignado en el laboratorio.");
    }
}

/**
     * Muestra al profesor asignado a un horario en el laboratorio.
     * @param horario Horario a consultar.
     * @param cursosAsignados Arreglo de cursos asignados.
     */
public void mostrarProfesorEnHorario(HorarioDisponible horario, Curso[] cursosAsignados) {
    // Buscar el curso asignado a este horario
    for (HorarioDisponible asignado : horarioDisp) {
        if (asignado.equals(horario)) {
            // Encontrado el horario, ahora buscamos el curso
            for (Curso curso : cursosAsignados) {
                if (curso.tieneHorario(asignado)) {
                    // Encontrado el curso, mostramos al profesor
                    System.out.println("Profesor en el horario:");
                    System.out.println(curso.getProfesor());
                    return;
                }
            }
        }
    }
    // Si llegamos aquí, el horario no se encontró en el laboratorio
    System.out.println("Error: El horario no está asignado en el laboratorio.");
}

 /**
     * Inicia un nuevo semestre liberando todos los horarios en el laboratorio.
     */
public void nuevoSemestre() {
    // Limpiar todos los horarios asignados al inicio del nuevo semestre
    horarioDisp.clear();
    // Puedes realizar otras tareas relacionadas con el inicio de un nuevo semestre si es necesario.
    System.out.println("Nuevo semestre iniciado. Todos los horarios están disponibles.");
}

/**
     * Verifica si un horario está disponible en el laboratorio.
     * @param horario Horario a verificar.
     * @return true si el horario está disponible, false en caso contrario.
     */
boolean esHorarioDisponible(HorarioDisponible horario) {
    // Verificamos si el día de la semana coincide
    for (HorarioDisponible disponible : horarioDisp) {
        if (disponible.getDiaSemana().equalsIgnoreCase(horario.getDiaSemana())) {
            String horaInicioDisponible = disponible.getHoraInicio();
            String horaFinDisponible = disponible.getHoraFin();
            String horaInicioSolicitada = horario.getHoraInicio();
            String horaFinSolicitada = horario.getHoraFin();

            // Convertimos las horas a un formato comparable (por ejemplo, a minutos desde la medianoche)
            int horaInicioDisponibleMin = convertirHoraAMinutos(horaInicioDisponible);
            int horaFinDisponibleMin = convertirHoraAMinutos(horaFinDisponible);
            int horaInicioSolicitadaMin = convertirHoraAMinutos(horaInicioSolicitada);
            int horaFinSolicitadaMin = convertirHoraAMinutos(horaFinSolicitada);

            // Verificamos si hay superposición de horarios
            if (!(horaInicioSolicitadaMin >= horaFinDisponibleMin || horaFinSolicitadaMin <= horaInicioDisponibleMin)) {
                // Hay superposición de horarios
                return false;  // El horario no está disponible
            }
        }
    }
    return true;  // El horario está disponible
}

/**
     * Muestra al profesor asignado a un horario específico en el laboratorio.
     * @param horarioEspecifico Horario específico a consultar.
     */
int convertirHoraAMinutos(String hora) {
    String[] partesHora = hora.split(":");
    int horas = Integer.parseInt(partesHora[0]);
    int minutos = Integer.parseInt(partesHora[1]);
    return horas * 60 + minutos;
}

public void mostrarProfesorEnHorarioEspecifico(HorarioDisponible horario) {
    // Recorremos la lista de cursos asignados en el laboratorio
    for (Curso curso : cursosAsignados) {
        // Verificamos si el curso tiene el horario especificado
        if (curso.tieneHorario(horario)) {
            // Encontrado el curso, mostramos al profesor
            System.out.println("Profesor en el horario " + horario.getDiaSemana() + " de " + horario.getHoraInicio() + " a " + horario.getHoraFin() + ":");
            System.out.println(curso.getProfesor());
            return; // Terminamos la búsqueda
        }
    }
    // Si llegamos aquí, el horario no se encontró en el laboratorio
    System.out.println("No hay profesor asignado en el horario especificado.");
}
}