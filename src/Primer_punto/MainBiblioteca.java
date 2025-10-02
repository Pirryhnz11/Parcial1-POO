package Primer_punto;

import java.time.LocalDate;

public class MainBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // 1. Inicializar Libros y Usuarios
        Libro l1 = new Libro("Fundamentos de Java", "Bloch", "123", 500);
        Libro l2 = new Libro("Patrones de Diseño", "Gamma", "456", 300);
        Libro l3 = new Libro("Clean Code", "Martin", "789", 464);
        Libro l4 = new Libro("El Libro de la Multa", "Multoso", "999", 100); // Usado para el caso de multa

        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        biblioteca.agregarLibro(l4);

        Usuario u1 = new Usuario("Maria Lopez", "1018");
        Usuario u2 = new Usuario("Pedro Gomez", "1020");

        System.out.println("--- SIMULACIÓN DE PRÉSTAMOS ---");

        // PRÉSTAMO 1: Éxito (Cumple requisito de al menos 2 préstamos)
        biblioteca.realizarPrestamo(u1, l1);

        // PRÉSTAMO 2: Éxito
        biblioteca.realizarPrestamo(u1, l2);

        // PRÉSTAMO 3: Éxito (Llega al límite de 3)
        biblioteca.realizarPrestamo(u1, l3);

        // PRÉSTAMO 4: Fallido (Demuestra que la restricción funciona)
        biblioteca.realizarPrestamo(u1, l4);

        System.out.println("\n--- SIMULACIÓN DE DEVOLUCIÓN CON MULTA ---");

        // Préstamo para el caso de multa
        biblioteca.realizarPrestamo(u2, l4);

        // Simular fecha de devolución: 30 días después del préstamo (15 días de gracia + 15 días de multa)
        LocalDate fechaDevolucionConMulta = LocalDate.now().plusDays(30);

        // 1. Procesar la devolución y obtener la multa (Cumple requisito de 1 devolución con multa)
        double multa = biblioteca.registrarDevolucion(u2, l4, fechaDevolucionConMulta);

        // Cálculo esperado: 15 días adicionales * $2000/día = $30000.0
        System.out.println("\nResumen de la Devolución:");
        System.out.println("Días simulados transcurridos: 30");
        System.out.println("Días sujetos a multa: 15");
        System.out.printf("Multa total aplicada: $%.2f\n", multa);
    }
}