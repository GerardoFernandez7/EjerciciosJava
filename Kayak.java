/**
 * Interfaz que define los métodos que se deben implementar.
 */
public interface Kayak { 
        
        void registroUsuario(String username, String password, String tipoUsuario);
        void cambiarPassword(String nuevaPassword);
        void cambiarTipoUsuario(String nuevoTipoUsuario);
        void login(String username, String password);
        void reservacion(String fechaVuelo, String tipoVuelo, int cantidadBoletos, String username);
        void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, int numeroAsientos, int cantidadMaletas);
        void itinerario();
}