package Segundo_punto;

public class Plato {
    private String nombre;
    private double precio;
    private String categoria; // entrada/plato fuerte/postre
    private int tiempoPreparacion; // en minutos

    public Plato(String nombre, double precio, String categoria, int tiempoPreparacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    // Getters
    public double getPrecio() { return precio; }
    public int getTiempoPreparacion() { return tiempoPreparacion; }
    public String getNombre() { return nombre; }
}