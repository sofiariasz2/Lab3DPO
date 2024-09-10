package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    // Atributos
    protected String identificador;
    protected List<Tiquete> tiquetes;

    // Constructor por defecto
    public Cliente() {
        tiquetes = new ArrayList<>();
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract String getIdentificador();
    public abstract String getTipoCliente();

    // Agregar un tiquete a la lista de tiquetes del cliente
    public void agregarTiquete(Tiquete tiquete) {
        tiquetes.add(tiquete);
    }

    // Calcular el valor total de los tiquetes del cliente
    public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete tiquete : tiquetes) {
            total += tiquete.getTarifa(); // Suponiendo que el método getTarifa() existe en Tiquete
        }
        return total;
    }

    // Usar los tiquetes del cliente en un vuelo
    public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete tiquete : tiquetes) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado(); // Suponiendo que existe el método marcarComoUsado en Tiquete
            }
        }
    }

	public Tiquete[] getTiquetes() {
		// TODO Auto-generated method stub
		return null;
	}
}
