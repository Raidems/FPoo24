import javax.swing.JOptionPane;

// clase vehiculo
class vehiculo {
    private String placa;
    private String modelo;
    private double capacidadCarga;
    private conductores conductor;

    public vehiculo() {
        this.placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        this.modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
        this.capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del vehículo (kg):"));
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public double getCapacidadCarga() { return capacidadCarga; }
    public conductores getConductor() { return conductor; }

    public void asignarConductor(conductores conductor) {
        if (this.conductor == null) {
            this.conductor = conductor;
            JOptionPane.showMessageDialog(null, "Conductor asignado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El vehículo ya tiene un conductor asignado y no se puede modificar.");
        }
    }
}
