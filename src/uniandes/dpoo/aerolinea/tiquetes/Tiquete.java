package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	// Atributos
    private String codigo;
    private int tarifa;
    private boolean usado;
    private Vuelo vuelo;
    private Cliente cliente;

    // Constructor
    public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.usado = false;
    }


 


	// Métodos de acceso (getters)
    public String getCodigo() {
        return codigo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public boolean isUsado() {
        return usado;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Métodos de modificación (setters)
    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    // Método para marcar un tiquete como usado
    public void marcarComoUsado() {
        this.usado = true;
    }

    // Método equals para comparar tiquetes (por su código)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tiquete tiquete = (Tiquete) obj;
        return codigo.equals(tiquete.codigo);
    }
}