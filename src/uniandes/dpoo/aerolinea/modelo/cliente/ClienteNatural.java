package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {

    // Constante que define el tipo de cliente
    public static final String NATURAL = "Natural";
    
    // Atributo que representa el nombre del cliente
    private String nombre;

    // Constructor de ClienteNatural
    public ClienteNatural(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getIdentificador() {
        // Retorna el identificador del cliente, en este caso, el nombre
        return nombre;
    }

    @Override
    public String getTipoCliente() {
        // Retorna el tipo de cliente: "Natural"
        return NATURAL;
    }
}
