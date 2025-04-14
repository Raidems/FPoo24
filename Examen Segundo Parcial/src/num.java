import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class num {
    private int numero;
    private String romano;

    private final LinkedHashMap<String, Integer> romanos = new LinkedHashMap<>();

    public num() {
        romanos.put("L", 50);
        romanos.put("XL", 40);
        romanos.put("X", 10);
        romanos.put("IX", 9);
        romanos.put("V", 5);
        romanos.put("IV", 4);
        romanos.put("I", 1);
    }

    public void convertirArabigoARomano(String entrada) {
        try {
            int num = Integer.parseInt(entrada);
            if (num < 1 || num > 50) {
                JOptionPane.showMessageDialog(null, "Número fuera del rango permitido (1-50).");
                return;
            }

            StringBuilder resultado = new StringBuilder();
            int temp = num;

            for (Map.Entry<String, Integer> entry : romanos.entrySet()) {
                while (temp >= entry.getValue()) {
                    resultado.append(entry.getKey());
                    temp -= entry.getValue();
                }
            }

            JOptionPane.showMessageDialog(null, "Número romano: " + resultado.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Solo se aceptan números enteros.");
        }
    }

    public void convertirRomanoAArabigo(String entrada) {
        if (!validarRomano(entrada)) {
            JOptionPane.showMessageDialog(null, "Número romano no válido.");
            return;
        }

        String roman = entrada.toUpperCase();
        int resultado = 0;
        int i = 0;

        while (i < roman.length()) {
            String dos = (i + 1 < roman.length()) ? roman.substring(i, i + 2) : "";
            if (romanos.containsKey(dos)) {
                resultado += romanos.get(dos);
                i += 2;
            } else {
                String uno = roman.substring(i, i + 1);
                if (romanos.containsKey(uno)) {
                    resultado += romanos.get(uno);
                    i++;
                } else {
                    JOptionPane.showMessageDialog(null, "Carácter inválido.");
                    return;
                }
            }
        }

        if (resultado < 1 || resultado > 50) {
            JOptionPane.showMessageDialog(null, "Número arábigo fuera del rango permitido (1-50).");
        } else {
            JOptionPane.showMessageDialog(null, "Número arábigo: " + resultado);
        }
    }

    public boolean validarRomano(String romano) {
        return romano != null && romano.toUpperCase().matches("^(L|XL|X{0,3}(IX|IV|V?I{0,3})?)$");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRomano() {
        return romano;
    }

    public void setRomano(String romano) {
        this.romano = romano;
    }
}
