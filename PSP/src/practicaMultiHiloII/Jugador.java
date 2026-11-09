package practicaMultiHiloII;

public class Jugador extends Thread {

	private final int id;
	private final Arbitro arbitro;

	public Jugador(int id, Arbitro arbitro) {
		super("Jugador " + id);
		this.id = id;
		this.arbitro = arbitro;
	}

	@Override
	public void run() {
		try {
			while (arbitro.esperarTurno(id)) {
				int numero = 1 + (int) (10 * Math.random());
				arbitro.jugada(id, numero);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
