package kontrola;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import gui.GUIDodajSWOT;
import gui.GlavniProzor;
import logika.Logika;

public class Kontroler {
	private static GlavniProzor prozor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prozor = new GlavniProzor();
					prozor.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int ugasi = JOptionPane.showConfirmDialog(prozor.getContentPane(), "Da li zelite da ugasite program?", "Ugasi", JOptionPane.YES_NO_OPTION);
		
		if(ugasi == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
}
