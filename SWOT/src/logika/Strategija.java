package logika;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andrija Djordjevic 
 * 
 * Klasa koja predstavlja strategiju koju korisnik kreira kombinovanjem snaga,
 *  slabosti, sansi i pretnji i odgovarajucih atratktivnosti.
 *  
 *
 */
public class Strategija implements Serializable{
	private String naziv;
	private double sumaUkupnihAtraktivnosti;
	
	private List<SwotStrat> snage;
	private List<SwotStrat> slabosti;
	private List<SwotStrat> sanse;
	private List<SwotStrat> pretnje;
	
	public Strategija() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parametrizovani konstruktor koji pri kreiranju strategije kreira i prazne liste snaga,
	 *  slabosti, sansi i pretnji u koje ce biti unete iste. Suma ukupnih atraktivnosti se inicijalizuje 
	 *  na 0, a kada korisnik zavrsi sa unosom snaga, slabosti, sansi i pretnji i odgovarajucih
	 *  atraktivnosti, suma ukpnih atraktivnoti se izracunava.
	 * @param naziv 
	 */
	public Strategija(String naziv) {
		this.naziv = naziv;
		snage = new ArrayList<SwotStrat>();
		slabosti = new ArrayList<SwotStrat>();
		sanse = new ArrayList<SwotStrat>();
		pretnje = new ArrayList<SwotStrat>();
		sumaUkupnihAtraktivnosti = 0;
	}
	
	/**
	 * 
	 * @return naziv strategije
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * 
	 * @return double
	 */
	public double getSumaUkupnihAtraktivnosti() {
		return sumaUkupnihAtraktivnosti;
	}

	/**
	 * 
	 * @return lista snaga dodatih u ovu strategiju
	 */
	public List<SwotStrat> getSnage() {
		return snage;
	}

	/**
	 * 
	 * @return lista slabosti dodatih u ovu strategiju
	 */
	public List<SwotStrat> getSlabosti() {
		return slabosti;
	}

	/**
	 * 
	 * @return lista sansi dodatih u ovu strategiju
	 */
	public List<SwotStrat> getSanse() {
		return sanse;
	}

	/**
	 * 
	 * @return lista pretnji dodatih u ovu strategiju
	 */
	public List<SwotStrat> getPretnje() {
		return pretnje;
	}

	/**
	 * Metoda dodaje snagu u listu snaga ove strategije
	 * @param snaga
	 * @param atraktivnost
	 */
	public void dodajSnagu(SwotStrat snaga, int atraktivnost){
		SwotStrat s = new SwotStrat(snaga.getNaziv(), snaga.getPonder(), atraktivnost);
		snage.add(s);
	}
	/**
	 * Metoda dodaje slabost u listu slabosti ove strategije
	 * @param slabost
	 * @param atraktivnost
	 */
	public void dodajSlabost(SwotStrat slabost, int atraktivnost){
		SwotStrat s = new SwotStrat(slabost.getNaziv(), slabost.getPonder(), atraktivnost);
		slabosti.add(s);
	}
	/**
	 * Metoda dodaje sansu u listu sansi ove strategije
	 * @param sansa
	 * @param atraktivnost
	 */
	public void dodajSansu(SwotStrat sansa, int atraktivnost){
		SwotStrat s = new SwotStrat(sansa.getNaziv(), sansa.getPonder(), atraktivnost);
		sanse.add(s);
	}
	/**
	 * Metoda dodaje pretnju u listu pretnji ove strategije
	 * @param pretnja
	 * @param atraktivnost
	 */
	public void dodajPretnju(SwotStrat pretnja, int atraktivnost){
		SwotStrat s = new SwotStrat(pretnja.getNaziv(), pretnja.getPonder(), atraktivnost);
		pretnje.add(s);
	}
	/**
	 * Metoda prolazi kroz liste snaga, slabosti, sansi, pretnji i sumira atraktivnosti. Suma ukupnih 
	 * atraktivnosti predstavlja atraktivnost same strategije.
	 */
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
	/**
	 * Redefinisana equals metoda koja poredi objekte klase strategija na osnovu naziva.
	 * @return true ako su nazivi strategija isti, false inace
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof Strategija){
				Strategija pom = (Strategija)obj;
				return naziv.equals(pom.getNaziv());
			}
		}
		return false;
	}
}
