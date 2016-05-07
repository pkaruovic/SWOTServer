package kontrola;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import gui.GUIDodajSWOT;
import gui.GUIUporediStrategije;
import gui.GlavniProzor;
import gui.ProzorNoviSwot;
import logika.Logika;
import logika.Strategija;
import logika.Swot;
/**
 * 
 * @author Petar Karuovic, Miljan Jovic, Andrija Djordjevic
 * 
 * Klasa koja povezuje korisnicki interfejs i poslovnu logiku i koristi se za pokretanje aplikacije.
 * 
 */
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
	/**
	 * Metoda koja cuva stanje programa (sve strategije, snage, slabosti, sanse i pretnje koje je korisnik uneo).
	 * 
	 * 
	 * @param nazivFajla - naziv fajla koji se kreira na disku, korisnik ga unosi sam
	 */
	public static void serijalizuj(String nazivFajla){
		
		JFileChooser jfcSave = new JFileChooser();
	//	jfcSave.setCurrentDirectory(new File(".\\saved"));
		jfcSave.setCurrentDirectory(new File(System.getProperty("user.home")));
		jfcSave.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//jfcSave.showSaveDialog(null);
		int povratnaVrednost = jfcSave.showSaveDialog(frame.getContentPane());
		
		if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			
			String kosaCrta = System.getProperty("file.separator");
			String path = jfcSave.getSelectedFile().getAbsolutePath();
			File file = new File(path+kosaCrta+nazivFajla);
		//	String absPathFajla = file.getAbsolutePath();

			try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
				out.writeObject(logika);
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JOptionPane.showMessageDialog(frame.getContentPane(), "Uspesno ste sacuvali fajl!", "Poruka",
					JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	/**
	 * Metoda koja omogucava korisniku da vrati sacuvano stanje programa.
	 */
	public static void deserijalizuj(){
		JFileChooser jfcOpen = new JFileChooser();
		
		jfcOpen.setCurrentDirectory(new File(System.getProperty("user.home")));
		int povratnaVrednost = jfcOpen.showOpenDialog(frame.getContentPane());
		if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			String nazivFajla = jfcOpen.getSelectedFile().getAbsolutePath();
			try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nazivFajla)))){
				logika = (Logika) in.readObject();//mora posebno?
				//popuni sve tabele itd
				popuniTabeluSnage();
				popuniTabeluPretnje();
				popuniTabeluSanse();
				popuniTabeluSlabosti();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
	}
	/**
	 * Proverava da li je korisnik siguran da zeli da izadje iz aplikacije, ukoliko jeste,
	 * aplikacija prestaje sa radom.
	 */
	public static void ugasiAplikaciju() {
		int ugasi = JOptionPane.showConfirmDialog(frame.getContentPane(), "Da li zelite da ugasite program?", "Ugasi", JOptionPane.YES_NO_OPTION);
		
		if(ugasi == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	/**
	 * Poziva konstruktor klase Strategija i vraca objekat iste klase.
	 * @param naziv - konstruktor unosi naziv preko grafickog korisnickog interfejsa
	 * @return
	 */
	public static Strategija kreirajStrategiju(String naziv) {
		return new Strategija(naziv);
	}
	/**
	 * Poziva metodu za dodavanje strategije u listu 
	 * @param strategija 
	 */
	public static void dodajStrategiju(Strategija strategija) {
		logika.dodajStrategijuUListu(strategija);
	}
	/**
	 * Poziva metodu za dodavanje snage u listu kao i metodu za naknadno popunavanje tabele snaga
	 * @param naziv
	 * @param ponder
	 */
	public static void dodajSnagu(String naziv, double ponder) {
		logika.dodajSnaguUListu(naziv, ponder);
		popuniTabeluSnage();
	}
	/**
	 * Poziva metodu za dodavanje slabosti u listu kao i metodu za naknadno popunavanje tabele slabosti
	 * @param naziv
	 * @param ponder
	 */
	public static void dodajSlabost(String naziv, double ponder) {
		logika.dodajSlabostUListu(naziv, ponder);
		popuniTabeluSlabosti();
	}
	/**
	 * Poziva metodu za dodavanje sanse u listu kao i metodu za naknadno popunavanje tabele sansi
	 * @param naziv
	 * @param ponder
	 */
	public static void dodajSansu(String naziv, double ponder) {
		logika.dodajSansuUListu(naziv, ponder);
		popuniTabeluSanse();
	}
	/**
	 * Poziva metodu za dodavanje pretnje u listu kao i metodu za naknadno popunavanje tabele pretnji
	 * @param naziv
	 * @param ponder
	 */
	public static void dodajPretnju(String naziv, double ponder) {
		logika.dodajPretnjuUListu(naziv, ponder);
		popuniTabeluPretnje();
	}
	/**
	 * Poziva se svaki put kada se doda nova snaga. Prosledjuje se lista snaga koje ce biti prikazane u tabeli
	 * 
	 */
	public static void popuniTabeluSnage() {
		frame.srediTabeluSnage(logika.getListaSnage());
		
	}
	/**
	 * Poziva se svaki put kada se doda nova slabost. Prosledjuje se lista slabosti koje ce biti prikazane u tabeli
	 */
	public static void popuniTabeluSlabosti() {
		frame.srediTabeluSlabosti(logika.getListaSlabosti());
	}
	/**
	 * Poziva se svaki put kada se doda nova sansa. Prosledjuje se lista sansi koje ce biti prikazane u tabeli
	 */
	public static void popuniTabeluSanse() {
		frame.srediTabeluSanse(logika.getListaSanse());
	}
	/**
	 * Poziva se svaki put kada se doda nova pretnja. Prosledjuje se lista pretnji koje ce biti prikazane u tabeli
	 */
	public static void popuniTabeluPretnje() {
		frame.srediTabeluPretnje(logika.getListaPretnje());
	}
	/**
	 * Prosledjuje listu strategija iz logike u grafiku gde ce biti prikazane.
	 * @return ArrayList
	 */
	public static ArrayList<Strategija> getListaStrategija(){
		return logika.getStrategije();
	}
	/**
	 * Prosledjuje listu snaga iz logike u grafiku gde ce biti prikazane.
	 * @return ArrayList
	 */
	public static ArrayList<Swot> getListaSnage() {
		// TODO Auto-generated method stub
		return logika.getListaSnage();
	}
	/**
	 * Prosledjuje listu slabosti iz logike u grafiku gde ce biti prikazane.
	 * @return ArrayList
	 */
	public static ArrayList<Swot> getListaSlabosti() {
		// TODO Auto-generated method stub
		return logika.getListaSlabosti();
	}
	/**
	 * Prosledjuje listu sansi iz logike u grafiku gde ce biti prikazane.
	 * @return ArrayList
	 */
	public static ArrayList<Swot> getListaSanse() {
		// TODO Auto-generated method stub
		return logika.getListaSanse();
	}
	/**
	 * Prosledjuje listu pretnji iz logike u grafiku gde ce biti prikazane.
	 * @return ArrayList
	 */
	public static ArrayList<Swot> getListaPretnje() {
		// TODO Auto-generated method stub
		return logika.getListaPretnje();
	}
	/**
	 * Prosledjuje ponder iz logike u grafiku gde ce se koristiti za racunanje ukupne atraktivnosti.
	 * @return double ponder
	 */
	public static double getPonderSnaga(String naziv) {
		// TODO Auto-generated method stub
		return logika.vratiPonderSnagaNaziv(naziv);
	}
	/**
	 * Prosledjuje ponder iz logike u grafiku gde ce se koristiti za racunanje ukupne atraktivnosti.
	 * @return double ponder
	 */
	public static double getPonderSlabost(String naziv){
		return logika.vratiPonderSlabostNaziv(naziv);
	}
	/**
	 * Prosledjuje ponder iz logike u grafiku gde ce se koristiti za racunanje ukupne atraktivnosti.
	 * @return double ponder
	 */
	public static double getPonderSansa(String naziv){
		return logika.vratiPonderSansaNaziv(naziv);
	}
	/**
	 * Prosledjuje ponder iz logike u grafiku gde ce se koristiti za racunanje ukupne atraktivnosti.
	 * @return double ponder
	 */
	public static double getPonderPretnja(String naziv){
		return logika.vratiPonderPretnjaNaziv(naziv);
	}
	/**
	 * Kreira prozor za unosenje snaga, slabosti, sansi i pretnji.
	 */
	public static void napraviProzorNoviSwot() {
		ProzorNoviSwot prozorNoviSwot = new ProzorNoviSwot();
		prozorNoviSwot.setVisible(true);
		prozorNoviSwot.setLocationRelativeTo(null);
	}
//	public static void noviProjekat() {
//		isprazniTabele();
//		isprazniListe();
//	}
//
//	private static void isprazniListe() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private static void isprazniTabele() {
//		// TODO Auto-generated method stub
//		
//
//	}
	/**
	 * Kreira i prikazuje prozor za prikaz i poredjenje strategija.
	 */
	public static void napraviProzorUporediStrategije(){
		GUIUporediStrategije prozorZaStrategije = new GUIUporediStrategije();
		prozorZaStrategije.setVisible(true);
		prozorZaStrategije.setLocationRelativeTo(null);
	}
	/**
	 * Kreira prozor za prikaz podataka o autorima.
	 */
	public static void prikaziPodatkeOAutorima() {

		JOptionPane.showMessageDialog(frame, "Autori:\nAndrija Djordjevic\nPetar Karuovic\nMiljan Jovic\n\nFON 2016");
		
	}
	
	
//	public static void sortirajStrategijePoAtraktivnosti(){
//		ArrayList<Strategija> sortirana = logika.getStrategije();
//		
//		for(int i=0; i<sortirana.size(); i++){
//			for(int j=i+1; j<sortirana.size(); j++){
//				if(sortirana.get(i).getSumaUkupnihAtraktivnosti() < sortirana.get(j).getSumaUkupnihAtraktivnosti()){
//					Strategija s = sortirana.get(i);
//					sortirana.set(i, sortirana.get(j));
//					sortirana.set(j, s);
//				}
//			}
//		}
//		logika.setStrategije(sortirana);
//	}
	/**
	 * Poziva se klikom na dugme New. Pravi nove objekte klasa Logika i GlavniProzor sa praznim listama.
	 */
	public static void refresuj(){
		frame.dispose();
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
}
