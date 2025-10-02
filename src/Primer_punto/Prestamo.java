package Primer_punto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private final int DIAS_GRACIA = 15;
    private final double MULTA_DIARIA = 2000.0; // Valor de la multa por día

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now(); // Se registra la fecha actual
    }

    // Calcula la multa si la devolución excede los DIAS_GRACIA
    public double calcularMulta(LocalDate fechaDevolucion) {
        // Calcula la diferencia de días entre el préstamo y la devolución
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);

        if (diasTranscurridos > DIAS_GRACIA) {
            long diasAdicionales = diasTranscurridos - DIAS_GRACIA;
            return diasAdicionales * MULTA_DIARIA;
        }
        return 0.0;
    }

    // Getters
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
}