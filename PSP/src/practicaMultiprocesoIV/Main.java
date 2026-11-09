package practicaMultiprocesoIV;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		String java = System.getProperty("java.home") + "/bin/java";
		String classpath = System.getProperty("java.class.path");

		ProcessBuilder pbEscritor = new ProcessBuilder(java, "-cp", classpath, "practicaMultiprocesoIV.Escritor");
		ProcessBuilder pbLector = new ProcessBuilder(java, "-cp", classpath, "practicaMultiprocesoIV.Lector");

		pbEscritor.inheritIO();
		pbLector.inheritIO();

		Process escritor = pbEscritor.start();
		Thread.sleep(500);
		Process lector = pbLector.start();

		escritor.waitFor();
		lector.waitFor();
		
	}

}
