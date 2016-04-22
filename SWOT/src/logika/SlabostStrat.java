package logika;

public class SlabostStrat extends Slabost {
	private int atraktivnost;
	private double ukupnaAtraktivnost;
	public SlabostStrat(String naziv, double ponder, int atraktivnost) {
		super(naziv, ponder);
		this.atraktivnost = atraktivnost;
		ukupnaAtraktivnost = super.getPonder()*atraktivnost;
	}
	public int getAtraktivnost() {
		return atraktivnost;
	}
	public void setAtraktivnost(int atraktivnost) {
		this.atraktivnost = atraktivnost;
		ukupnaAtraktivnost = super.getPonder()*atraktivnost;
	}
	public double getUkupnaAtraktivnost() {
		return ukupnaAtraktivnost;
	}
	
	
}
