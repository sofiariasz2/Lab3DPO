package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    // Constantes para el tamaño de la empresa
    public static final String CORPORATIVO = "Corporativo";
    public static final int GRANDE = 1;
    public static final int MEDIANA = 2;
    public static final int PEQUENA = 3;

    // Atributos
    private String nombreEmpresa;
    private int tamanoEmpresa;

    // Constructor
    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    // Métodos específicos de ClienteCorporativo

    @Override
    public String getTipoCliente() {
        return CORPORATIVO;
    }

    @Override
    public String getIdentificador() {
        return nombreEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    // Métodos para JSON

    /**
     * Crea un nuevo objeto de tipo ClienteCorporativo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tamanoEmpresa = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombreEmpresa, tamanoEmpresa);
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject
     * para que ese objeto se almacene en un archivo.
     * 
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        jobject.put("tipo", CORPORATIVO);
        return jobject;
    }

    // Otros métodos heredados de Cliente

    @Override
    public void agregarTiquete(Tiquete tiquete) {
        super.agregarTiquete(tiquete);
    }

    @Override
    public int calcularValorTotalTiquetes() {
        return super.calcularValorTotalTiquetes();
    }

    @Override
    public void usarTiquetes(Vuelo vuelo) {
        super.usarTiquetes(vuelo);
    }
}
