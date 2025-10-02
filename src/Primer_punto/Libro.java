package Primer_punto;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN; // Identificador único
    private int numPaginas;
    private String estado; // "disponible" o "prestado"

    public Libro(String titulo, String autor, String ISBN, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.numPaginas = numPaginas;
        this.estado = "disponible";
    }

    // Verifica si el libro puede ser prestado
    public boolean estaDisponible() {
        return this.estado.equals("disponible");
    }

    // Cambia el estado del libro (prestado/disponible)
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters para identificación
    public String getISBN() { return ISBN; }
    public String getTitulo() { return titulo; }

    /**
     * Define la igualdad de libros basada únicamente en el ISBN, 
     * lo cual es crucial para buscarlos en las listas.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(ISBN, libro.ISBN);
    }
}