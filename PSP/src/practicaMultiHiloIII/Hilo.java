package practicaMultiHiloIII;

public class Hilo extends Thread {

	Playa playa;
	
	public Hilo(Playa  playa) {
		super();
		this.playa = playa;
	}
	
	public void run() {
		playa.rescatar(this.getName());
	}
	
}