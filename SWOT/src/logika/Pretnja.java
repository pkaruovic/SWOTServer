package logika;

public class Pretnja {
	private String naziv;
	private double ponder;
	public Pretnja(String naziv, double ponder) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Pretnja - naziv");
		if(ponder < 0 || ponder > 1)
			throw new RuntimeException("Pretnja - ponder");
		this.naziv = naziv;
		this.ponder = ponder;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Pretnja - naziv");
		this.naziv = naziv;
	}
	public double getPonder() {
		return ponder;
	}
	public void setPonder(double ponder) {
		if(ponder < 0 || ponder > 1)
			throw new RuntimeException("Pretnja - ponder");
		this.ponder = ponder;
	}

}
