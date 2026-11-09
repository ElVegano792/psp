package practicaMultiHiloI;

public class Correr {

	public static void main(String[] args) throws InterruptedException {
		Corredor[] equipo = { new Corredor("España", "Pepe"), new Corredor("España", "Maria"),
				new Corredor("España", "Juan"), new Corredor("España", "Marta") };

		for (Corredor corredor : equipo) {
			corredor.start();
			corredor.join();
		}

		System.out.println("Fin");
		
	}
}
