package main;

public class Palindromo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(-1);
        }
        String limpia = args[0].toLowerCase().replaceAll("[^a-z0-9áéíóúüñ]", "");
        String inversa = new StringBuilder(limpia).reverse().toString();

        if (limpia.equals(inversa)) {
            System.out.println("Es palindromo.");
            System.exit(0);
        } else {
            System.out.println("NO es palindromo.");
            System.exit(1);
        }
    }
}
