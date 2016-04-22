package logika;

import java.util.ArrayList;
import java.util.List;

public class Strategija {
	private String naziv;
	private double sumaUkupnihAtraktivnosti;
	
	private List<SnagaStrat> snage;
	private List<SlabostStrat> slabosti;
	private List<SansaStrat> sanse;
	private List<PretnjaStrat> pretnje;
	
	public Strategija(String naziv) {
		this.naziv = naziv;
		snage = new ArrayList<SnagaStrat>();
		slabosti = new ArrayList<SlabostStrat>();
		sanse = new ArrayList<SansaStrat>();
		pretnje = new ArrayList<PretnjaStrat>();
	}
	
	public void dodajSnagu(Snaga snaga, int atraktivnost){
		SnagaStrat s = new SnagaStrat(snaga.getNaziv(), snaga.getPonder(), atraktivnost);
		snage.add(s);
	}
}
