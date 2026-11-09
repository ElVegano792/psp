package practicaMultiHiloII;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		int totalJugadores = 5;
		if (args.length > 0) {
			try {
				totalJugadores = Math.max(1, Integer.parseInt(args[0]));
			} catch (NumberFormatException e) {
				System.err.println("Argumento no válido, se usan 3 jugadores.");
			}
		}

		Arbitro arbitro = new Arbitro(totalJugadores);

		Jugador[] jugadores = new Jugador[totalJugadores];
		for (int i = 0; i < totalJugadores; i++) {
			jugadores[i] = new Jugador(i + 1, arbitro);
		}
		for (Jugador jugador: jugadores) {
			jugador.start();
		}
		for (Jugador jugador: jugadores) {
			jugador.join();
		}
	}
}
