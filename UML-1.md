classDiagram
    direction LR

    class Libro {
        - titulo: String
        - autor: String
        - ISBN: String
        - estado: String
        + estaDisponible(): boolean
        + cambiarEstado(nuevoEstado: String)
    }

    class Usuario {
        - nombre: String
        - cedula: String
        - librosPrestados: List<Libro>
        + puedePrestar(): boolean
        + agregarLibro(libro: Libro)
        + removerLibro(libro: Libro)
    }

    class Prestamo {
        - fechaPrestamo: LocalDate
        + calcularMulta(fechaDevolucion: LocalDate): double
    }

    class Biblioteca {
        - catalogo: List<Libro>
        - prestamosActivos: List<Prestamo>
        + realizarPrestamo(usuario: Usuario, libro: Libro): boolean
        + registrarDevolucion(usuario: Usuario, libro: Libro, fechaDevolucion: LocalDate): double
    }

    %% Relaciones
    Usuario "1" --> "0..3" Libro : tiene prestados
    Prestamo "1" --> "1" Libro : registra
    Prestamo "1" --> "1" Usuario : registra
    Biblioteca "1" o-- "0..*" Libro : catalogo
    Biblioteca "1" o-- "0..*" Prestamo : gestiona
