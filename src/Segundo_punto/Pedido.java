package Segundo_punto;

import java.time.LocalTime;
import java.util.List;

public class Pedido {
    private int numeroMesa;
    private List<Plato> listaPlatos;
    private LocalTime horaPedido;
    private final double PORCENTAJE_IVA = 0.19; // 19%
    private final double UMBRAL_DESCUENTO = 50000.0;
    private final double PORCENTAJE_DESCUENTO = 0.10; // 10%

    public Pedido(int numeroMesa, List<Plato> listaPlatos) {
        this.numeroMesa = numeroMesa;
        this.listaPlatos = listaPlatos;
        this.horaPedido = LocalTime.now();
    }

    // 1. Suma el precio de todos los platos
    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (Plato plato : listaPlatos) {
            subtotal += plato.getPrecio();
        }
        return subtotal;
    }

    // 2. Aplica el 10% de descuento si el subtotal supera los $50000
    public double calcularDescuento(double subtotal) {
        if (subtotal > UMBRAL_DESCUENTO) {
            return subtotal * PORCENTAJE_DESCUENTO;
        }
        return 0.0;
    }

    // 3. Suma el tiempo de preparación de todos los platos
    public int calcularTiempoEntrega() {
        int tiempoTotal = 0;
        for (Plato plato : listaPlatos) {
            tiempoTotal += plato.getTiempoPreparacion();
        }
        return tiempoTotal;
    }

    // 4. Genera e imprime la cuenta final
    public void generarCuenta(Mesero mesero) {
        double subtotal = calcularSubtotal();
        double descuento = calcularDescuento(subtotal);
        double baseImponible = subtotal - descuento;
        double iva = baseImponible * PORCENTAJE_IVA;
        double totalPagar = baseImponible + iva;

        System.out.println("==================================================");
        System.out.println("               CUENTA RESTAURANTE                 ");
        System.out.println("==================================================");
        System.out.printf("Mesa: %d | Mesero: %s (%s)\n", numeroMesa, mesero.getNombre(), mesero.getCodigo());
        System.out.println("--------------------------------------------------");
        System.out.println("DETALLE DEL PEDIDO:");
        for(Plato p : listaPlatos) {
            System.out.printf("  - %s - $%.2f\n", p.getNombre(), p.getPrecio());
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("SUBTOTAL:                     $%.2f\n", subtotal);
        System.out.printf("DESCUENTO (10%% > $50000):     -$%.2f\n", descuento);
        System.out.println("--------------------------------------------------");
        System.out.printf("BASE IMPONIBLE:               $%.2f\n", baseImponible);
        System.out.printf("IVA (19%%):                    +$%.2f\n", iva);
        System.out.println("==================================================");
        System.out.printf("TOTAL A PAGAR:                $%.2f\n", totalPagar);
        System.out.println("==================================================");
        System.out.printf("Tiempo estimado de entrega: %d minutos.\n", calcularTiempoEntrega());
    }
}
