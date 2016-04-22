package logika;

import java.util.ArrayList;
import java.util.List;

public class Strategija {
	private String naziv;
	private double sumaUkupnihAtraktivnosti;
	
	private List<SwotStrat> snage;
	private List<SwotStrat> slabosti;
	private List<SwotStrat> sanse;
	private List<SwotStrat> pretnje;
	
	public Strategija() {
		// TODO Auto-generated constructor stub
	}
	
	public Strategija(String naziv) {
		this.naziv = naziv;
		snage = new ArrayList<SwotStrat>();
		slabosti = new ArrayList<SwotStrat>();
		sanse = new ArrayList<SwotStrat>();
		pretnje = new ArrayList<SwotStrat>();
		sumaUkupnihAtraktivnosti = 0;
	}
	
	
	public String getNaziv() {
		return naziv;
	}


	public double getSumaUkupnihAtraktivnosti() {
		return sumaUkupnihAtraktivnosti;
	}


	public List<SwotStrat> getSnage() {
		return snage;
	}


	public List<SwotStrat> getSlabosti() {
		return slabosti;
	}


	public List<SwotStrat> getSanse() {
		return sanse;
	}


	public List<SwotStrat> getPretnje() {
		return pretnje;
	}


	public void dodajSnagu(SwotStrat snaga, int atraktivnost){
		SwotStrat s = new SwotStrat(snaga.getNaziv(), snaga.getPonder(), atraktivnost);
		snage.add(s);
	}
	public void dodajSlabost(SwotStrat slabost, int atraktivnost){
		SwotStrat s = new SwotStrat(slabost.getNaziv(), slabost.getPonder(), atraktivnost);
		slabosti.add(s);
	}
	public void dodajSansu(SwotStrat sansa, int atraktivnost){
		SwotStrat s = new SwotStrat(sansa.getNaziv(), sansa.getPonder(), atraktivnost);
		sanse.add(s);
	}
	public void dodajPretnju(SwotStrat pretnja, int atraktivnost){
		SwotStrat s = new SwotStrat(pretnja.getNaziv(), pretnja.getPonder(), atraktivnost);
		pretnje.add(s);
	}
	public void izracunajSumuUkupnihAtraktivnosti(){
		for (SwotStrat swotStrat : pretnje) {
			sumaUkupnihAtraktivnosti+= swotStrat.getUkupnaAtraktivnost();
		}
		for (SwotStrat swotStrat : snage) {
			sumaUkupnihAtraktivnosti+= swotStrat.getUkupnaAtraktivnost();
		}
		for (SwotStrat swotStrat: slabosti) {
			sumaUkupnihAtraktivnosti+= swotStrat.getUkupnaAtraktivnost();
		}
		for (SwotStrat swotStrat : sanse) {
			sumaUkupnihAtraktivnosti+= swotStrat.getUkupnaAtraktivnost();
		}
	}
}
