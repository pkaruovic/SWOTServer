package logika;

public class SansaStrat extends Sansa {
	private int atraktivnost;
	private double ukupnaAtraktivnost;
	public SansaStrat(String naziv, double ponder, int atraktivnost) {
		super(naziv, ponder);
		this.atraktivnost = atraktivnost;
		ukupnaAtraktivnost = super.getPonder()* atraktivnost;
	}
	public int getAtraktivnost() {
		return atraktivnost;
	}
	public void setAtraktivnost(int atraktivnost) {
		this.atraktivnost = atraktivnost;
		ukupnaAtraktivnost = super.getPonder()* atraktivnost;
	}
	public double getUkupnaAtraktivnost() {
		return ukupnaAtraktivnost;
	}
	
	
}
