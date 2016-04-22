package kontrola;

import java.awt.EventQueue;

import gui.GlavniProzor;
import logika.Logika;

public class Kontroler {
	private static GlavniProzor frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GlavniProzor();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
