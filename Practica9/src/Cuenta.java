import javax.swing.*;

public class Cuenta {

    //Atributos
    private String NoCuenta;
    private String titular;
    private int edad;
    private double saldo;

    //Constructor
    public Cuenta(String NoCuenta, String titular, int edad, double saldo) {
        this.NoCuenta = NoCuenta;
        this.titular = titular;
        this.edad = edad;
        this.saldo = saldo;
    }

    //Métodos
    public String consultarsaldo() {
        return "No. cuenta: " + NoCuenta + "\nTitular: " + titular + "\nSaldo: $" + saldo;
    }

    public void ingresarEfectivo(double monto) {
        if (monto > 0) {
            saldo += monto;
            JOptionPane.showMessageDialog(null, "Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.");
        }
    }

    public void retirarEfectivo(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "Retiro Exitoso. Nuevo saldo: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        }
    }

    public void depositar(Cuenta cuentaDestino, double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo += monto;
            cuentaDestino.ingresarEfectivo(monto);
            JOptionPane.showMessageDialog(null, "Deposito exitoso. Nuevo saldo: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        }
    }


    //ZONA DE GET Y SET

    public String getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        NoCuenta = noCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}// clase Cuenta
