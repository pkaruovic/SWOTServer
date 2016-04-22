package logika;

public class Slabost {
	private String naziv;
	private double ponder;
	public Slabost(String naziv, double ponder) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Slabost - naziv");
		if(ponder < 0 || ponder > 1)
			throw new RuntimeException("Slabost - ponder");
		this.naziv = naziv;
		this.ponder = ponder;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Slabost - naziv");
		this.naziv = naziv;
	}
	public double getPonder() {
		return ponder;
	}
	public void setPonder(double ponder) {
		if(ponder < 0 || ponder > 1)
			throw new RuntimeException("Slabost - ponder");
		this.ponder = ponder;
	}
	
}
