package main;

import java.io.OutputStream;
import java.util.Scanner;

public class PedirNumeros {
    public static void main(String[] args) {
        String ruta = "bin";
        Scanner teclado = new Scanner(System.in);

        StringBuilder datos = new StringBuilder();
        System.out.println("Introduce números (* para terminar):");
        String linea;
        do {
            linea = teclado.nextLine();
            datos.append(linea).append("\n");
        } while (!linea.trim().equals("*"));

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "main.SumaNumeros");
            Process p = pb.start();

            OutputStream os = p.getOutputStream();
            os.write(datos.toString().getBytes());
            os.flush();

            int codigo = (byte) p.waitFor();

            if (codigo == 0) {
                Scanner salida = new Scanner(p.getInputStream());
                while (salida.hasNextLine()) {
                    System.out.println(salida.nextLine());
                }
                salida.close();
            } else {
                System.out.println("Error (" + codigo + "): se ha introducido una cadena no numérica.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        teclado.close();
    }
}
