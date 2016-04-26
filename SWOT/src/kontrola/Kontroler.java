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
			// try {
			// BufferedReader br = new BufferedReader(new FileReader(fajl));
			// } catch (FileNotFoundException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			JOptionPane.showMessageDialog(frame.getContentPane(), "Uspesno ste sacuvali fajl!", "Poruka",
					JOptionPane.PLAIN_MESSAGE);
		}
		
	}
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
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
		logika.dodajStrategijuUListu(strategija);
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
	
	public static void napraviProzorUporediStrategije(){
		GUIUporediStrategije prozorZaStrategije = new GUIUporediStrategije();
		prozorZaStrategije.setVisible(true);
		prozorZaStrategije.setLocationRelativeTo(null);
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
