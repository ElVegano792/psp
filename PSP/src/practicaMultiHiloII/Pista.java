package practicaMultiHiloII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Pista {

	private final long inicio = System.currentTimeMillis();
	private final Deque<Aeroplano> aviones = new ArrayDeque<>();
	private final Deque<Aeroplano> avionetas = new ArrayDeque<>();
	private final List<Aeroplano> despegues = new ArrayList<>();
	private boolean ocupada = false;
	private long intervaloSiguienteMs = 2000;

	private long ahora() {
		return System.currentTimeMillis() - inicio;
	}

	private Deque<Aeroplano> cola(Aeroplano a) {
		return a.getTipo() == Aeroplano.Tipo.AVION ? aviones : avionetas;
	}

	private Aeroplano siguiente() {
		return !aviones.isEmpty() ? aviones.peekFirst() : avionetas.peekFirst();
	}

	public synchronized long entrar(Aeroplano a) throws InterruptedException {
		a.setLlegada(ahora());
		cola(a).addLast(a);
		System.out.println("Llega a pista el/la " + a.getTipo() + " con número " + a.getName());

		while (ocupada || siguiente() != a) {
			wait();
		}

		cola(a).removeFirst();
		ocupada = true;
		a.setEntrada(ahora());
		System.out.println("Aeroplano de tipo: " + a.getTipo() + " con número " + a.getName() + " entra en la pista de despegue...");
		return intervaloSiguienteMs;
	}

	public synchronized void salir(Aeroplano a) {
		a.setDespegue(ahora());
		despegues.add(a);
		intervaloSiguienteMs = a.getTipo().getIntervaloMs();
		System.out.println("Aeroplano de tipo: " + a.getTipo() + " con número " + a.getName() + " ha despegado.");
		ocupada = false;
		notifyAll();
	}

	public synchronized List<Aeroplano> getDespegues() {
		return new ArrayList<>(despegues);
	}
}
