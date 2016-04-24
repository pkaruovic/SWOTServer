package kontrola;

import java.awt.EventQueue;

import gui.GUIDodajSWOT;
import gui.GlavniProzor;
import logika.Logika;

public class Kontroler {
	private static GlavniProzor prozor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					prozor = new GlavniProzor();
//					prozor.setVisible(true);
					GUIDodajSWOT frame = new GUIDodajSWOT();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
