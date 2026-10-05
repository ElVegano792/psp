package practicaMultiprocesoIII;

import java.io.File;

public class PedirNumeros {

	public static void main(String[] args) {
		
		String ruta = "bin";
        File datos = new File("src", "datos.txt");
        File suma  = new File("src", "suma.txt");
        File error = new File("src", "error.txt");

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "main.SumaNumeros");
            pb.redirectInput(datos);
            pb.redirectOutput(suma);
            pb.redirectError(error);

            int codigo = (byte) pb.start().waitFor();

            if (codigo == 0) {
                System.out.println("Programa finalizado. Resultado guardado en suma.txt.");
            } else {
                System.err.println("Ha ocurrido un error. Revisa error.txt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
