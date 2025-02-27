import javax.swing.JOptionPane;
class entregas {
    private String numeroGuia;
    private String estado;

    public entregas(String numeroGuia) {
        this.numeroGuia = numeroGuia;
        this.estado = "Pendiente";
    }

    public void actualizarEstado() {
        String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado (En tránsito / Entregado):");
        if (nuevoEstado.equalsIgnoreCase("En tránsito") || nuevoEstado.equalsIgnoreCase("Entregado")) {
            this.estado = nuevoEstado;
            JOptionPane.showMessageDialog(null, "Estado actualizado a: " + estado);
        } else {
            JOptionPane.showMessageDialog(null, "Estado inválido. Solo se permite 'En tránsito' o 'Entregado'.");
        }
    }
}