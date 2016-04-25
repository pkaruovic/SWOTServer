package kontrola;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import gui.GUIDodajSWOT;
import gui.GlavniProzor;
import gui.ProzorNoviSwot;
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
	
	public static void ugasiAplikaciju() {
		int ugasi = JOptionPane.showConfirmDialog(frame.getContentPane(), "Da li zelite da ugasite program?", "Ugasi", JOptionPane.YES_NO_OPTION);
		
		if(ugasi == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	public static Strategija kreirajStrategiju(String naziv) {
		return new Strategija(naziv);
	}

	public static void dodajStrategiju(Strategija strategija) {

	}

	public static void dodajSnagu(String naziv, double ponder) {
		logika.dodajSnaguUListu(naziv, ponder);
		popuniTabeluSnage();
	}
	public static void dodajSlabost(String naziv, double ponder) {
		logika.dodajSlabostUListu(naziv, ponder);
		popuniTabeluSlabosti();
	}
	public static void dodajSansu(String naziv, double ponder) {
		logika.dodajSansuUListu(naziv, ponder);
		popuniTabeluSanse();
	}
	public static void dodajPretnju(String naziv, double ponder) {
		logika.dodajPretnjuUListu(naziv, ponder);
		popuniTabeluPretnje();
	}

	public static void popuniTabeluSnage() {
		frame.srediTabeluSnage(logika.getListaSnage());
		
	}
	public static void popuniTabeluSlabosti() {
		frame.srediTabeluSlabosti(logika.getListaSlabosti());
	}
	public static void popuniTabeluSanse() {
		frame.srediTabeluSanse(logika.getListaSanse());
	}
	public static void popuniTabeluPretnje() {
		frame.srediTabeluPretnje(logika.getListaPretnje());
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

	public static void napraviProzorNoviSwot() {
		ProzorNoviSwot prozorNoviSwot = new ProzorNoviSwot();
		prozorNoviSwot.setVisible(true);
		prozorNoviSwot.setLocationRelativeTo(null);
	}
}
