import javax.swing.*;

public class Conductor extends Empleado{
    private String licencia;

    public Conductor( String nombre, int id, double salario, String licencia) {
        super(nombre, id, salario);
        this.licencia = licencia;
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        JOptionPane.showMessageDialog(null, "Licencia de conducir: " + licencia);
    }
}
