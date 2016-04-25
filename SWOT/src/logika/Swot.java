package logika;

import java.io.Serializable;

public class Swot implements Serializable{
	private String naziv;
	private double ponder;

	public Swot(String naziv, double ponder) {
		if (naziv == null || naziv.isEmpty())
			throw new RuntimeException("naziv");
		if (ponder < 0 || ponder > 1)
			throw new RuntimeException("ponder");
		this.naziv = naziv;
		this.ponder = ponder;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.isEmpty())
			throw new RuntimeException("naziv");
		this.naziv = naziv;
	}

	public double getPonder() {
		return ponder;
	}

	public void setPonder(double ponder) {
		if (ponder < 0 || ponder > 1)
			throw new RuntimeException("ponder");
		this.ponder = ponder;
	}
}
