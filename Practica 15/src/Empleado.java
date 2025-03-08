import javax.swing.*;

public class Empleado {
    private String nombre;
    private int id;
    private double salario;

    public Empleado(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    public void mostrarInfo(){
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nId: " + id + "\nSalario: " + salario);

    }
}
