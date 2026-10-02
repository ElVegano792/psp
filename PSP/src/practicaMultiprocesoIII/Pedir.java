package practicaMultiprocesoIII;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Pedir {
    public static void main(String[] args) {
        String ruta = "bin";
        Scanner teclado = new Scanner(System.in);

//        System.out.print("Introduce un número entero positivo: ");
//        String dato = teclado.nextLine();
        
//        Partiendo del ejercicio 1 de la práctica anterior, realiza los cambios necesarios para que la
//        entrada al primer programa se haga a partir de un fichero llamado dato.txt en lugar de
//        recibirlo por argumento.
        
        try {
//            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "main.Validador");
        	ProcessBuilder pb = new ProcessBuilder("java","practicaMultiprocesoIII.Validador");
        	File fBat = new File("..","ejercicio1Entrada.txt");
            pb.redirectInput(fBat);
            Process p = pb.start();
            int codigo = p.waitFor();
            FileReader fr = new FileReader(fBat);

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
            fr.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        teclado.close();
    }
}
