package practicaMultiprocesoIII;

public class Validador {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].trim().isEmpty()) {
            System.exit(-1);
        }
        try {
            int n = Integer.parseInt(args[0].trim());
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
