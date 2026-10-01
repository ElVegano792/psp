package main;

import java.util.Scanner;

public class Pedir {
    public static void main(String[] args) {
        String ruta = "bin";
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        String dato = teclado.nextLine();

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "main.Validador", dato);
            Process p = pb.start();
            int codigo = p.waitFor();

            switch (codigo) {
                case -3:
                    System.out.println("Has escrito un entero positivo.");
                    break;
                case 0:
                    System.out.println("El número debe ser positivo.");
                    break;
                case -1:
                    System.out.println("El argumento está vacío.");
                    break;
                case -2:
                    System.out.println("No has escrito un entero.");
                    break;
                default:
                    System.out.println("Código desconocido: " + codigo);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        teclado.close();
    }
}
