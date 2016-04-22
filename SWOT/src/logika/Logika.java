package logika;

import java.util.ArrayList;
import java.util.List;

public class Logika {
	private static ArrayList<Strategija> strategije = new ArrayList<>();
	private static ArrayList<Swot> listaSnage = new ArrayList<>();
	private static ArrayList<Swot> listaSlabosti = new ArrayList<>();
	private static ArrayList<Swot> listaSanse = new ArrayList<>();
	private static ArrayList<Swot> listaPretnje = new ArrayList<>();

//	public Logika() {
//		strategije = new ArrayList<Strategija>();
//		listaSnage = new ArrayList<Swot>();
//		listaSlabosti = new ArrayList<Swot>();
//		listaSanse = new ArrayList<Swot>();
//		listaPretnje = new ArrayList<Swot>();
//	}

	public static ArrayList<Strategija> getStrategije() {
		return strategije;
	}

	public void setStrategije(ArrayList<Strategija> strategije) {
		this.strategije = strategije;
	}

	public static ArrayList<Swot> getListaSnage() {
		return listaSnage;
	}

	public void setListaSnage(ArrayList<Swot> listaSnage) {
		this.listaSnage = listaSnage;
	}

	public static ArrayList<Swot> getListaSlabosti() {
		return listaSlabosti;
	}

	public void setListaSlabosti(ArrayList<Swot> listaSlabosti) {
		this.listaSlabosti = listaSlabosti;
	}

	public static ArrayList<Swot> getListaSanse() {
		return listaSanse;
	}

	public void setListaSanse(ArrayList<Swot> listaSanse) {
		this.listaSanse = listaSanse;
	}

	public static ArrayList<Swot> getListaPretnje() {
		return listaPretnje;
	}

	public void setListaPretnje(ArrayList<Swot> listaPretnje) {
		this.listaPretnje = listaPretnje;
	}

}
