package Modulo1;
/**
* FileName: Ejercicio 6
* Author: Gerardo Fernandez
* Date: 28/10/2023
* Description: Este programa busca resolver un problema administrativo en una tienda de tecnologia que desea exhibir sus dispositivos.
*/ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase principal que representa una tienda de tecnología llamada TiendaElectroTech.
 * Esta tienda gestiona la exhibición y el control de dispositivos de tecnología.
 */
public class Ejercicio6 {

    /**
     * El método principal que inicia el programa.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
public static void main(String[] args) {
        TiendaElectroTech tienda = new TiendaElectroTech();

        tienda.cargarDatosDesdeCSV("Ej6.csv");

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Seleccionar dispositivo para controlar");
            System.out.println("2. Mostrar dispositivo más caro");
            System.out.println("3. Mostrar dispositivo más barato");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
    System.out.println("Ingrese el índice del dispositivo que desea controlar:");
    int indiceDispositivo = scanner.nextInt();
    if (indiceDispositivo >= 0 && indiceDispositivo < tienda.dispositivosExhibidos.size()) {
        DispositivoControlador dispositivo = tienda.dispositivosExhibidos.get(indiceDispositivo);
    
        int subOpcion;
        do {
            System.out.println("\nOperaciones disponibles para el dispositivo:");
            System.out.println("1. Encender");
            System.out.println("2. Apagar");
            System.out.println("3. Subir Volumen");
            System.out.println("4. Bajar Volumen");
            System.out.println("5. Aumentar Brillo");
            System.out.println("6. Disminuir Brillo");
            System.out.println("7. Controlar Video");
            System.out.println("8. Mostrar Información");
            System.out.println("9. Mostrar Estado Actual");
            System.out.println("10. Salir");
            System.out.print("Ingrese el número de opción: ");
            subOpcion = scanner.nextInt();

            switch (subOpcion) {
                case 1:
                    dispositivo.encender();
                    break;
                case 2:
                    dispositivo.apagar();
                    break;
                case 3:
                    dispositivo.subirVolumen();
                    break;
                case 4:
                    dispositivo.bajarVolumen();
                    break;
                case 5:
                    dispositivo.aumentarBrillo();
                    break;
                case 6:
                    dispositivo.disminuirBrillo();
                    break;
                case 7:
                    dispositivo.controlarVideo();
                    break;
                case 8:
                    dispositivo.mostrarInformacion();
                    break;
                case 9:
                    dispositivo.mostrarEstadoActual();
                    break;
                case 10:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (subOpcion != 10);
    } else {
        System.out.println("Indice de dispositivo no válido.");
    }
    break;
                case 2:
                    DispositivoControlador dispositivoCaro = tienda.mostrarDispositivoMasCaro();
                    System.out.println("El dispositivo más caro es:");
                    dispositivoCaro.mostrarInformacion();
                    break;
                case 3:
                    DispositivoControlador dispositivoBarato = tienda.mostrarDispositivoMasBarato();
                    System.out.println("El dispositivo más barato es:");
                    dispositivoBarato.mostrarInformacion();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}

/**
 * Clase que representa un teléfono inteligente que implementa la interfaz DispositivoControlador.
 */
class TelefonoInteligente implements DispositivoControlador {

private String encendido;
private int visaCuotas;
private String descripcion;
private int precio;
private String marca;
private String modelo;
private int volumen;
private int brillo;
private int memoriaRam;
private boolean cuboCargadorIncluido;
private boolean es5G;
private int videoActual;

    public String getEncendido() {
        return encendido;
    }

    public int getVisaCuotas() {
        return visaCuotas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getBrillo() {
        return brillo;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public boolean isCuboCargadorIncluido() {
        return cuboCargadorIncluido;
    }

    public boolean isEs5G() {
        return es5G;
    }

    public int getVideoActual() {
        return videoActual;
    }

    public void setEncendido(String encendido) {
        this.encendido = encendido;
    }

    public void setVisaCuotas(int visaCuotas) {
        this.visaCuotas = visaCuotas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setBrillo(int brillo) {
        this.brillo = brillo;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public void setCuboCargadorIncluido(boolean cuboCargadorIncluido) {
        this.cuboCargadorIncluido = cuboCargadorIncluido;
    }

    public void setEs5G(boolean es5G) {
        this.es5G = es5G;
    }

    public void setVideoActual(int videoActual) {
        this.videoActual = videoActual;
    }

public void encender() {
        System.out.println("Encendiendo el teléfono inteligente...");
    }
    

public void apagar() {
    System.out.println("Apagando el teléfono inteligente...");
}

public void subirVolumen() {
    if (volumen < 100) {
        volumen += 2; // Aumentar el volumen en un 2%
        System.out.println("Volumen: " + volumen + "%");
    }
}

public void bajarVolumen() {
    if (volumen > 0) {
        volumen -= 2; // Disminuir el volumen en un 2%
        System.out.println("Volumen: " + volumen + "%");
    }
}

public void aumentarBrillo() {
    if (brillo < 100) {
        brillo += 3; // Aumentar el brillo en un 3%
        System.out.println("Brillo: " + brillo + "%");
    }
}

public void disminuirBrillo() {
    if (brillo > 0) {
        brillo -= 3; // Disminuir el brillo en un 3%
        System.out.println("Brillo: " + brillo + "%");
    }
}

public int compareTo(TelefonoInteligente otroTelefono) {
        return Integer.compare(this.getPrecio(), otroTelefono.getPrecio());
    }

public void mostrarInformacion() {
    System.out.println("Descripción: " + descripcion);
    System.out.println("Precio: $" + precio);
    System.out.println("Cantidad de visa cuotas permitidas: 6");
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Memoria RAM: " + memoriaRam + " GB");
    System.out.println("Cubo cargador incluido: " + (cuboCargadorIncluido ? "Sí" : "No"));
    System.out.println("Es 5G: " + (es5G ? "Sí" : "No"));
}

public void mostrarEstadoActual() {
    System.out.println("\nEstado actual del dispositivo:");
    System.out.println("Encendido: " + encendido);
    System.out.println("Volumen: " + volumen + "%");
    System.out.println("Brillo: " + brillo + "%");
    System.out.println("Reproduciendo video " + videoActual);
}


public void controlarVideo() {
    videoActual = (videoActual % 3) + 1; // Ciclo entre los 3 videos (1, 2, 3)
    System.out.println("Reproduciendo video " + videoActual);
}

public double Precio() {
        return precio;
    }

}

/**
 * Clase que representa una computadora portátil que implementa la interfaz DispositivoControlador.
 */
class ComputadoraPortatil implements DispositivoControlador {

private String encendido;
private int visaCuotas;
private String descripcion;
private int precio;
private String marca;
private String modelo;
private int volumen;
private int brillo;
private int memoriaRam;
private String discoDuroTipo;
private int discoDuroSize;
private double cpuVelocidad;
private double gpuVelocidad;
private int videoActual;

public String getDescripcion() {
        return descripcion;
    }

    public String getEncendido() {
        return encendido;
    }

    public int getVisaCuotas() {
        return visaCuotas;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getBrillo() {
        return brillo;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public String getDiscoDuroTipo() {
        return discoDuroTipo;
    }

    public int getDiscoDuroSize() {
        return discoDuroSize;
    }

    public double getCpuVelocidad() {
        return cpuVelocidad;
    }

    public double getGpuVelocidad() {
        return gpuVelocidad;
    }

    public int getVideoActual() {
        return videoActual;
    }

    public void setEncendido(String encendido) {
        this.encendido = encendido;
    }

    public void setVisaCuotas(int visaCuotas) {
        this.visaCuotas = visaCuotas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setBrillo(int brillo) {
        this.brillo = brillo;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

     public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDiscoDuroSize(int discoDuroSize) {
        this.discoDuroSize = discoDuroSize;
    }

    public void setDiscoDuroTipo(String discoDuroTipo) {
        this.discoDuroTipo = discoDuroTipo;
    }

    public void setCpuVelocidad(double cpuVelocidad) {
        this.cpuVelocidad = cpuVelocidad;
    }

    public void setGpuVelocidad(double gpuVelocidad) {
        this.gpuVelocidad = gpuVelocidad;
    }

    public void setVideoActual(int videoActual) {
        this.videoActual = videoActual;
    }

public void encender() {
        System.out.println("Encendiendo la computadora portátil...");
    }
    
public void apagar() {
    System.out.println("Apagando la computadora portátil...");
}

public void subirVolumen() {
    if (volumen < 100) {
        volumen += 10; // Aumentar el volumen en un 10%
        System.out.println("Volumen: " + volumen + "%");
    }
}

public void bajarVolumen() {
    if (volumen > 0) {
        volumen -= 10; // Disminuir el volumen en un 10%
        System.out.println("Volumen: " + volumen + "%");
    }
}

public void aumentarBrillo() {
    if (brillo < 100) {
        brillo += 5; // Aumentar el brillo en un 5%
        System.out.println("Brillo: " + brillo + "%");
    }
}

public void disminuirBrillo() {
    if (brillo > 0) {
        brillo -= 5; // Disminuir el brillo en un 5%
        System.out.println("Brillo: " + brillo + "%");
    }
}

public void mostrarInformacion() {
    System.out.println("Descripción: " + descripcion);
    System.out.println("Precio: $" + precio);
    System.out.println("Cantidad de visa cuotas permitidas: 12");
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Memoria RAM: " + memoriaRam + " GB");
    System.out.println("Tipo de disco duro: " + discoDuroTipo);
    System.out.println("Tamaño de disco duro: " + discoDuroSize + " GB");
    System.out.println("CPU Velocidad: " + cpuVelocidad + " GHz");
    System.out.println("GPU Velocidad: " + gpuVelocidad + " GHz");
}

public void mostrarEstadoActual() {
    System.out.println("\nEstado actual del dispositivo:");
    System.out.println("Encendido: " + encendido);
    System.out.println("Volumen: " + volumen + "%");
    System.out.println("Brillo: " + brillo + "%");
    System.out.println("Reproduciendo video " + videoActual);
}

public void controlarVideo() {
    videoActual = (videoActual % 5) + 1; // Ciclo entre los 5 videos (1, 2, 3, 4, 5)
    System.out.println("Reproduciendo video " + videoActual);
}

public double Precio() {
        return precio;
    }

    public int compareTo(ComputadoraPortatil otraComputadora) {
        return Integer.compare(this.getPrecio(), otraComputadora.getPrecio());
    }
}

/**
 * Clase que representa la tienda de tecnología.
 */
class TiendaElectroTech{

/**
 * Constructor de la clase TiendaElectroTech.
 */
public TiendaElectroTech() {
    dispositivosExhibidos = new ArrayList<>();
}

    /**
     * Lista que almacena los dispositivos exhibidos en la tienda.
     */
public List<DispositivoControlador> dispositivosExhibidos;

public List<DispositivoControlador> getDispositivosExhibidos() {
        return dispositivosExhibidos;
    }

/**
 * Carga los datos de los dispositivos desde un archivo CSV.
 * @param archivoCSV El nombre del archivo CSV que contiene los datos de los dispositivos.
 */
public void cargarDatosDesdeCSV(String archivoCSV) {
    try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
        String line;
        boolean primeraLinea = true; 
        while ((line = reader.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false;
                continue;
            }

            String[] datos = line.split(";");
            if (datos.length != 16) {
                System.out.println("Error en el formato del archivo CSV.");
                continue;
            }

            String encendido = datos[0];
            String marca = datos[1];
            String modelo = datos[2];
            String descripcion = datos[3];
            int precio = Integer.parseInt(datos[4]);
            int visaCuotas = Integer.parseInt(datos[5]);
            int volumen = Integer.parseInt(datos[6]);
            int brillo = Integer.parseInt(datos[7]);
            int videoActual = Integer.parseInt(datos[8]);
            int memoriaRam = Integer.parseInt(datos[9]);
            boolean cuboCargadorIncluido = Boolean.parseBoolean(datos[10]);
            boolean es5G = Boolean.parseBoolean(datos[11]);
            String discoDuroTipo = datos[12];
            double cpuVelocidad = 0;
            double gpuVelocidad = 0;
            int discoDuroSize = 0; 

            try {
            if (!datos[11].equals("NA")) {
                discoDuroSize = Integer.parseInt(datos[11]);
            }
            } catch (NumberFormatException e) {
            }

            try {
                if (!datos[12].equals("NA")) {
                    discoDuroSize = Integer.parseInt(datos[12]);
                }
            } catch (NumberFormatException e) {
            }

            try {
                if (!datos[13].equals("NA")) {
                    cpuVelocidad = Double.parseDouble(datos[13]);
                }
            } catch (NumberFormatException e) {
            }

            try {
                if (!datos[14].equals("NA")) {
                    gpuVelocidad = Double.parseDouble(datos[14]);
                }
            } catch (NumberFormatException e) {
            }

            if (discoDuroTipo.equals("NA")) {
                TelefonoInteligente telefono = new TelefonoInteligente();
                telefono.setMarca(marca);
                telefono.setModelo(modelo);
                telefono.setDescripcion(descripcion);
                telefono.setPrecio(precio);
                telefono.setVolumen(volumen);
                telefono.setBrillo(brillo);
                telefono.setVideoActual(videoActual);
                telefono.setMemoriaRam(memoriaRam);
                telefono.setCuboCargadorIncluido(cuboCargadorIncluido);
                telefono.setEs5G(es5G);
                dispositivosExhibidos.add(telefono);
            } else {
                ComputadoraPortatil portatil = new ComputadoraPortatil();
                portatil.setMarca(marca);
                portatil.setModelo(modelo);
                portatil.setDescripcion(descripcion);
                portatil.setPrecio(precio);
                portatil.setVolumen(volumen);
                portatil.setBrillo(brillo);
                portatil.setVideoActual(videoActual);
                portatil.setMemoriaRam(memoriaRam);
                portatil.setDiscoDuroSize(discoDuroSize);
                portatil.setDiscoDuroTipo(discoDuroTipo);
                portatil.setCpuVelocidad(cpuVelocidad);
                portatil.setGpuVelocidad(gpuVelocidad);
                dispositivosExhibidos.add(portatil);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
    }
}

/**
     * Método para seleccionar un equipo para controlar y mostrar su estado actual.
     *
     * @param dispositivo El dispositivo que se desea controlar.
     */
public void seleccionarEquipoParaControlar(DispositivoControlador dispositivo) {
    dispositivo.mostrarEstadoActual();
}

/**
     * Encuentra y devuelve el dispositivo más caro de la tienda.
     *
     * @return El dispositivo más caro.
     */
public DispositivoControlador mostrarDispositivoMasCaro() {
    DispositivoControlador dispositivoMasCaro = null;
    double precioMasCaro = Double.MIN_VALUE;

    for (DispositivoControlador dispositivo : dispositivosExhibidos) {
        if (dispositivo.Precio() > precioMasCaro) {
            precioMasCaro = dispositivo.Precio();
            dispositivoMasCaro = dispositivo;
        }
    }

    return dispositivoMasCaro;
}

/**
     * Encuentra y devuelve el dispositivo más barato de la tienda.
     *
     * @return El dispositivo más barato.
     */
public DispositivoControlador mostrarDispositivoMasBarato() {
    DispositivoControlador dispositivoMasBarato = null;
    double precioMasBarato = Double.MAX_VALUE;

    for (DispositivoControlador dispositivo : dispositivosExhibidos) {
        if (dispositivo.Precio() < precioMasBarato) {
            precioMasBarato = dispositivo.Precio();
            dispositivoMasBarato = dispositivo;
        }
    }
    return dispositivoMasBarato;
    }
}