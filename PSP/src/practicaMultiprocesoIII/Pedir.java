package practicaMultiprocesoIII;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Pedir {
    public static void main(String[] args) {
        String ruta = "bin";
        File fBat = new File("src","ejercicio1Entrada.txt");
        
        try {
        	
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta,"practicaMultiprocesoIII.Validador");
            pb.redirectInput(fBat);
        	
            Process p = pb.start();
            int codigo = p.waitFor();
            

            switch (codigo) {
                case -3,253:
                    System.out.println("Has escrito un entero positivo.");
                    break;
                case 0:
                    System.out.println("El número debe ser positivo.");
                    break;
                case -1,255:
                    System.out.println("El argumento está vacío.");
                    break;
                case -2,254:
                    System.out.println("No has escrito un entero.");
                    break;
                default:
                    System.out.println("Código desconocido: " + codigo);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
