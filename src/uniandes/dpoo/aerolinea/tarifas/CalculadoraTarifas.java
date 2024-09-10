package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	
    protected static final double IMPUESTO = 0.28;

    public abstract int calcularTarifa(Vuelo vuelo, Cliente cliente);

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    protected int calcularDistanciaVuelo(Ruta ruta) {
    	// Obtener el aeropuerto de origen y destino de la ruta
        Aeropuerto origen = ruta.getOrigen();
        Aeropuerto destino = ruta.getDestino();

        // Calcular la distancia entre el aeropuerto de origen y destino usando el método de Aeropuerto
        int distancia = Aeropuerto.calcularDistancia(origen, destino);

        return distancia;
        
    }

    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
}