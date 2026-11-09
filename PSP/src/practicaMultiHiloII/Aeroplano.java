package practicaMultiHiloII;

public class Aeroplano extends Thread {

	public enum Tipo {
		AVION(3000), AVIONETA(2000);

		private final long intervaloMs;

		Tipo(long intervaloMs) {
			this.intervaloMs = intervaloMs;
		}

		public long getIntervaloMs() {
			return intervaloMs;
		}
	}

	private final Tipo tipo;
	private final Pista pista;

	private long llegada;
	private long entrada;
	private long despegue;

	public Aeroplano(int numero, Tipo tipo, Pista pista) {
		
		super("Thread-" + numero);
		this.tipo = tipo;
		this.pista = pista;
		
	}

	public Tipo getTipo() {
		return tipo;
	}

	long getLlegada() {
		return llegada;
	}

	long getEntrada() {
		return entrada;
	}

	long getDespegue() {
		return despegue;
	}

	void setLlegada(long llegada) {
		this.llegada = llegada;
	}

	void setEntrada(long entrada) {
		this.entrada = entrada;
	}

	void setDespegue(long despegue) {
		this.despegue = despegue;
	}

	@Override
	public void run() {
		try {
			long espera = pista.entrar(this);
			Thread.sleep(espera);
			pista.salir(this);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
