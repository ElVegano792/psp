package ejercicioPruebaHilo;

public class Contador {
	
	private int contador;
	private int contador2;
	
	public Contador() {
		
	}
	
	// Un metodo sincronizado por el que solo puede pasar un hilo a la vez, hasta que uno no sale otro no entra \\
	public synchronized void sumar() {
		this.contador2++;
		// Este bloque sirve para sincronizar lo que introduzcas dentro \\
		synchronized(this) {
			this.contador++;
		}
	}

	public int getContador() {
		return this.contador;
	}
	
	public int getContador2() {
		return this.contador2;
	}
	
}