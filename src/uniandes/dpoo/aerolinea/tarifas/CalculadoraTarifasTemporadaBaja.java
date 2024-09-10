package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

    private static final int COSTO_POR_KM_NATURAL = 600;
    private static final int COSTO_POR_KM_CORPORATIVO = 900;
    private static final double DESCUENTO_PEQ = 0.02;
    private static final double DESCUENTO_MEDIANAS = 0.1;
    private static final double DESCUENTO_GRANDES = 0.2;

    @Override
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int valorImpuestos = calcularValorImpuestos(costoBase);
        return (int) ((costoBase * (1 - descuento)) + valorImpuestos);
    }

    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        if (cliente instanceof ClienteCorporativo) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        } else {
            return distancia * COSTO_POR_KM_NATURAL;
        }
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            int tamanoEmpresa = corporativo.getTamanoEmpresa();
            switch (tamanoEmpresa) {
                case ClienteCorporativo.PEQUENA:
                    return DESCUENTO_PEQ;
                case ClienteCorporativo.MEDIANA:
                    return DESCUENTO_MEDIANAS;
                case ClienteCorporativo.GRANDE:
                    return DESCUENTO_GRANDES;
                default:
                    return 0;
            }
        }
        return 0;
    }
}