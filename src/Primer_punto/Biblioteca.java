package Primer_punto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private List<Libro> catalogo;
    private List<Prestamo> prestamosActivos; // Registra las transacciones en curso

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
    }

    // Método auxiliar para poblar el catálogo
    public void agregarLibro(Libro l) { catalogo.add(l); }

    /**
     * Intenta registrar un nuevo préstamo.
     * @return true si el préstamo fue exitoso, false si falló por restricciones.
     */
    public boolean realizarPrestamo(Usuario usuario, Libro libro) {
        // 1. Verificar disponibilidad y límite de usuario
        if (!libro.estaDisponible()) {
            System.out.println("⚠️ ERROR: Libro '" + libro.getTitulo() + "' NO disponible.");
            return false;
        }
        if (!usuario.puedePrestar()) {
            System.out.println("⚠️ ERROR: Usuario " + usuario.getNombre() + " ha alcanzado el límite (3 libros).");
            return false;
        }

        // 2. Registrar el préstamo y actualizar estados
        Prestamo nuevoPrestamo = new Prestamo(libro, usuario);
        prestamosActivos.add(nuevoPrestamo);
        libro.cambiarEstado("prestado");
        usuario.agregarLibro(libro);

        System.out.println("✅ PRÉSTAMO EXITOSO: " + libro.getTitulo() + " a " + usuario.getNombre());
        return true;
    }

    /**
     * Procesa la devolución de un libro, calcula la multa y actualiza estados.
     * @return El valor de la multa a pagar.
     */
    public double registrarDevolucion(Usuario usuario, Libro libro, LocalDate fechaDevolucion) {
        // 1. Buscar el préstamo activo correspondiente
        Optional<Prestamo> prestamoOpt = prestamosActivos.stream()
                // Se compara la cédula y se usa el equals de Libro (por ISBN)
                .filter(p -> p.getUsuario().getCedula().equals(usuario.getCedula()) && p.getLibro().equals(libro))
                .findFirst();

        if (prestamoOpt.isEmpty()) {
            System.out.println("⚠️ ERROR: No se encontró préstamo activo para el libro y usuario indicados.");
            return 0.0;
        }

        Prestamo prestamo = prestamoOpt.get();

        // 2. Calcular la multa
        double multa = prestamo.calcularMulta(fechaDevolucion);

        // 3. Actualizar estados y listas
        libro.cambiarEstado("disponible");
        usuario.removerLibro(libro);
        prestamosActivos.remove(prestamo); // Quita el préstamo del registro activo

        System.out.println("✅ DEVOLUCIÓN PROCESADA: Libro '" + libro.getTitulo() + "' devuelto por " + usuario.getNombre());
        return multa;
    }
}