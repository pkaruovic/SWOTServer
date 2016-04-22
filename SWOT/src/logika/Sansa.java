package logika;

public class Sansa {
	private String naziv;
	private double ponder;
	
	public Sansa(String naziv, double ponder) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Sansa - naziv");
		if(ponder < 0 || ponder > 1)
			throw new RuntimeException("Sansa - ponder");
		this.naziv = naziv;
		this.ponder = ponder;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Sansa - naziv");
		this.naziv = naziv;
	}
	public double getPonder() {
		return ponder;
	}
	public void setPonder(double ponder) {
		if(ponder < 0 || ponder > 1)
			throw new RuntimeException("Sansa - ponder");
		this.ponder = ponder;
	}

}
