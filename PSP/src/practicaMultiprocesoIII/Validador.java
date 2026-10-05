package practicaMultiprocesoIII;

import java.util.Scanner;

public class Validador {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLine()) {
            sc.close();
            System.exit(-1);
        }
        String linea = sc.nextLine().trim();
        sc.close();

        if (linea.isEmpty()) {
            System.exit(-1);
        }
        try {
            int n = Integer.parseInt(linea);
            if (n > 0) {
                System.exit(-3);
            } else {
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.exit(-2);
        }
    }
    
}
