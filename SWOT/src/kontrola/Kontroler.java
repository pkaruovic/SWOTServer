package kontrola;

import java.awt.EventQueue;
import java.util.ArrayList;

import gui.GlavniProzor;
import logika.Logika;
import logika.Strategija;
import logika.Swot;

public class Kontroler {
	private static GlavniProzor frame;
	private static Logika logika;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logika = new Logika();
					frame = new GlavniProzor();
					frame.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Strategija kreirajStrategiju(String naziv) {
		return new Strategija(naziv);
	}

	public static void dodajStrategiju(Strategija strategija) {

	}

	public static void dodajSnagu(String naziv, double ponder) {
		logika.dodajSnaguUListu(naziv, ponder);
		popuniTabeluSnage(logika.getListaSnage());
	}
	public static void dodajSlabost(String naziv, double ponder) {
		logika.dodajSlabostUListu(naziv, ponder);
		popuniTabeluSlabosti(logika.getListaSlabosti());
	}
	public static void dodajSansu(String naziv, double ponder) {
		logika.dodajSansuUListu(naziv, ponder);
		popuniTabeluSanse(logika.getListaSanse());
	}
	public static void dodajPretnju(String naziv, double ponder) {
		logika.dodajPretnjuUListu(naziv, ponder);
		popuniTabeluPretnje(logika.getListaPretnje());
	}

	public static void popuniTabeluSnage(ArrayList listaSnage) {

	}
	public static void popuniTabeluSlabosti(ArrayList listaSlabosti) {

	}
	public static void popuniTabeluSanse(ArrayList listaSanse) {

	}
	public static void popuniTabeluPretnje(ArrayList listaPretnje) {

	}

	public static ArrayList<Strategija> getListaStrategija(){
		return logika.getStrategije();
	}
	
	public static ArrayList<Swot> getListaSnage() {
		// TODO Auto-generated method stub
		return logika.getListaSnage();
	}

	public static ArrayList<Swot> getListaSlabosti() {
		// TODO Auto-generated method stub
		return logika.getListaSlabosti();
	}

	public static ArrayList<Swot> getListaSanse() {
		// TODO Auto-generated method stub
		return logika.getListaSanse();
	}

	public static ArrayList<Swot> getListaPretnje() {
		// TODO Auto-generated method stub
		return logika.getListaPretnje();
	}

	public static double getPonder(String naziv) {
		// TODO Auto-generated method stub
		return logika.vratiPonderSnagaNaziv(naziv);
	}
	
}
