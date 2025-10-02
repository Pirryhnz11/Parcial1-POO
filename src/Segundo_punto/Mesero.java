package Segundo_punto;

public class Mesero {
    private String nombre;
    private String codigo;
    private int mesasAtendidasHoy; // Registro de desempeño

    public Mesero(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.mesasAtendidasHoy = 0;
    }

    // Registra una mesa atendida
    public void registrarMesaAtendida() {
        this.mesasAtendidasHoy++;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public int getMesasAtendidasHoy() { return mesasAtendidasHoy; }
}
