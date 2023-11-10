package Modulo1;
/**
* FileName: Lab3
* Author: Gerardo Fernandez
* Date: 20/10/2023
* Description: Este programa busca resolver el problema de un emprendimiento que quiere solventar, el manejo de inventario.
*/ 

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

/**
 * Esta clase representa un sistema de gestión de inventario que permite
 * agregar productos, buscar productos por ID, listar productos por categoría,
 * generar informes y guardar los productos en un archivo CSV.
 */
public class Lab3 {
    
    /**
     * Método principal que inicia el programa.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBienvenido al sistema de gestión de inventario:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Listar productos por categoría");
            System.out.println("4. Generar informe");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea pendiente
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                scanner.nextLine();  // Limpiar el búfer de entrada
                continue;  // Continuar al siguiente ciclo
            }

            switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("\nIngrese el ID del producto: ");
                    int id;
                    try {
                        id = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("ID no válido. Debe ser un número entero.");
                        scanner.nextLine();  // Limpiar el búfer de entrada
                        continue;
                    }

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la cantidad disponible: ");
                    int cantDisponible;
                    try {
                        cantDisponible = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Cantidad disponible no válida. Debe ser un número entero.");
                        scanner.nextLine();
                        continue;
                    }

                    System.out.print("Ingrese la cantidad vendidos: ");
                    int cantVendidos;
                    try {
                        cantVendidos = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Cantidad vendidos no válida. Debe ser un número entero.");
                        scanner.nextLine();
                        continue;
                    }

                    System.out.print("Ingrese el precio: ");
                    float precio;
                    try {
                        precio = scanner.nextFloat();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Precio no válido. Debe ser un número decimal.");
                        scanner.nextLine();
                        continue;
                    }

                    System.out.print("Ingrese la categoría del producto:\n");
                        System.out.print("1. Snack\n");
                        System.out.print("2. Bebidas\n");
                        System.out.print("3. Lacteos\n");
                        System.out.print("Seleccione una opción: ");

                        int categoriaElegida;
                        try {
                            categoriaElegida = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                            scanner.nextLine();  // Limpiar el búfer de entrada
                            continue;  // Continuar al siguiente ciclo
                        }

                        String categoria;

                        switch (categoriaElegida) {
                            case 1:
                                categoria = "Snack";
                                System.out.print("Ingrese los gramos: ");
                                int gramos;
                                try {
                                    gramos = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.println("Gramos no válidos. Debe ser un número entero.");
                                    scanner.nextLine();
                                    continue;
                                }

                                System.out.print("Ingrese el sabor: ");
                                String sabor = scanner.nextLine();
                                System.out.print("Ingrese el tamaño (individual, familiar): ");
                                String tamano = scanner.nextLine();
                                Snack snack = new Snack(id, nombre, cantDisponible, cantVendidos, precio, categoria, gramos, sabor, tamano);
                                inventario.agregarProducto(snack);
                                break;
                            case 2:
                                categoria = "Bebidas";
                                System.out.print("Ingrese los mililitros: ");
                                int mililitros;
                                try {
                                    mililitros = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.println("Mililitros no válidos. Debe ser un número entero.");
                                    scanner.nextLine();
                                    continue;
                                }

                                System.out.print("Ingrese el tipo (energética, con licor, natural, agua pura): ");
                                String tipo = scanner.nextLine();
                                Bebidas bebida = new Bebidas(id, nombre, cantDisponible, cantVendidos, precio, categoria, mililitros, tipo);
                                inventario.agregarProducto(bebida);
                                break;
                            case 3:
                                categoria = "Lacteos";
                                System.out.print("Ingrese la fecha de vencimiento: ");
                                String fechaVencimiento = scanner.nextLine();
                                System.out.print("Ingrese el tipo de leche: ");
                                String tipoLeche = scanner.nextLine();
                                System.out.print("Ingrese la cantidad de grasa que posee: ");
                                String contenidoGrasa = scanner.nextLine();
                                NuevaCategoria_Lacteos lacteo = new NuevaCategoria_Lacteos(id, nombre, cantDisponible, cantVendidos, precio, categoria, fechaVencimiento, tipoLeche, contenidoGrasa);
                                inventario.agregarProducto(lacteo);
                                break;
                            default:
                                System.out.println("Opción no válida. Se seleccionará 'Otra' por defecto.");
                                break;
                        }       
                            break;
                case 2:
                    // Buscar producto por ID
                    System.out.print("\nIngrese el ID del producto a buscar: ");
                    int idBuscar;
                    try {
                        idBuscar = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("ID no válido. Debe ser un número entero.");
                        scanner.nextLine();
                        continue;
                    }

                    Producto productoBuscado = inventario.buscarProductoPorId(idBuscar);
                    if (productoBuscado != null) {
                        System.out.println("Producto encontrado:");
                        System.out.println("ID: " + productoBuscado.getId());
                        System.out.println("Nombre: " + productoBuscado.getNombre());
                        System.out.println("Cantidad Disponible: " + productoBuscado.getCantDisponible());
                        System.out.println("Cantidad Vendidos: " + productoBuscado.getCantVendidos());
                        System.out.println("Precio: " + productoBuscado.getPrecio());
                        System.out.println("Categoría: " + productoBuscado.getCategoria());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    // Listar productos por categoría
                    System.out.print("\nIngrese la categoría a listar (Snack, Bebidas, Lacteos): ");
                    String categoriaListar = scanner.nextLine();
                    if (!validarCategoria(categoriaListar)) {
                        System.out.println("Categoría no válida. Debe ser Snack, Bebidas o Lacteos.");
                        continue;
                    }
                    List<Producto> productosCategoria = inventario.listarProductosPorCategoria(categoriaListar);
                    if (productosCategoria.isEmpty()) {
                        System.out.println("No hay productos en esa categoría.");
                    } else {
                        System.out.println("Productos en la categoría " + categoriaListar + ":");
                        for (Producto producto : productosCategoria) {
                            System.out.println("ID: " + producto.getId() + " - Nombre: " + producto.getNombre());
                        }
                    }
                    break;

                case 4:
                    // Generar informe
                    inventario.generarInforme();
                    break;

                case 5:
                    // Salir del programa
                    inventario.guardarProductosEnCSV("lab3.csv");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    /**
     * Verifica si la cadena proporcionada es una categoría válida.
     *
     * @param categoria La categoría a verificar.
     * @return `true` si la categoría es válida, `false` de lo contrario.
     */
    public static boolean validarCategoria(String categoria) {
        return Pattern.matches("^(Snack|Bebidas|Lacteos)$", categoria);
    }

}

/**
 * Clase base para representar un producto en el inventario.
 */
class Producto {

protected int id;
protected String nombre;
protected int cantDisponible;
protected int cantVendidos;
protected float precio;
protected String categoria;


    /**
     * Constructor de la clase Producto.
     *
     * @param id           Identificador único del producto.
     * @param nombre       Nombre del producto.
     * @param cantDisponible Cantidad disponible en inventario.
     * @param cantVendidos Cantidad de productos vendidos.
     * @param precio       Precio del producto.
     * @param categoria    Categoría del producto.
     */
public Producto(int id, String nombre, int cantDisponible, int cantVendidos, float precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantDisponible = cantDisponible;
        this.cantVendidos = cantVendidos;
        this.precio = precio;
        this.categoria = categoria;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad disponible en inventario.
     *
     * @return La cantidad disponible en inventario.
     */
    public int getCantDisponible() {
        return cantDisponible;
    }

    /**
     * Obtiene la cantidad de productos vendidos.
     *
     * @return La cantidad de productos vendidos.
     */
    public int getCantVendidos() {
        return cantVendidos;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return La categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }
    
    /**
     * Calcula la comisión del producto.
     *
     * @return El valor de la comisión del producto.
     */
    public float calcComision() {
        // Lógica para calcular la comisión
        return 0.0f;
    }
}

/**
 * Clase que representa un producto de la categoría "Snack" en el inventario.
 */
class Snack extends Producto {

private int gramos;
private String sabor;
private String tamano;

/**
     * Constructor de la clase Snack.
     *
     * @param id           Identificador único del producto.
     * @param nombre       Nombre del producto.
     * @param cantDisponible Cantidad disponible en inventario.
     * @param cantVendidos Cantidad de productos vendidos.
     * @param precio       Precio del producto.
     * @param categoria    Categoría del producto.
     * @param gramos       Gramos del snack.
     * @param sabor        Sabor del snack.
     * @param tamano       Tamaño del snack (individual, familiar).
     */
public Snack(int id, String nombre, int cantDisponible, int cantVendidos, float precio, String categoria, int gramos, String sabor, String tamano) {
        super(id, nombre, cantDisponible, cantVendidos, precio, categoria);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamano = tamano;
    }

    /**
     * Obtiene los gramos del producto.
     *
     * @return gramos del producto.
     */
    public int getGramos() {
        return gramos;
    }

    /**
     * Obtiene el sabor del producto.
     *
     * @return sabor del producto.
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Obtiene el tamano del producto.
     *
     * @return tamano del producto.
     */
    public String getTamano() {
        return tamano;
    }
}

/**
 * Clase que representa un producto de la categoría "Bebidas" en el inventario.
 */
class Bebidas extends Producto {

private int mililitros;
private String tipo;

/**
     * Constructor de la clase Bebidas.
     *
     * @param id           Identificador único del producto.
     * @param nombre       Nombre del producto.
     * @param cantDisponible Cantidad disponible en inventario.
     * @param cantVendidos Cantidad de productos vendidos.
     * @param precio       Precio del producto.
     * @param categoria    Categoría del producto.
     * @param mililitros   Mililitros de la bebida.
     * @param tipo         Tipo de bebida (energética, con licor, natural, agua pura).
     */
public Bebidas(int id, String nombre, int cantDisponible, int cantVendidos, float precio, String categoria, int mililitros, String tipo) {
        super(id, nombre, cantDisponible, cantVendidos, precio, categoria);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    /**
     * Obtiene los mililitros del producto.
     *
     * @return militros del producto.
     */
    public int getMililitros() {
        return mililitros;
    }

    /**
     * Obtiene el tipo del producto.
     *
     * @return tipo del producto.
     */
    public String getTipo() {
        return tipo;
    }
}

/**
 * Clase que representa un producto de la categoría "Lacteos" en el inventario.
 */
class NuevaCategoria_Lacteos extends Producto {

private String fechaVencimiento;
private String tipoLeche;
private String contenidoGrasa;

/**
     * Constructor de la clase NuevaCategoria_Lacteos.
     *
     * @param id                Identificador único del producto.
     * @param nombre            Nombre del producto.
     * @param cantDisponible    Cantidad disponible en inventario.
     * @param cantVendidos      Cantidad de productos vendidos.
     * @param precio            Precio del producto.
     * @param categoria         Categoría del producto.
     * @param fechaVencimiento  Fecha de vencimiento de los lácteos.
     * @param tipoLeche         Tipo de leche (entera, desnatada, etc.).
     * @param contenidoGrasa    Contenido de grasa de los lácteos.
     */
public NuevaCategoria_Lacteos(int id, String nombre, int cantDisponible, int cantVendidos, float precio, String categoria, String fechaVencimiento, String tipoLeche, String contenidoGrasa) {
        super(id, nombre, cantDisponible, cantVendidos, precio, categoria);
        this.fechaVencimiento = fechaVencimiento;
        this.tipoLeche = tipoLeche;
        this.contenidoGrasa = contenidoGrasa;
    }

    /**
     * Obtiene la fecha de vencimiento del producto.
     *
     * @return fecha de vencimiento del producto.
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Obtiene el tipo de leche del producto.
     *
     * @return tipo de leche del producto producto.
     */
    public String getTipoLeche() {
        return tipoLeche;
    }

    /**
     * Obtiene el contenido graso del producto.
     *
     * @return contenido graso del producto.
     */
    public String getContenidoGrasa() {
        return contenidoGrasa;
    }

    /**
     * Calcula la comisión del producto.
     *
     * @return El valor de la comisión del producto.
     */
    public float calcComision() {
        return getPrecio() * 0.20f;
    }
}

/**
 * Clase que representa el inventario de productos.
 */
class Inventario {
    private List<Producto> productos;

    /**
     * Constructor de la clase Inventario. Carga productos desde un archivo CSV al iniciar el programa.
     */
    public Inventario() {
        this.productos = new ArrayList<>();
        // Cargar productos automáticamente al iniciar el programa
        cargarProductosDesdeCSV("lab3.csv");
    }

    /**
     * Agrega un producto al inventario. Verifica si un producto con el mismo ID ya existe antes de agregarlo.
     *
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
    // Verificar si un producto con el mismo ID ya existe antes de agregarlo
    if (buscarProductoPorId(producto.getId()) != null) {
        System.out.println("\nError: El producto con ID " + producto.getId() + " ya existe en el inventario.");
        return; // Salir del método sin agregar el producto nuevamente
    } else {
        this.productos.add(producto);
        System.out.println("\nProducto agregado con éxito.");
    }
}
    
    /**
     * Carga productos desde un archivo CSV y los agrega al inventario.
     *
     * @param archivoCSV Ruta del archivo CSV que contiene los datos de los productos.
     */
    public void cargarProductosDesdeCSV(String archivoCSV) {
    try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split("\\|");
            if (datos.length == 9) { 
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int cantDisponible = Integer.parseInt(datos[2]);
                int cantVendidos = Integer.parseInt(datos[3]);
                float precio = Float.parseFloat(datos[4]);
                String categoria = datos[5];

                Producto producto;
                if (categoria.equalsIgnoreCase("Snack")) {
                    producto = new Snack(id, nombre, cantDisponible, cantVendidos, precio, categoria, Integer.parseInt(datos[6]), datos[7], datos[8]);
                } else if (categoria.equalsIgnoreCase("Bebidas")) {
                    producto = new Bebidas(id, nombre, cantDisponible, cantVendidos, precio, categoria, Integer.parseInt(datos[6]), datos[7]);
                } else if (categoria.equalsIgnoreCase("Lacteos")) {
                    producto = new NuevaCategoria_Lacteos(id, nombre, cantDisponible, cantVendidos, precio, categoria, datos[6], datos[7], datos[8]);
                } else {
                    producto = new Producto(id, nombre, cantDisponible, cantVendidos, precio, categoria);
                }

                agregarProducto(producto);
            } else {
            
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error al cargar productos desde el archivo CSV.");
    }
}

/**
     * Guarda la información de los productos del inventario en un archivo CSV.
     *
     * @param archivoCSV Ruta del archivo CSV donde se guardarán los datos de los productos.
     */
public void guardarProductosEnCSV(String archivoCSV) {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV));

        bw.write("ID|Nombre|CantDisponible|CantVendidos|Precio|Categoria|Gramos|Sabor|Tamano|Mililitros|Tipo|FechaVencimiento|TipoLeche|ContenidoGrasa");
        bw.newLine();
        
        for (Producto producto : this.productos) {
            String linea = String.format("%d|%s|%d|%d|%.2f|%s", producto.getId(), producto.getNombre(), producto.getCantDisponible(), producto.getCantVendidos(), producto.getPrecio(), producto.getCategoria());
            
            if (producto instanceof Snack) {
                Snack snack = (Snack) producto;
                linea += String.format("|%d|%s|%s", snack.getGramos(), snack.getSabor(), snack.getTamano());
            } else if (producto instanceof Bebidas) {
                Bebidas bebida = (Bebidas) producto;
                linea += String.format("|%d|%s", bebida.getMililitros(), bebida.getTipo());
            } else if (producto instanceof NuevaCategoria_Lacteos) {
                NuevaCategoria_Lacteos lacteo = (NuevaCategoria_Lacteos) producto;
                linea += String.format("|%s|%s|%s", lacteo.getFechaVencimiento(), lacteo.getTipoLeche(), lacteo.getContenidoGrasa());
            }
            
            bw.write(linea);
            bw.newLine();
        }
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    /**
     * Busca un producto en el inventario por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado o null si no se encuentra en el inventario.
     */
    public Producto buscarProductoPorId(int id) {
        for (Producto producto : this.productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Si no se encuentra el producto
    }

    /**
     * Lista los productos en el inventario que pertenecen a una categoría específica.
     *
     * @param categoria La categoría de productos a listar (por ejemplo, "Snack", "Bebidas", "Lacteos").
     * @return Una lista de productos que pertenecen a la categoría especificada.
     */
    public List<Producto> listarProductosPorCategoria(String categoria) {
        List<Producto> productosCategoria = new ArrayList<>();
        for (Producto producto : this.productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosCategoria.add(producto);
            }
        }
        return productosCategoria;
    }

    /**
     * Calcula el total de ventas en el inventario sumando las ventas de todos los productos.
     *
     * @return El total de ventas en el inventario.
     */
    public float calcularVentasTotales() {
        float totalVentas = 0;
        for (Producto producto : this.productos) {
            totalVentas += producto.getPrecio() * producto.getCantVendidos();
        }
        return totalVentas;
    }

    /**
     * Genera un informe que muestra estadísticas sobre las categorías de productos, ventas totales
     * y comisiones por categoría, y lo imprime en la consola.
     */
    public void generarInforme() {
    Map<String, Integer> categorías = new HashMap<>();
    Map<String, Float> ventasPorCategoría = new HashMap<>();
    Map<String, Float> comisionPorCategoría = new HashMap();
    float totalVentas = 0;

    for (Producto producto : this.productos) {
        String categoria = producto.getCategoria();
        categorías.put(categoria, categorías.getOrDefault(categoria, 0) + 1);

        // Calcular ventas por categoría
        if (!ventasPorCategoría.containsKey(categoria)) {
            ventasPorCategoría.put(categoria, producto.getPrecio() * producto.getCantVendidos());
        } else {
            float ventasActuales = ventasPorCategoría.get(categoria);
            ventasPorCategoría.put(categoria, ventasActuales + (producto.getPrecio() * producto.getCantVendidos()));
        }

        // Calcular el total de ventas
        totalVentas += producto.getPrecio() * producto.getCantVendidos();

        // Calcular comisión por categoría (para "Lacteos" se asume el 20%)
        if (categoria.equals("Lacteos")) {
            float comisionLacteos = ((NuevaCategoria_Lacteos) producto).calcComision();
            comisionPorCategoría.put(categoria, comisionLacteos);
        } else {
            comisionPorCategoría.put(categoria, 0.0f); // Para otras categorías, la comisión es 0
        }
    }

    System.out.println("Listado de categorías con el total de productos:");
    for (Map.Entry<String, Integer> entry : categorías.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    System.out.println("\nListado de productos por categoría:");
    for (Map.Entry<String, Integer> entry : categorías.entrySet()) {
        System.out.println("Categoría " + entry.getKey() + ":");
        for (Producto producto : this.productos) {
            if (producto.getCategoria().equals(entry.getKey())) {
                System.out.println(producto.getNombre());
            }
        }
    }

    System.out.println("\nTotal de ventas: Q" + totalVentas);
    System.out.println("\nPorcentaje de ventas por categoría:");
    for (Map.Entry<String, Float> entry : ventasPorCategoría.entrySet()) {
        float porcentajeVentas = (entry.getValue() / totalVentas) * 100;
        System.out.println("Categoría " + entry.getKey() + ": Q" + entry.getValue() + " - Porcentaje: " + porcentajeVentas + "%");
    }

    System.out.println("\nComisión por categoría:");
    Float comisionLacteos = comisionPorCategoría.get("Lacteos");
    if (comisionLacteos != null) {
        System.out.println("Categoría Lacteos: Q" + comisionLacteos);
    } else {
        System.out.println("Categoría Lacteos: Q0.0"); // Imprimir 0.0 si no hay comisión para "Lacteos"
    }
}
}