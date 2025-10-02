# 📘 Diagramas UML con Mermaid

Este repositorio contiene representaciones gráficas en **Mermaid** que modelan diferentes dominios de software.  
Los diagramas permiten comprender la estructura de clases, atributos, métodos y las relaciones principales entre los objetos de cada sistema.

---

## 📚 Sistema de Biblioteca

El siguiente diagrama representa un **sistema de gestión de biblioteca**, con entidades como `Libro`, `Usuario`, `Prestamo` y `Biblioteca`.  
Se incluyen reglas de negocio como:  
- Un usuario puede tener hasta 3 libros prestados simultáneamente.  
- Un préstamo registra tanto al usuario como al libro asociado.  
- La biblioteca centraliza la gestión de su catálogo y de los préstamos activos.  

```mermaid
classDiagram
    direction LR
    
    class Libro {
        titulo: String
        autor: String
        ISBN: String
        estado: String
        estaDisponible(): boolean
        cambiarEstado(nuevoEstado: String)
    }
    
    class Usuario {
        nombre: String
        cedula: String
        librosPrestados: List<Libro>
        puedePrestar(): boolean
        agregarLibro(Libro)
        removerLibro(Libro)
    }
    
    class Prestamo {
        fechaPrestamo: LocalDate
        calcularMulta(fechaDevolucion: LocalDate): double
    }
    
    class Biblioteca {
        catalogo: List<Libro>
        prestamosActivos: List<Prestamo>
        realizarPrestamo(Usuario, Libro): boolean
        registrarDevolucion(Usuario, Libro, LocalDate): double
    }

    Usuario "1" -- "0..3" Libro : tiene prestados
    Prestamo "1" -- "1" Libro : registra
    Prestamo "1" -- "1" Usuario : registra
    Biblioteca "1" o-- "0..*" Libro : catalogo
    Biblioteca "1" o-- "0..*" Prestamo : gestiona
classDiagram
    direction LR
    
    class Plato {
        nombre: String
        precio: double
        categoria: String
        tiempoPreparacion: int
        getPrecio(): double
        getTiempoPreparacion(): int
    }
    
    class Mesero {
        nombre: String
        codigo: String
        mesasAtendidasHoy: int
        registrarMesaAtendida()
    }
    
    class Pedido {
        numeroMesa: int
        horaPedido: LocalTime
        listaPlatos: List<Plato>
        calcularSubtotal(): double
        calcularDescuento(subtotal: double): double
        calcularTiempoEntrega(): int
        generarCuenta(Mesero)
    }

    Pedido "1" *-- "1..*" Plato : contiene
    Mesero "1" -- "0..*" Pedido : toma
    Pedido ..> Mesero : requiere para cuenta
