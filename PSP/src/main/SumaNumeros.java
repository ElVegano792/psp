package main;

import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        StringBuilder salida = new StringBuilder();
        double suma = 0;

        while (teclado.hasNextLine()) {
            String linea = teclado.nextLine().trim();
            if (linea.equals("*")) {
                break;
            }
            try {
                suma += Double.parseDouble(linea);
                salida.append("Escrito ").append(linea).append("\n");
            } catch (NumberFormatException e) {
                System.exit(-1);
            }
        }
        salida.append("La suma es: ").append(suma);
        System.out.println(salida);
        System.exit(0);
        teclado.close();
    }
}
