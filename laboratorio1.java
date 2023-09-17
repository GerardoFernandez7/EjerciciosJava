package Modulo1;
import java.util.Scanner;
import java.util.Random;

class Dado {
    private int valorMax;

    public Dado(int valorMax) {
        this.valorMax = valorMax;
    }

    public int girarDado() {
        Random random = new Random();
        return random.nextInt(valorMax) + 1;
    }
}

class Maquina {
    private int puntosMaquina;
    private int puntosTotalesM;
    private Dado dado;

    public Maquina() {
        dado = new Dado(6); // Dado con 6 caras
        puntosMaquina = 0;
        puntosTotalesM = 0;
    }

    public int getPuntosTotalesM() {
        return puntosTotalesM;
    }

    public void lanzarDados() {
        puntosMaquina = 0;

        while (puntosMaquina < 20) {
            int girarDado = dado.girarDado();

            System.out.println("Dado de la máquina: " + girarDado);

            if (girarDado == 1) {
                System.out.println("¡La máquina perdió todos sus puntos en esta ronda!");
                puntosMaquina = 0;
                break;
            } else {
                puntosMaquina += girarDado;
            }
        }
        puntosTotalesM += puntosMaquina; 
    }  

    public int getPuntosMaquina() {
        return puntosMaquina;
    }

    public void resetPuntosMaquina() {
        puntosMaquina = 0;
    }
}

public class laboratorio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maquina = new Maquina();
        Dado dado = new Dado(6); // Dado para el jugador
        int puntosJugador = 0;
        int puntosTotalesJ = 0;
        boolean turnoJugador = true;

        while (puntosTotalesJ < 100 && maquina.getPuntosTotalesM() < 100) {
            if (turnoJugador) {
                System.out.println("\n--- Tu Turno ---");
                System.out.println("Tus puntos totales: " + puntosTotalesJ);
                System.out.println("1. Lanzar dado");
                System.out.println("2. Pasar turno a la máquina");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    int dadoJ = dado.girarDado(); // Lanzar dado del jugador
                    System.out.println("Tu dado: " + dadoJ);
                    puntosJugador += dadoJ;
                    System.out.println("Puntos en la ronda: " + puntosJugador);

                    if (dadoJ == 1) {
                        System.out.println("¡Perdiste los puntos generados en esta ronda!\n\n### Turno de la Maquina ###");
                        puntosJugador = 0;
                        turnoJugador = false;
                    }
                    
                    else if (puntosJugador > 19) {
                        System.out.println("Has alcanzado 20 puntos o más. Turno de la máquina...\n\n### Turno de la Maquina ###");
                        puntosTotalesJ += puntosJugador;
                        puntosJugador = 0;
                        turnoJugador = false;
                    }

                } else if (opcion == 2) {
                    System.out.println("Pasar turno a la máquina... \n");
                    puntosTotalesJ += puntosJugador;
                    turnoJugador = false;
                    maquina.lanzarDados(); // Turno automático de la máquina
                    System.out.println("Puntos de la máquina en la ronda: " + maquina.getPuntosMaquina());
                    System.out.println("Puntos totales de la máquina: " + maquina.getPuntosTotalesM());

                } else if (opcion == 3) {
                    System.out.println("Juego terminado. ¡Hasta luego!");
                    break;
                } else {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            
            if (puntosTotalesJ >= 100) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n¡Felicidades, ganaste el juego!");
                        break;
            }    

            } else {
                maquina.lanzarDados(); // Turno automático de la máquina
                System.out.println("Puntos de la máquina en la ronda: " + maquina.getPuntosMaquina());
                System.out.println("Puntos totales de la máquina: " + maquina.getPuntosTotalesM());
                turnoJugador = true;
            }

            if (maquina.getPuntosTotalesM() >= 100) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\nLa Maquina ganó el juego. Lo siento");
                        break;
            }
        }
        scanner.close();
    }
}
