import javax.swing.*;
class conductores {
    private String nombre;
    private String identificacion;
    private String licencia;

    public conductores() {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del conductor:");
        this.identificacion = JOptionPane.showInputDialog("Ingrese la identificación del conductor:");
        this.licencia = JOptionPane.showInputDialog("Ingrese el número de licencia del conductor:");
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public String getLicencia() { return licencia; }
}