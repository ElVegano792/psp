package main;

import java.util.Scanner;

public class PedirPalindromo {
    public static void main(String[] args) {
        String ruta = "bin";
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una cadena: ");
        String cadena = teclado.nextLine();

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "main.Palindromo", cadena);
            Process p = pb.start();
            int codigo = p.waitFor();

            if (codigo == -1) {
                System.out.println("Error: no se recibió ninguna cadena.");
            } else {
                Scanner salida = new Scanner(p.getInputStream());
                System.out.println(salida.nextLine());
                salida.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        teclado.close();
    }
}
