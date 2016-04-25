package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontrola.Kontroler;
import logika.Logika;
import logika.Strategija;
import logika.Swot;
import logika.SwotStrat;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIStrategija extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox comboSnage;
	private JComboBox comboAtraktivnostSnage;
	private JComboBox comboSlabosti;
	private JComboBox comboAtraktivnostSlabosti;
	private JComboBox comboSanse;
	private JComboBox comboAtraktivnostSanse;
	private JComboBox comboPretnje;
	private JComboBox comboAtraktivnostPretnje;
	private JPanel panel_1;
	private JLabel lblNazivStrategije;
	private JTextField textNazivStrategije;
	private JButton btnDodajPretnju;
	private JButton btnDodaj;
	private JButton btnDodajSnagu;
	private JButton btnDodajSlabost;
	private JButton btnDodajSansu;
	private JPanel panel_2;
	private JButton buttonSacuvaj;
	private JButton buttonOtkazi;
	private Strategija novaStrategija;

	/**
	 * Create the frame.
	 */
	public GUIStrategija() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getComboSnage());
			panel.add(getComboAtraktivnostSnage());
			panel.add(getBtnDodajSnagu());
			panel.add(getComboSlabosti());
			panel.add(getComboAtraktivnostSlabosti());
			panel.add(getBtnDodajSlabost());
			panel.add(getComboSanse());
			panel.add(getComboAtraktivnostSanse());
			panel.add(getBtnDodajSansu());
			panel.add(getComboPretnje());
			panel.add(getComboAtraktivnostPretnje());
			panel.add(getBtnDodajPretnju());

		}
		return panel;
	}

	private JComboBox getComboSnage() {
		if (comboSnage == null) {
			comboSnage = new JComboBox();
			comboSnage.setPreferredSize(new Dimension(300, 40));
			for (int i = 0; i < Kontroler.getListaSnage().size(); i++) {
				comboSnage.addItem(Kontroler.getListaSnage().get(i).getNaziv());
			}
		}
		return comboSnage;
	}

	private JComboBox getComboAtraktivnostSnage() {
		if (comboAtraktivnostSnage == null) {
			comboAtraktivnostSnage = new JComboBox();
			comboAtraktivnostSnage.setPreferredSize(new Dimension(40, 22));
			comboAtraktivnostSnage.addItem("0");
			comboAtraktivnostSnage.addItem("1");
			comboAtraktivnostSnage.addItem("2");
			comboAtraktivnostSnage.addItem("3");
			comboAtraktivnostSnage.addItem("4");
		}
		return comboAtraktivnostSnage;
	}

	private JComboBox getComboSlabosti() {
		if (comboSlabosti == null) {
			comboSlabosti = new JComboBox();
			comboSlabosti.setPreferredSize(new Dimension(300, 40));
			for (int i = 0; i < Kontroler.getListaSlabosti().size(); i++) {
				comboSlabosti.addItem(Kontroler.getListaSlabosti().get(i).getNaziv());
			}
		}
		return comboSlabosti;
	}

	private JComboBox getComboAtraktivnostSlabosti() {
		if (comboAtraktivnostSlabosti == null) {
			comboAtraktivnostSlabosti = new JComboBox();
			comboAtraktivnostSlabosti.setPreferredSize(new Dimension(40, 22));
			comboAtraktivnostSlabosti.addItem("0");
			comboAtraktivnostSlabosti.addItem("1");
			comboAtraktivnostSlabosti.addItem("2");
			comboAtraktivnostSlabosti.addItem("3");
			comboAtraktivnostSlabosti.addItem("4");
		}
		return comboAtraktivnostSlabosti;
	}

	private JComboBox getComboSanse() {
		if (comboSanse == null) {
			comboSanse = new JComboBox();
			comboSanse.setPreferredSize(new Dimension(300, 40));
			for (int i = 0; i < Kontroler.getListaSanse().size(); i++) {
				comboSanse.addItem(Kontroler.getListaSanse().get(i).getNaziv());
			}
		}
		return comboSanse;
	}

	private JComboBox getComboAtraktivnostSanse() {
		if (comboAtraktivnostSanse == null) {
			comboAtraktivnostSanse = new JComboBox();
			comboAtraktivnostSanse.setPreferredSize(new Dimension(40, 22));
			comboAtraktivnostSanse.addItem("0");
			comboAtraktivnostSanse.addItem("1");
			comboAtraktivnostSanse.addItem("2");
			comboAtraktivnostSanse.addItem("3");
			comboAtraktivnostSanse.addItem("4");

		}
		return comboAtraktivnostSanse;
	}

	private JComboBox getComboPretnje() {
		if (comboPretnje == null) {
			comboPretnje = new JComboBox();
			comboPretnje.setPreferredSize(new Dimension(300, 40));
			for (int i = 0; i < Kontroler.getListaPretnje().size(); i++) {
				comboPretnje.addItem(Kontroler.getListaPretnje().get(i).getNaziv());
			}
		}
		return comboPretnje;
	}

	private JComboBox getComboAtraktivnostPretnje() {
		if (comboAtraktivnostPretnje == null) {
			comboAtraktivnostPretnje = new JComboBox();
			comboAtraktivnostPretnje.setPreferredSize(new Dimension(40, 22));
			comboAtraktivnostPretnje.addItem("0");
			comboAtraktivnostPretnje.addItem("1");
			comboAtraktivnostPretnje.addItem("2");
			comboAtraktivnostPretnje.addItem("3");
			comboAtraktivnostPretnje.addItem("4");
		}
		return comboAtraktivnostPretnje;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblNazivStrategije());
			panel_1.add(getTextNazivStrategije());
			panel_1.add(getBtnDodaj());
		}
		return panel_1;
	}

	private JLabel getLblNazivStrategije() {
		if (lblNazivStrategije == null) {
			lblNazivStrategije = new JLabel("Unesi naziv strategije:");
		}
		return lblNazivStrategije;
	}

	private JTextField getTextNazivStrategije() {
		if (textNazivStrategije == null) {
			textNazivStrategije = new JTextField();
			textNazivStrategije.setPreferredSize(new Dimension(300, 20));
			textNazivStrategije.setColumns(10);
		}
		return textNazivStrategije;
	}

	private JButton getBtnDodajPretnju() {
		if (btnDodajPretnju == null) {
			btnDodajPretnju = new JButton("Dodaj pretnju");
			btnDodajPretnju.setPreferredSize(new Dimension(98, 23));
		}
		return btnDodajPretnju;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					novaStrategija = new Strategija(textNazivStrategije.getText());
					if (!Kontroler.getListaStrategija().contains(novaStrategija)) {
						comboSnage.setVisible(true);
						comboAtraktivnostSnage.setVisible(true);
						comboSlabosti.setVisible(true);
						comboAtraktivnostSlabosti.setVisible(true);
						comboSanse.setVisible(true);
						comboAtraktivnostSanse.setVisible(true);
						comboPretnje.setVisible(true);
						comboAtraktivnostPretnje.setVisible(true);
						btnDodajPretnju.setVisible(true);
						btnDodaj.setVisible(true);
						btnDodajSnagu.setVisible(true);
						btnDodajSlabost.setVisible(true);
						btnDodajSansu.setVisible(true);
						buttonSacuvaj.setVisible(true);
					}else{
						//new message dialog i ponovni unos naziva strategije
					}
				}
			});
		}
		return btnDodaj;
	}

	private JButton getBtnDodajSnagu() {
		if (btnDodajSnagu == null) {
			btnDodajSnagu = new JButton("Dodaj snagu");
			btnDodajSnagu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String naziv = (String) comboSnage.getSelectedItem();
					double ponder = Kontroler.getPonder(naziv);
					int atraktivnost = Integer.parseInt((String) comboAtraktivnostSnage.getSelectedItem());
					SwotStrat pomocna = new SwotStrat(naziv, ponder, atraktivnost);
				}
			});
			btnDodajSnagu.setPreferredSize(new Dimension(98, 23));
		}
		return btnDodajSnagu;
	}

	private JButton getBtnDodajSlabost() {
		if (btnDodajSlabost == null) {
			btnDodajSlabost = new JButton("Dodaj slabost");
			btnDodajSlabost.setPreferredSize(new Dimension(98, 23));
			btnDodajSlabost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnDodajSlabost;
	}

	private JButton getBtnDodajSansu() {
		if (btnDodajSansu == null) {
			btnDodajSansu = new JButton("Dodaj sansu");
			btnDodajSansu.setPreferredSize(new Dimension(98, 23));
		}
		return btnDodajSansu;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getButtonSacuvaj());
			panel_2.add(getButtonOtkazi());
		}
		return panel_2;
	}

	private JButton getButtonSacuvaj() {
		if (buttonSacuvaj == null) {
			buttonSacuvaj = new JButton("Sacuvaj");
			buttonSacuvaj.setPreferredSize(new Dimension(100, 25));
		}
		return buttonSacuvaj;
	}

	private JButton getButtonOtkazi() {
		if (buttonOtkazi == null) {
			buttonOtkazi = new JButton("Otkazi");
		}
		return buttonOtkazi;
	}
}
