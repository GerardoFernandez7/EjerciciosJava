/**
* FileName: Ejercicio2
* Author: Gerardo Fernandez
* Date: 28/8/2023
* Description: Este programa se encarga de gestionar las reservas de habitaciones en un hotel. 
*/ 

package Modulo1;
import java.util.Scanner;

/**
 * Clase que representa a un cliente del hotel.
 */
class Cliente {

    private String nombre;
    private int visitasAlHotel;

    /**
     * Constructor de la clase Cliente.
     * @param nombre El nombre del cliente.
     */
    public Cliente(String nombre) {
        this.nombre = nombre;
        this.setVisitasAlHotel(0);
    }

    public int getVisitasAlHotel() {
        return visitasAlHotel;
    }

    public void setVisitasAlHotel(int visitasAlHotel) {
        this.visitasAlHotel = visitasAlHotel;
    }

    public String getNombre() {
        return null;
    }

    public void setPresupuesto(int presupuestoCliente) {
    }

    public void setCantidadPersonas(int cantidadPersonas) {
    }
}

/**
 * Clase que representa una habitación en el hotel.
 */
class Habitacion {

    private int numeroDeHabitacion;
    private int precio;
    private boolean disponibilidad;
    private String tipoDeHabitacion;
    private int capacidadMaxima;
    private Cliente clienteAsignado;

    /**
     * Constructor de la clase Habitación.
     * @param numero El número de la habitación.
     * @param precio El precio de la habitación.
     * @param tipo El tipo de habitación.
     * @param capacidad La capacidad máxima de la habitación.
     */
    public Habitacion(int numero, int precio, String tipo, int capacidad) {
        this.numeroDeHabitacion = numero;
        this.precio = precio;
        this.disponibilidad = true; 
        this.tipoDeHabitacion = tipo;
        this.capacidadMaxima = capacidad;
        this.clienteAsignado = null; 
    }

    public boolean asignarCliente(Cliente cliente) {
        if (cliente != null && disponibilidad) {
            this.clienteAsignado = cliente;
            this.disponibilidad = false;
            return true;
        }
        return false;
    }
}

class Hotel {

    private Habitacion[] habitacionesDisponibles;
    private Cliente[] clientesEnEspera;
    private int habitacionesDisponiblesIndex; // Índice para rastrear habitaciones disponibles

    /**
     * Constructor de la clase Hotel.
     * @param numHabitaciones El número total de habitaciones en el hotel.
     */
    public Hotel(int numHabitaciones) {
        this.habitacionesDisponibles = new Habitacion[numHabitaciones];
        this.clientesEnEspera = new Cliente[10]; // Tamaño de la lista de espera
    }

    public boolean recibirClienteYrealizarReservacion(Cliente cliente) {
        // Verificar si hay habitaciones disponibles
        if (habitacionesDisponiblesIndex > 0) {
            Habitacion habitacion = habitacionesDisponibles[habitacionesDisponiblesIndex - 1];
            
            // Intentar asignar la habitación al cliente
            if (habitacion.asignarCliente(cliente)) {
                // Habitación asignada, reducir el índice de habitaciones disponibles
                habitacionesDisponiblesIndex--;
                System.out.println("Habitación asignada al cliente: " + cliente.getNombre());
                return true;
            } else {
                // Agregar cliente a la lista de espera
                if (agregarClienteAlistaDeEspera(cliente)) {
                    System.out.println("Cliente agregado a la lista de espera: " + cliente.getNombre());
                } else {
                    System.out.println("Lista de espera llena. No se puede agregar al cliente: " + cliente.getNombre());
                }
            }
        } else {
            // Agregar cliente a la lista de espera
            if (agregarClienteAlistaDeEspera(cliente)) {
                System.out.println("Cliente agregado a la lista de espera: " + cliente.getNombre());
            } else {
                System.out.println("Lista de espera llena. No se puede agregar al cliente: " + cliente.getNombre());
            }
        }
        return false;
    }

    public boolean asignarClienteAhabitacion(Cliente cliente) {
        for (Habitacion habitacion : habitacionesDisponibles) {
            if (habitacion.asignarCliente(cliente)) {
                System.out.println("Cliente " + cliente.getNombre() + " reservo una habitacion ");
                System.out.println("Puede pasar al paso 2. Asignarse a habitacion");
                return true;
            }
        }
        System.out.println("No se pudo asignar una habitación al cliente: " + cliente.getNombre());
        return false;
    }

    public boolean agregarClienteAlistaDeEspera(Cliente cliente) {
        for (int i = 0; i < clientesEnEspera.length; i++) {
            if (clientesEnEspera[i] == null) {
                clientesEnEspera[i] = cliente;
                System.out.println("Cliente " + cliente.getNombre() + " agregado a la lista de espera.");
                return true;
            }
        }
        System.out.println("La lista de espera está llena. No se puede agregar al cliente: " + cliente.getNombre());
        return false;
    }

}

/**
 * Clase principal que contiene el método main para interactuar con el programa.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10);
        boolean realizarPaso1 = false;
        boolean seguirEnPrograma = true;
        Scanner scanner = new Scanner(System.in);

        while (seguirEnPrograma) {
            System.out.println("\n--+ Bienvenido al hotel Hampton +--\n");
            System.out.println("Que desea hacer?");
            System.out.println("1. Recibir huesped y realizar reservación");
            System.out.println("2. Asignar cliente a habitación");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción.");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.next();
                    System.out.print("Ingrese el presupuesto del cliente: ");
                    int presupuestoCliente = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de personas que desean hospedarse en la habitación: ");
                    int cantidadPersonas = scanner.nextInt();
                    System.out.println("Perfecto. Pudedes pasar al paso 2, asignarte a una habitacion");

                    Cliente cliente = new Cliente(nombreCliente);
                    realizarPaso1 = true;
                    break;
                case 2: 
                    if (! realizarPaso1) {
                        System.out.println("\nLo siento, pero primero debes realizar el paso 1.");
                    } else {                   
                    System.out.println("\nEl cliente cumple con las reglas que tiene el hotel. Proceda a seleccionar la habitacion que desea.");
                    System.out.println("Elija la habitación:");
                    System.out.println("1. Estándar");
                    System.out.println("2. Deluxe");
                    System.out.println("3. VIP");
                    int opcionHabitacion = scanner.nextInt();
                    
                    if (opcionHabitacion == 1) {
                        System.out.println("Agregado a la lista de espera");
                    } else if (opcionHabitacion == 2) {
                        System.out.println("Lo sentimos, el cliente debe haber venido al hotel al menos 5 veces antes de seleccionar esta opción.");
                        
                    } else if (opcionHabitacion == 3){
                        System.out.println("Lo sentimos, el cliente debe haber venido al hotel al menos 10 veces antes de seleccionar esta opción.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                }
                    break;
                case 3:
                    seguirEnPrograma = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}