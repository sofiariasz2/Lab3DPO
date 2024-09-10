package uniandes.dpoo.aerolinea.modelo;

public class Avion {

	// Atributos
    private String nombre;
    private int capacidad;

    // Constructor
    public Avion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // Métodos de acceso (getters)
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Métodos de modificación (setters)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
