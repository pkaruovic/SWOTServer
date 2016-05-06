package logika;

import java.io.Serializable;

public class SwotStrat extends Swot implements Serializable{
	private int atraktivnost;
	private double ukupnaAtraktivnost;

	public SwotStrat(String naziv, double ponder, int atraktivnost) {
		super(naziv, ponder);
		this.atraktivnost = atraktivnost;
		ukupnaAtraktivnost = super.getPonder() * atraktivnost;
		System.out.println(ponder);
	}

	public int getAtraktivnost() {
		return atraktivnost;
	}

	public void setAtraktivnost(int atraktivnost) {
		this.atraktivnost = atraktivnost;
		ukupnaAtraktivnost = super.getPonder() * atraktivnost;
	}

	public double getUkupnaAtraktivnost() {
		return ukupnaAtraktivnost;
	}

}
