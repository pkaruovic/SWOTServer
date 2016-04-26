package logika;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Logika implements Serializable{
	private ArrayList<Strategija> strategije = new ArrayList<Strategija>();
	private ArrayList<Swot> listaSnage = new ArrayList<Swot>();
	private ArrayList<Swot> listaSlabosti = new ArrayList<Swot>();
	private ArrayList<Swot> listaSanse = new ArrayList<Swot>();
	private ArrayList<Swot> listaPretnje = new ArrayList<Swot>();

//	public Logika() {
//		strategije;
//		listaSnage = new ArrayList<Swot>();
//		listaSlabosti = new ArrayList<Swot>();
//		listaSanse = new ArrayList<Swot>();
//		listaPretnje;
//	}

	public ArrayList<Strategija> getStrategije() {
		return strategije;
	}

	public void setStrategije(ArrayList<Strategija> strategije) {
		this.strategije = strategije;
	}

	public ArrayList<Swot> getListaSnage() {
		return listaSnage;
	}

	public void setListaSnage(ArrayList<Swot> listaSnage) {
		this.listaSnage = listaSnage;
	}

	public ArrayList<Swot> getListaSlabosti() {
		return listaSlabosti;
	}

	public void setListaSlabosti(ArrayList<Swot> listaSlabosti) {
		this.listaSlabosti = listaSlabosti;
	}

	public ArrayList<Swot> getListaSanse() {
		return listaSanse;
	}

	public void setListaSanse(ArrayList<Swot> listaSanse) {
		this.listaSanse = listaSanse;
	}

	public ArrayList<Swot> getListaPretnje() {
		return listaPretnje;
	}

	public void setListaPretnje(ArrayList<Swot> listaPretnje) {
		this.listaPretnje = listaPretnje;
	}
	
	public void dodajStrategijuUListu(Strategija strategija){
		for(int i=0; i<strategije.size(); i++){
			if(strategija.getSumaUkupnihAtraktivnosti() > strategije.get(i).getSumaUkupnihAtraktivnosti()){
				strategije.add(i, strategija);
				return;
			}
		}
		strategije.add(strategija);
	}
	public void dodajSnaguUListu(String naziv, double ponder){
		listaSnage.add(new Swot(naziv, ponder));
	}
	
	public void dodajSansuUListu(String naziv, double ponder){
		listaSanse.add(new Swot(naziv, ponder));
	}
	
	public void dodajSlabostUListu(String naziv, double ponder){
		listaSlabosti.add(new Swot(naziv, ponder));
	}
	
	public void dodajPretnjuUListu(String naziv, double ponder){
		listaPretnje.add(new Swot(naziv, ponder));
	}
	
	public double vratiPonderSnagaNaziv(String naziv){
		//dodaj kontrolu u gui-u da uopste ne moze da pozove ako je naziv null ili prazan
		if(naziv == null || naziv.isEmpty())
		for (Swot swot : listaSnage) {
			if(swot.getNaziv().equals(naziv))
				return swot.getPonder();
		}
		return 0;//nece doci do ovoga kada se uvede kontrola
	}
	
	public double vratiPonderSansaNaziv(String naziv){
		//dodaj kontrolu u gui-u da uopste ne moze da pozove ako je naziv null ili prazan
		if(naziv == null || naziv.isEmpty())
		for (Swot swot : listaSanse) {
			if(swot.getNaziv().equals(naziv))
				return swot.getPonder();
		}
		return 0;//nece doci do ovoga kada se uvede kontrola
	}
	public double vratiPonderSlabostNaziv(String naziv){
		//dodaj kontrolu u gui-u da uopste ne moze da pozove ako je naziv null ili prazan
		if(naziv == null || naziv.isEmpty())
		for (Swot swot : listaSlabosti) {
			if(swot.getNaziv().equals(naziv))
				return swot.getPonder();
		}
		return 0;//nece doci do ovoga kada se uvede kontrola
	}
	
	public double vratiPonderPretnjaNaziv(String naziv){
		//dodaj kontrolu u gui-u da uopste ne moze da pozove ako je naziv null ili prazan
		if(naziv == null || naziv.isEmpty())
		for (Swot swot : listaPretnje) {
			if(swot.getNaziv().equals(naziv))
				return swot.getPonder();
		}
		return 0;//nece doci do ovoga kada se uvede kontrola
	}
}
