package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;

import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;

/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * 
 * No puede haber dos aeropuertos con el mismo código.
 */
public class Aeropuerto
{
	// Constante que representa el radio de la Tierra en kilómetros
    private static final double RADIO_TERRESTRE = 6371.0;

    // Código único del aeropuerto (por ejemplo, "BOG" para El Dorado, Bogotá)
    private String codigo;

    // Nombre del aeropuerto
    private String nombre;

    // Latitud del aeropuerto
    private double latitud;

    // Longitud del aeropuerto
    private double longitud;

    // Set para almacenar los códigos de los aeropuertos y evitar duplicados
    private static Set<String> codigosAeropuertos = new HashSet<>();

    /**
     * Constructor de la clase Aeropuerto
     * 
     * @param codigo   El código único del aeropuerto
     * @param nombre   El nombre del aeropuerto
     * @param latitud  La latitud del aeropuerto
     * @param longitud La longitud del aeropuerto
     * @throws AeropuertoDuplicadoException si ya existe un aeropuerto con el mismo código
     */
    public Aeropuerto(String codigo, String nombre, double latitud, double longitud) throws AeropuertoDuplicadoException {
        if (codigosAeropuertos.contains(codigo)) {
            throw new AeropuertoDuplicadoException("Ya existe un aeropuerto con el código: " + codigo);
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;

        // Agregar el código del nuevo aeropuerto al set de códigos
        codigosAeropuertos.add(codigo);
    }

    // Getters para los atributos del aeropuerto
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    /**
     * Este método calcula la distancia *aproximada* entre dos aeropuertos. Hay fórmulas más precisas pero esta es suficientemente buena para el caso de la aerolínea.
     * 
     * Este método asume que las coordenadas (latitud y longitud) de los aeropuertos están expresadas en la forma que las hace más cercanas. Si no es así, la distancia entre
     * los dos aeropuertos podría ser la más larga posible.
     * 
     * @param aeropuerto1
     * @param aeropuerto2
     * @return La distancia en kilómetros entre los puntos
     */
    public static int calcularDistancia(Aeropuerto aeropuerto1, Aeropuerto aeropuerto2) {
        // Convertir los ángulos a radianes para facilitar las operaciones trigonométricas
        double latAeropuerto1 = Math.toRadians(aeropuerto1.getLatitud());
        double lonAeropuerto1 = Math.toRadians(aeropuerto1.getLongitud());
        double latAeropuerto2 = Math.toRadians(aeropuerto2.getLatitud());
        double lonAeropuerto2 = Math.toRadians(aeropuerto2.getLongitud());

        // Calcular la distancia debido a la diferencia de latitud y de longitud
        double deltaX = (lonAeropuerto2 - lonAeropuerto1) * Math.cos((latAeropuerto1 + latAeropuerto2) / 2);
        double deltaY = (latAeropuerto2 - latAeropuerto1);

        // Calcular la distancia real en kilómetros
        double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY) * RADIO_TERRESTRE;

        return (int) Math.round(distancia);
    }

    /**
     * Método estático para remover un aeropuerto de la lista de códigos (en caso de eliminación)
     * @param codigo El código del aeropuerto a eliminar
     */
    public static void eliminarCodigoAeropuerto(String codigo) {
        codigosAeropuertos.remove(codigo);
    }

}
