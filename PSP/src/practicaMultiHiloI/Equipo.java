package practicaMultiHiloI;

import java.util.List;

public class Equipo extends Thread {

	private final String nombre;
	private final List<Corredor> corredores;

	public Equipo(String nombre, List<Corredor> corredores) {
		super("Equipo-" + nombre);
		this.nombre = nombre;
		this.corredores = corredores;
	}

	@Override
	public void run() {
		
		try {
			for (Corredor corredor : corredores) {
				corredor.start();
				corredor.join();
			}
			System.out.println("FINAL DE PROGRAMA - " + nombre);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Carrera interrumpida - " + nombre);
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Equipo espana = new Equipo("España", List.of(new Corredor("España", "Pepe"), new Corredor("España", "Maria"),
				new Corredor("España", "Juan"), new Corredor("España", "Marta")));
		Equipo eeuu = new Equipo("EEUU", List.of(new Corredor("EEUU", "John"), new Corredor("EEUU", "Kim"),
				new Corredor("EEUU", "Mike"), new Corredor("EEUU", "Sarah")));

		espana.start();
		eeuu.start();

		espana.join();
		eeuu.join();
		
	}
}
