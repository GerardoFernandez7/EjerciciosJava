/**
* FileName: Ejercicio1
* Author: Gerardo Fernandez
* Date: 13/8/2023
* Description: Este es un programa de experimental, que administra el concierto de Taylor Swift "The Eras Tour" 
*/ 

package Modulo1;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa el concierto y su información asociada, así como la gestión de la venta de boletos.
 */

class Concierto {
    private int localidad1 = 10;
    private int localidad5 = 15;
    private int localidad10 = 17;
    private int opcion = 0;

    /**
     * Consulta la disponibilidad total de boletos y devuelve un reporte.
     * @return Reporte de disponibilidad total de boletos.
     */

    public void consultarDisponibilidadTotal() {
        System.out.println("\nEn la localidad 1 hay " + localidad1 + " boletos disponibles");
        System.out.println("En la localidad 5 hay " + localidad5 + " boletos disponibles");
        System.out.println("En la localidad 10 hay " + localidad10 + " boletos disponibles");
    }

    /**
     * Consulta la disponibilidad individual de una localidad y devuelve un reporte.
     * @param numeroLocalidad Número de la localidad a consultar.
     * @return Reporte de disponibilidad individual de la localidad.
     */

    public void consultarDisponibilidadIndividual() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelecciona una localidad");
        System.out.println("1. Localidad 1");
        System.out.println("2. Localidad 5");
        System.out.println("3. Localidad 10");
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("En la localidad 1 hay " + localidad1 + " boletos disponibles\n");
                break;
            case 2:
                System.out.println("En la localidad 5 hay " + localidad5 + " boletos disponibles\n");
                break;
            case 3:
                System.out.println("En la localidad 10 hay " + localidad10 + " boletos disponibles\n");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }

    }

    /**
     * Genera un reporte de caja con las ventas realizadas y devuelve el resultado.
     * @return Reporte de caja con las ventas realizadas.
     */

    public void reporteDeCaja() {
        System.out.println("\nEn la localidad 1 se han vendido 10 boletos");
        System.out.println("En la localidad 5 se han vendido 5 boletos");
        System.out.println("En la localidad 10 se han vendido 3 boleto");
        System.out.println("Por lo que se han generado 6500$");
    }
}

class Comprador {
    private String nombre;
    private String email;
    private int cantBoletos;
    public double presupuestoMax;
    private int ticket;

    /**
     * Recolecta los datos de compra del comprador.
     */

    public void solicitarCompra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("### Bienvenido a Eras Tour! ###\nLlene los siguientes datos para poder comprar su boleto");
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        email = scanner.nextLine();

        System.out.print("Ingrese la cantidad de boletos que desea comprar: ");
        cantBoletos = scanner.nextInt();

        System.out.print("Ingrese su presupuesto máximo: ");
        presupuestoMax = scanner.nextDouble();
    }

    public double getPresupuestoMax() {
        return presupuestoMax;
    }

    /**
     * Genera un número de ticket aleatorio.
     */

    public void generarTicket() {
        Random random = new Random();
        ticket = random.nextInt(15000) + 1;
    }

    /**
     * Valida si el ticket es apto para comprar.
     */

    public void validarTicket() {
        Random random = new Random();
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        if (ticket >= Math.min(a, b) && ticket <= Math.max(a, b)) {
            System.out.println("El ticket es apto para comprar.");
        } else {
            System.out.println("\nEl ticket no es apto para comprar, ya que, no se cumplen las validaciones de a y b. Intetelo de nuevo.\n");
            System.exit(0);
        }
    }

    /**
     * Método getter para obtener el número de ticket generado.
     * @return El número de ticket.
     */

    public int getTicket() {
        return ticket;
    }
}

class Localidad {
    private int numero;
    private int capacidad;
    private int boletosVendidos;

    /**
     * Constructor de la clase Localidad.
     * @param numero Número de la localidad.
     * @param precio Precio de la localidad.
     * @param capacidad Capacidad máxima de la localidad.
     */

    public Localidad(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    /**
     * Selecciona aleatoriamente la localidad para un ticket apto.
     */

    public void seleccionarAleatoriamente() {
        Random random = new Random();
        int[] availableLocalities = { 1, 5, 10 };
        int randomIndex = random.nextInt(availableLocalities.length);
        int localidadSeleccionada = availableLocalities[randomIndex];
        System.out.println("Localidad seleccionada: " + localidadSeleccionada);
    }

    /**
     * Valida si hay espacio disponible en la localidad.
     * @return `true` si hay espacio disponible, `false` si no.
     */

    public boolean validarEspacio() {
        return boletosVendidos < capacidad;
    }

    /**
     * Valida si hay boletos disponibles en la localidad.
     * @param cantidadBoletos Cantidad de boletos deseada por el comprador.
     * @return Cantidad de boletos disponibles para la venta.
     */

    public int validarDisponibilidad(int cantidadBoletos) {
        int boletosDisponibles = capacidad - boletosVendidos;
        return Math.min(boletosDisponibles, cantidadBoletos);
    }

    /**
     * Valida si el precio de la localidad es aceptable para el comprador.
     * @param presupuesto Presupuesto máximo del comprador.
     * @return `true` si el precio es aceptable, `false` si no.
     */

    public void validarPrecio (double presupuestoMax, int localidadSeleccionada ) {
        double precioLocalidad = 0;
        if (localidadSeleccionada == 1) {
            precioLocalidad = 100;
        } else if (localidadSeleccionada == 5) {
            precioLocalidad = 500;
        } else if (localidadSeleccionada == 10) {
            precioLocalidad = 1000;
        }

        if (precioLocalidad > presupuestoMax) {
            System.out.println("El precio de la localidad es mayor al presupuesto.");
            System.exit(0);
        } else if(precioLocalidad < presupuestoMax) {
            System.out.println("Felicidades compraste tus boletos!");
        }
    }

    /**
     * Método para registrar la venta de boletos en la localidad.
     * @param cantidad Cantidad de boletos vendidos.
     */

    public void registrarVenta(int cantidad) {
        boletosVendidos += cantidad;
    }

    /**
     * Método getter para obtener el número de la localidad.
     * @return El número de la localidad.
     */
    public int getNumero() {
        return numero;
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        Comprador comprador = new Comprador();
        Concierto concierto = new Concierto();
        Localidad localidad = new Localidad(opcion, opcion);

    /**
     * Muestra el menú de opciones y permite a los usuarios seleccionar una opción.
     */

    comprador.solicitarCompra();
        while (opcion != 6) {
            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    comprador.solicitarCompra();
                    break;
                case 2:
                    comprador.generarTicket();
                    comprador.validarTicket();
                    localidad.seleccionarAleatoriamente();
                    localidad.validarPrecio(comprador.getPresupuestoMax(), opcion);
                    break;
                case 3:
                    concierto.consultarDisponibilidadTotal();
                    break;
                case 4:
                    concierto.consultarDisponibilidadIndividual();
                    break;
                case 5:
                    concierto.reporteDeCaja();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        scanner.close();
    }
}