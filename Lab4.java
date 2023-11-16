/**
* FileName: Lab4
* Author: Gerardo Fernandez
* Date: 15/11/2023
* Description: Este es un sitio para manejar reservaciones y confirmaciones de vuelo para la empresa Kayak, el objetivo 
es incentivar a los usuarios a pagar por el servicio premium.
*/ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase principal que contiene el menú de la aplicación y gestiona las interacciones con el usuario.
 */
public class Lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario("a", "b", "c");
        usuario.cargarDatos("lab4.csv");

        Usuario usuarioActual = null;

        while (true) {
            if (usuarioActual == null) {
        
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opción: ");
        
                int opcionInicio = scanner.nextInt();
                scanner.nextLine();
        
                switch (opcionInicio) {
                    case 1:
                
                        usuario.login(null, null);
                        usuarioActual = usuario;
                        break;
                    case 2:
                
                        usuario.registroUsuario(null, null, null);
                        usuarioActual = usuario;
                        break;
                    case 3:
                    
                        System.out.println("¡Hasta luego!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } else {
    
                System.out.println("1. Reservación");
                System.out.println("2. Perfil");
                System.out.println("3. Cerrar sesión");
                System.out.print("Selecciona una opción: ");
        
                int opcionMenu = scanner.nextInt();
                scanner.nextLine(); 
        
                switch (opcionMenu) {
                    case 1:
                    
                        usuario.reservacion(null, null, opcionMenu, null);
                        usuario.confirmacion(null, opcionMenu, null, opcionMenu, opcionMenu);
                        usuario.itinerario();
                        break;
                    case 2:
                    
                        usuario.perfil();
                        break;
                    case 3:
                        
                        usuarioActual = null;
                        System.out.println("Sesión cerrada. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        }
    }
}

/**
 * Clase que representa a un usuario y contiene sus métodos y propiedades.
 */
class Usuario implements Kayak{

    private String username;
    private String password;
    private String tipoUsuario;
    List<Usuario> usuarios = new ArrayList<>();
    List<Reserva> reservaciones = new ArrayList<>();
    List<Confirmacion> confirmaciones = new ArrayList<>();
    private String fechaVuelo;
    private String tipoVuelo;
    private String claseVuelo;
    private int cantidadBoletos;
    private int numeroAsientos;
    private int cantidadMaletas;
    private String aerolinea;

    /**
     * Constructor de la clase Usuario.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @param tipoUsuario Tipo de usuario (gratis o VIP).
     */
    public Usuario(String username, String password, String tipoUsuario) {
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

     /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password Nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el tipo de usuario (gratis o VIP).
     * @return El tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     * @param tipoUsuario Nuevo tipo de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Realiza el registro de un nuevo usuario.
     * @param username Nombre de usuario a registrar.
     * @param password Contraseña del nuevo usuario.
     * @param tipoUsuario Tipo de usuario a seleccionar (gratis o VIP).
     */
    public void registroUsuario(String username, String password, String tipoUsuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un nombre de usuario: ");
        username = scanner.next();
        System.out.print("Ingrese una contraseña: ");
        password = scanner.next();
        System.out.print("Seleccione un tipo de usuario (gratis o VIP): ");
        tipoUsuario = scanner.next();

        Usuario nuevoUsuario = new Usuario(username, password, tipoUsuario);
        usuarios.add(nuevoUsuario);

        System.out.println("Se ha registrado exitosamente! Puede continuar.");
    }

    /**
     * Cambia la contraseña del usuario.
     * @param nuevaPassword Nueva contraseña del usuario.
     */
    public void cambiarPassword(String nuevaPassword) {
        Scanner scanner = new Scanner(System.in);
        password = nuevaPassword;
        System.out.print("Ingrese su nueva contraseña: ");
        nuevaPassword = scanner.next();
        System.out.println("Su contraseña ha sido cambiada exitosamente!");
    }

    /**
     * Cambia el tipo de usuario (gratis o VIP).
     * @param nuevoTipoUsuario Nuevo tipo de usuario.
     */
    public void cambiarTipoUsuario(String nuevoTipoUsuario) {
        Scanner scanner = new Scanner(System.in);
        tipoUsuario = nuevoTipoUsuario;
        System.out.print("Ingrese a cuál plan desea cambiarse (gratis o VIP): ");
        nuevoTipoUsuario = scanner.next();
        System.out.println("Su plan ha sido cambiado exitosamente!");
    }

    /**
     * Inicia sesión del usuario.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     */
    public void login(String username, String password) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        username = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        password = scanner.next();

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Ha iniciado sesión correctamente!");
                return;
            }
        }

        System.out.println("Nombre de usuario o contraseña incorrectos.");
    }

/**
     * Realiza una reservación de vuelo.
     * @param fechaVuelo Fecha de vuelo.
     * @param tipoVuelo Tipo de vuelo (ida y vuelta o solo ida).
     * @param cantidadBoletos Cantidad de boletos a reservar.
     * @param username Nombre de usuario para asociar la reservación.
     */
    public void reservacion(String fechaVuelo, String tipoVuelo, int cantidadBoletos, String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de viaje: ");
        this.fechaVuelo = scanner.nextLine();
        System.out.print("¿Es ida y vuelta o solo ida?: ");
        this.tipoVuelo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese la cantidad de boletos:");
        this.cantidadBoletos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la aerolínea: ");
        this.aerolinea = scanner.nextLine();
        System.out.println("Se ha realizado su reservación exitosamente!");
    }

    /**
     * Realiza la confirmación de la reservación.
     * @param numeroTarjeta Número de tarjeta de crédito.
     * @param cuotas Cantidad de cuotas para el pago.
     * @param claseVuelo Clase de vuelo (Coach o primera clase).
     * @param numeroAsientos Número de asiento deseado.
     * @param cantidadMaletas Cantidad de maletas para el vuelo.
     */
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, int numeroAsientos,
            int cantidadMaletas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------ Confirmacion ------");
        System.out.print("Ingrese el número de su tarjeta de crédito: ");
        numeroTarjeta = scanner.nextLine();
        System.out.print("Ingrese cantidad de cuotas (1 = un solo pago, hasta 24 cuotas): "); // No premium
        cuotas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("¿Desea Coach o primera clase?: "); // No premium
        this.claseVuelo = scanner.nextLine();
        System.out.print("Seleccione el número de asiento que desea: "); // Premium
        this.numeroAsientos = scanner.nextInt();
        System.out.print("¿Cuántas maletas desea llevar?: "); // Premium
        this.cantidadMaletas = scanner.nextInt();
        System.out.println("Se ha realizado su confirmación de vuelo exitosamente, ¡feliz viaje!");
    }

    /**
     * Muestra el itinerario de la reservación.
     */
    public void itinerario() {
        System.out.println("\n------ Itinerario ------");
        System.out.println("Fecha de viaje: " + fechaVuelo);
        System.out.println("Tipo de vuelo: " + tipoVuelo);
        System.out.println("Cantidad de boletos: " + cantidadBoletos);
        System.out.println("Aerolínea: " + aerolinea);
        System.out.println("Clase de vuelo: " + claseVuelo);
        System.out.println("Número de asiento: " + numeroAsientos);
        System.out.println("Cantidad de maletas: " + cantidadMaletas);
    }

    /**
     * Muestra el perfil del usuario.
     */
    public void perfil() {
        System.out.println("------ Perfil ------");
        System.out.println("Nombre de usuario: " + username);
        System.out.println("Tipo de usuario: " + tipoUsuario);
    }

    /**
     * Carga datos desde un archivo CSV.
     * @param archivoCSV Nombre del archivo CSV a cargar.
     */
        public void cargarDatos(String archivoCSV) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            boolean primeraLinea = true; 
            while ((line = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = line.split(",");
                
                String username = datos[0];
                String password = datos[1];
                String tipoUsuario = datos[2];
                String fechaViaje = datos[3];
                String tipoVuelo = datos[4];
                int cantidadBoletos = Integer.parseInt(datos[5]);
                String aerolinea = datos[6];
                String numeroTarjeta = datos[7];
                int cuotas = Integer.parseInt(datos[8]);
                String claseVuelo = datos[9];
                int numeroAsiento = Integer.parseInt(datos[10]);
                int cantidadMaletas = Integer.parseInt(datos[11]);

                Usuario usuario = new Usuario(username, password, tipoUsuario);
                Reserva nuevaReservacion = new Reserva(fechaViaje, tipoVuelo, cantidadBoletos, aerolinea, usuario);
                Confirmacion nuevaConfirmacion = new Confirmacion(numeroTarjeta, cuotas, claseVuelo, numeroAsiento, cantidadMaletas, usuario, nuevaReservacion);
                usuarios.add(usuario);
                reservaciones.add(nuevaReservacion);
                confirmaciones.add(nuevaConfirmacion);
                }
                } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
    }   
    }
}
/**
 * Clase que representa una reserva de vuelo.
 */
    class Reserva {

    private String fechaViaje;
    private String tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private Usuario usuario;

    /**
     * Constructor de la clase Reserva.
     *
     * @param fechaViaje      La fecha del viaje.
     * @param tipoVuelo       El tipo de vuelo (por ejemplo, nacional o internacional).
     * @param cantidadBoletos La cantidad de boletos reservados.
     * @param aerolinea       La aerolínea con la que se realiza la reserva.
     * @param usuario         El usuario que realiza la reserva.
     */
        public Reserva(String fechaViaje, String tipoVuelo, int cantidadBoletos, String aerolinea, Usuario usuario) {
            this.fechaViaje = fechaViaje;
            this.tipoVuelo = tipoVuelo;
            this.cantidadBoletos = cantidadBoletos;
            this.aerolinea = aerolinea;
            this.usuario = usuario;
        }

        /**
     * Obtiene la fecha del viaje.
     *
     * @return La fecha del viaje.
     */
        public String getFechaViaje() {
            return fechaViaje;
        }

        /**
     * Establece la fecha del viaje.
     *
     * @param fechaViaje La nueva fecha del viaje.
     */
        public void setFechaViaje(String fechaViaje) {
            this.fechaViaje = fechaViaje;
        }

        /**
     * Obtiene el tipo de vuelo.
     *
     * @return El tipo de vuelo.
     */
        public String getTipoVuelo() {
            return tipoVuelo;
        }

         /**
     * Establece el tipo de vuelo.
     *
     * @param tipoVuelo El nuevo tipo de vuelo.
     */
        public void setTipoVuelo(String tipoVuelo) {
            this.tipoVuelo = tipoVuelo;
        }

        /**
     * Obtiene la cantidad de boletos reservados.
     *
     * @return La cantidad de boletos reservados.
     */
        public int getCantidadBoletos() {
            return cantidadBoletos;
        }

        /**
     * Establece la cantidad de boletos reservados.
     *
     * @param cantidadBoletos La nueva cantidad de boletos reservados.
     */
        public void setCantidadBoletos(int cantidadBoletos) {
            this.cantidadBoletos = cantidadBoletos;
        }

        /**
     * Obtiene la aerolínea de la reserva.
     *
     * @return La aerolínea de la reserva.
     */
        public String getAerolinea() {
            return aerolinea;
        }

        /**
     * Establece la aerolínea de la reserva.
     *
     * @param aerolinea La nueva aerolínea de la reserva.
     */
        public void setAerolinea(String aerolinea) {
            this.aerolinea = aerolinea;
        }
/**
     * Obtiene el usuario asociado a la reserva.
     *
     * @return El usuario asociado a la reserva.
     */
        public Usuario getUsuario() {
            return usuario;
        }

        /**
     * Establece el usuario asociado a la reserva.
     *
     * @param usuario El nuevo usuario asociado a la reserva.
     */
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

    }

    /**
 * Clase que representa una confirmación de reserva de vuelo.
 */
    class Confirmacion  {

    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private int numeroAsiento;
    private int cantidadMaletas;
    private Usuario usuario; 
    private Reserva reserva;

    /**
     * Constructor de la clase Confirmacion.
     *
     * @param numeroTarjeta   El número de tarjeta de crédito utilizado para la reserva.
     * @param cuotas          La cantidad de cuotas para el pago.
     * @param claseVuelo      La clase de vuelo (por ejemplo, económica o ejecutiva).
     * @param numeroAsiento   El número de asiento reservado.
     * @param cantidadMaletas La cantidad de maletas incluidas en la reserva.
     * @param usuario         El usuario asociado a la confirmación.
     * @param reserva         La reserva asociada a la confirmación.
     */
        public Confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, int numeroAsiento, int cantidadMaletas, Usuario usuario, Reserva reserva) {
            this.numeroTarjeta = numeroTarjeta;
            this.cuotas = cuotas;
            this.claseVuelo = claseVuelo;
            this.numeroAsiento = numeroAsiento;
            this.cantidadMaletas = cantidadMaletas;
            this.usuario = usuario;
            this.reserva = reserva;
        }

        /**
     * Obtiene el número de tarjeta de crédito utilizado para la reserva.
     *
     * @return El número de tarjeta de crédito.
     */
        public String getNumeroTarjeta() {
            return numeroTarjeta;
        }

        /**
     * Establece el número de tarjeta de crédito utilizado para la reserva.
     *
     * @param numeroTarjeta El nuevo número de tarjeta de crédito.
     */
        public void setNumeroTarjeta(String numeroTarjeta) {
            this.numeroTarjeta = numeroTarjeta;
        }

        /**
     * Obtiene la cantidad de cuotas para el pago.
     *
     * @return La cantidad de cuotas.
     */
        public int getCuotas() {
            return cuotas;
        }

        /**
     * Establece la cantidad de cuotas para el pago.
     *
     * @param cuotas La nueva cantidad de cuotas.
     */
        public void setCuotas(int cuotas) {
            this.cuotas = cuotas;
        }
   
    /**
     * Obtiene la clase de vuelo.
     *
     * @return La clase de vuelo.
     */
        public String getClaseVuelo() {
            return claseVuelo;
        }

        /**
     * Establece la clase de vuelo.
     *
     * @param claseVuelo La nueva clase de vuelo.
     */
        public void setClaseVuelo(String claseVuelo) {
            this.claseVuelo = claseVuelo;
        }

        /**
     * Obtiene el número de asiento reservado.
     *
     * @return El número de asiento.
     */
        public int getNumeroAsiento() {
            return numeroAsiento;
        }

        /**
     * Establece el número de asiento reservado.
     *
     * @param numeroAsiento El nuevo número de asiento.
     */
        public void setNumeroAsiento(int numeroAsiento) {
            this.numeroAsiento = numeroAsiento;
        }

        /**
     * Obtiene la cantidad de maletas incluidas en la reserva.
     *
     * @return La cantidad de maletas.
     */
        public int getCantidadMaletas() {
            return cantidadMaletas;
        }

        /**
     * Establece la cantidad de maletas incluidas en la reserva.
     *
     * @param cantidadMaletas La nueva cantidad de maletas.
     */
        public void setCantidadMaletas(int cantidadMaletas) {
            this.cantidadMaletas = cantidadMaletas;
        }

        /**
     * Obtiene el usuario asociado a la confirmación.
     *
     * @return El usuario asociado a la confirmación.
     */
        public Usuario getUsuario() {
            return usuario;
        }

        /**
     * Establece el usuario asociado a la confirmación.
     *
     * @param usuario El nuevo usuario asociado a la confirmación.
     */
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        /**
     * Obtiene la reserva asociada a la confirmación.
     *
     * @return La reserva asociada a la confirmación.
     */
        public Reserva getReserva() {
            return reserva;
        }

        /**
     * Establece la reserva asociada a la confirmación.
     *
     * @param reserva La nueva reserva asociada a la confirmación.
     */
        public void setReserva(Reserva reserva) {
            this.reserva = reserva;
        }
        
    }