import javax.swing.*;

public class Cuenta {

    //Atributos
    public String NoCuenta;
    String titular;
    int edad;
    double saldo;

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
}// clase Cuenta
