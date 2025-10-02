package Segundo_punto;

import java.util.ArrayList;
import java.util.List;

public class MainRestaurante {
    public static void main(String[] args) {
        // 1. Crear Mesero
        Mesero juan = new Mesero("Juan Perez", "M001");
        juan.registrarMesaAtendida();

        // 2. Crear Platos
        Plato p1 = new Plato("Ajiaco", 35000.0, "plato fuerte", 25);
        Plato p2 = new Plato("Jugo Natural", 8000.0, "entrada", 5);
        Plato p3 = new Plato("Cazuela de Mariscos", 70000.0, "plato fuerte", 40); // Plato caro para forzar el descuento
        Plato p4 = new Plato("Postre de la casa", 12000.0, "postre", 5);

        // 3. Crear lista de platos para el pedido (al menos 3 platos)
        List<Plato> platosSolicitados = new ArrayList<>();
        platosSolicitados.add(p1);
        platosSolicitados.add(p2);
        platosSolicitados.add(p3); // 3 platos requeridos
        platosSolicitados.add(p4);

        // Subtotal: 35000 + 8000 + 70000 + 12000 = $125,000.0 (Aplica descuento)

        // 4. Crear el Pedido
        Pedido pedidoMesa5 = new Pedido(5, platosSolicitados);

        // 5. Generar la cuenta final
        System.out.println("--- SIMULACIÓN DE PEDIDO Y CUENTA FINAL ---");
        pedidoMesa5.generarCuenta(juan);

        System.out.printf("\nEl mesero %s ahora ha atendido %d mesa(s) hoy.", juan.getNombre(), juan.getMesasAtendidasHoy());
    }
}
