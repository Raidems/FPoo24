import javax.swing.JOptionPane;

class envios {
    private String codigoEnvio;
    private String destino;
    private double peso;

    public envios(String codigoEnvio, String destino) {
        this.codigoEnvio = codigoEnvio;
        this.destino = destino;
        this.peso = 0;
    }

    public envios(String codigoEnvio, String destino, double peso) {
        this.codigoEnvio = codigoEnvio;
        this.destino = destino;
        this.peso = peso;
    }

    public static envios crearEnvio() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del envío:");
        String destino = JOptionPane.showInputDialog("Ingrese el destino del envío:");
        String respuesta = JOptionPane.showInputDialog("¿Desea ingresar el peso del envío? (Sí/No)");
        if (respuesta.equalsIgnoreCase("Sí")) {
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del envío (kg):"));
            return new envios(codigo, destino, peso);
        } else {
            return new envios(codigo, destino);
        }
    }

    public String getCodigoEnvio() { return codigoEnvio; }
    public String getDestino() { return destino; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}
