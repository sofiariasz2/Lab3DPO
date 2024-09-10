package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.LinkedList;

import uniandes.dpoo.aerolinea.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Vuelo {
    // Atributos
    private Ruta ruta;
    private String fecha;
    private Avion avion;
    private Collection<Tiquete> tiquetes;

    // Constructor
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.setRuta(ruta);
        this.setFecha(fecha);
        this.setAvion(avion);
        this.setTiquetes(new LinkedList<>());
    }

    // Métodos getter y setter
    public Collection<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(Collection<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Método para vender tiquetes
    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
        // Verificar si hay espacio suficiente en el vuelo
        if (this.getTiquetes().size() + cantidad > this.getAvion().getCapacidad()) {
            throw new VueloSobrevendidoException(this);
        }

        // Calcular el costo total de los tiquetes
        int tarifaTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            int tarifa = calculadora.calcularTarifa(this, cliente);
            tarifaTotal += tarifa;

            // Generar el código del tiquete aquí
            String codigoTiquete = GeneradorTiquetes.generarCodigo();

            // Crear y agregar el tiquete al vuelo y al cliente
            Tiquete nuevoTiquete = new Tiquete(codigoTiquete, this, cliente, tarifa);
            this.getTiquetes().add(nuevoTiquete);
            cliente.agregarTiquete(nuevoTiquete);
        }

        return tarifaTotal;
    }

    // Método equals para comparar vuelos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vuelo otroVuelo = (Vuelo) obj;
        return fecha.equals(otroVuelo.fecha) && ruta.equals(otroVuelo.ruta) && avion.equals(otroVuelo.avion);
    }
}