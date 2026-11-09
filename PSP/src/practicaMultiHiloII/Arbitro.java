package practicaMultiHiloII;

public class Arbitro {

	private final int totalJugadores;
	private final int numeroAdivinar;
	private int turno;
	private boolean juegoTerminado;

	public Arbitro(int totalJugadores) {
		this.totalJugadores = totalJugadores;
		this.numeroAdivinar = 1 + (int) (10 * Math.random());
		this.turno = 1;
		this.juegoTerminado = false;
		System.out.println("Número a adivinar: " + numeroAdivinar);
	}

	public synchronized int getTurno() {
		return turno;
	}

	public synchronized boolean isJuegoTerminado() {
		return juegoTerminado;
	}

	public synchronized boolean esperarTurno(int id) throws InterruptedException {
		while (!juegoTerminado && turno != id) {
			wait();
		}
		return !juegoTerminado;
	}

	public synchronized void jugada(int id, int numero) {
		if (juegoTerminado || id != turno) {
			return;
		}

		System.out.println("Jugador " + id + " dice: " + numero);

		if (numero == numeroAdivinar) {
			juegoTerminado = true;
			System.out.println("Jugador " + id + " gana, adivinó el número.");
		} else {
			turno = (id % totalJugadores) + 1;
			System.out.println("Le toca a jugador " + turno);
		}

		notifyAll();
	}
}
