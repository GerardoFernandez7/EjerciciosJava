package Modulo1;
/**
 * Interfaz que define los métodos que deben implementar los dispositivos controlables.
 */
public interface DispositivoControlador { 

        void encender();

        void apagar();

        void subirVolumen();

        void bajarVolumen();

        void aumentarBrillo();

        void disminuirBrillo();

        void mostrarInformacion();

        void mostrarEstadoActual();

        void controlarVideo();

        double Precio();

        }