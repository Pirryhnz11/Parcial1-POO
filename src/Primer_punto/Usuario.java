package Primer_punto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String cedula;
    private List<Libro> librosPrestados; // Almacena los libros que tiene actualmente

    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.librosPrestados = new ArrayList<>();
    }

    // Verifica la restricción de máximo 3 libros prestados
    public boolean puedePrestar() {
        return this.librosPrestados.size() < 3;
    }

    // Agrega un libro a la lista del usuario
    public void agregarLibro(Libro libro) {
        this.librosPrestados.add(libro);
    }

    // Remueve un libro de la lista del usuario (en la devolución)
    public void removerLibro(Libro libro) {
        this.librosPrestados.remove(libro);
    }

    // Getters
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
}