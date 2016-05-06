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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

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
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Kreiraj strategiju");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			comboAtraktivnostSnage.setVisible(false);
			panel.add(getBtnDodajSnagu());
			btnDodajSnagu.setVisible(false);
			panel.add(getComboSlabosti());
			comboSlabosti.setVisible(false);
			panel.add(getComboAtraktivnostSlabosti());
			comboAtraktivnostSlabosti.setVisible(false);
			panel.add(getBtnDodajSlabost());
			btnDodajSlabost.setVisible(false);
			panel.add(getComboSanse());
			comboSanse.setVisible(false);
			panel.add(getComboAtraktivnostSanse());
			comboAtraktivnostSanse.setVisible(false);
			panel.add(getBtnDodajSansu());
			btnDodajSansu.setVisible(false);
			panel.add(getComboPretnje());
			comboPretnje.setVisible(false);
			panel.add(getComboAtraktivnostPretnje());
			comboAtraktivnostPretnje.setVisible(false);
			panel.add(getBtnDodajPretnju());
			btnDodajPretnju.setVisible(false);

		}
		return panel;
	}

	private JComboBox getComboSnage() {
		if (comboSnage == null) {
			comboSnage = new JComboBox();
			comboSnage.setName("");
			comboSnage.setVisible(false);
			comboSnage.setToolTipText("");
			comboSnage.setPreferredSize(new Dimension(300, 40));
			comboSnage.addItem("Snage");
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
			comboAtraktivnostSnage.addItem("");
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
			comboSlabosti.addItem("Slabosti");
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
			comboAtraktivnostSlabosti.addItem("");
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
			comboSanse.addItem("Sanse");
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
			comboAtraktivnostSanse.addItem("");
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
			comboPretnje.addItem("Pretnje");
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
			comboAtraktivnostPretnje.addItem("");
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
			btnDodajPretnju.setPreferredSize(new Dimension(115, 23));
			btnDodajPretnju.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String naziv = (String) comboPretnje.getSelectedItem();
					double ponder = Kontroler.getPonderPretnja(naziv);
					String atraktivnostPretnje = (String) comboAtraktivnostPretnje.getSelectedItem();
					if (naziv == null || naziv.equals("Pretnje")) {
						JOptionPane.showMessageDialog(new GUIStrategija(), "Niste odabrali pretnju", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (atraktivnostPretnje.isEmpty()) {
						JOptionPane.showMessageDialog(new GUIStrategija(),
								"Niste odabrali atraktivnost za odredjenu pretnju", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						int atraktivnost = Integer.parseInt((String) comboAtraktivnostPretnje.getSelectedItem());
						SwotStrat pomocna = new SwotStrat(naziv, ponder, atraktivnost);
						novaStrategija.dodajPretnju(pomocna, atraktivnost);
						comboPretnje.setSelectedItem("Pretnje");
						comboAtraktivnostPretnje.setSelectedItem("");
					}
				}
			});
		}
		return btnDodajPretnju;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (textNazivStrategije.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new GUIStrategija(), "Morate uneti naziv strategije", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						novaStrategija = Kontroler.kreirajStrategiju(textNazivStrategije.getText());
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
						} else {
							JOptionPane.showMessageDialog(new GUIStrategija(), "Ova strategija vec postoji", "Greska",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
		}
		return btnDodaj;
	}

	private JButton getBtnDodajSnagu() {
		if (btnDodajSnagu == null) {
			btnDodajSnagu = new JButton("Dodaj snagu");
			btnDodajSnagu.setPreferredSize(new Dimension(115, 23));
			btnDodajSnagu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String naziv = (String) comboSnage.getSelectedItem();
					double ponder = Kontroler.getPonderSnaga(naziv);
					String atraktivnostSnage = (String) comboAtraktivnostSnage.getSelectedItem();
					if (naziv == null || naziv.equals("Snage")) {
						JOptionPane.showMessageDialog(new GUIStrategija(), "Niste odabrali snagu", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (atraktivnostSnage.isEmpty()) {
						JOptionPane.showMessageDialog(new GUIStrategija(),
								"Niste odabrali atraktivnost za odredjenu snagu", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						int atraktivnost = Integer.parseInt((String) comboAtraktivnostSnage.getSelectedItem());
						SwotStrat pomocna = new SwotStrat(naziv, ponder, atraktivnost);
						novaStrategija.dodajSnagu(pomocna, atraktivnost);
						System.out.println(atraktivnost);
						System.out.println(novaStrategija.getSnage().get(0).getUkupnaAtraktivnost());
						comboSnage.setSelectedItem("Snage");
						comboAtraktivnostSnage.setSelectedItem("");
					}
				}
			});
		}
		return btnDodajSnagu;
	}

	private JButton getBtnDodajSlabost() {
		if (btnDodajSlabost == null) {
			btnDodajSlabost = new JButton("Dodaj slabost");
			btnDodajSlabost.setPreferredSize(new Dimension(115, 23));
			btnDodajSlabost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String naziv = (String) comboSlabosti.getSelectedItem();
					double ponder = Kontroler.getPonderSlabost(naziv);
					String atraktivnostSlabosti = (String) comboAtraktivnostSlabosti.getSelectedItem();
					if (naziv == null || naziv.equals("Slabosti")) {
						JOptionPane.showMessageDialog(new GUIStrategija(), "Niste odabrali slabost", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (atraktivnostSlabosti.isEmpty()) {
						JOptionPane.showMessageDialog(new GUIStrategija(),
								"Niste odabrali atraktivnost za odredjenu slabost", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						int atraktivnost = Integer.parseInt((String) comboAtraktivnostSlabosti.getSelectedItem());
						SwotStrat pomocna = new SwotStrat(naziv, ponder, atraktivnost);
						novaStrategija.dodajSlabost(pomocna, atraktivnost);
						comboSlabosti.setSelectedItem("Slabosti");
						comboAtraktivnostSlabosti.setSelectedItem("");
					}
				}
			});
		}
		return btnDodajSlabost;
	}

	private JButton getBtnDodajSansu() {
		if (btnDodajSansu == null) {
			btnDodajSansu = new JButton("Dodaj sansu");
			btnDodajSansu.setPreferredSize(new Dimension(115, 23));
			btnDodajSansu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String naziv = (String) comboSanse.getSelectedItem();
					double ponder = Kontroler.getPonderSansa(naziv);
					String atraktivnostSanse = (String) comboAtraktivnostSanse.getSelectedItem();
					if (naziv == null || naziv.equals("Sanse")) {
						JOptionPane.showMessageDialog(new GUIStrategija(), "Niste odabrali sansu", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (atraktivnostSanse.isEmpty()) {
						JOptionPane.showMessageDialog(new GUIStrategija(),
								"Niste odabrali atraktivnost za odredjenu sansu", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						int atraktivnost = Integer.parseInt((String) comboAtraktivnostSanse.getSelectedItem());
						SwotStrat pomocna = new SwotStrat(naziv, ponder, atraktivnost);
						novaStrategija.dodajSansu(pomocna, atraktivnost);
						comboSanse.setSelectedItem("Sanse");
						comboAtraktivnostSanse.setSelectedItem("");
					}
				}
			});
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
			buttonSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (novaStrategija == null) {
						JOptionPane.showMessageDialog(new GUIStrategija(), "Niste kreirali strategiju", "Greska",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						novaStrategija.izracunajSumuUkupnihAtraktivnosti();
						Kontroler.dodajStrategiju(novaStrategija);
						textNazivStrategije.setText("");
					}
				}
			});
			buttonSacuvaj.setPreferredSize(new Dimension(100, 25));
		}
		return buttonSacuvaj;
	}

	private JButton getButtonOtkazi() {
		if (buttonOtkazi == null) {
			buttonOtkazi = new JButton("Otkazi");
			buttonOtkazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return buttonOtkazi;
	}
}
