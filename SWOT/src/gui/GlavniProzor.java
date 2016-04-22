package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.Logika;
import logika.Swot;
import tablemodel.ModelTabele;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JPanel panel;
	private JTable Snage;
	private JTable Slabosti;
	private JTable Sanse;
	private JTable Pretnje;
	private JMenuItem mntmNew;
	private JPanel panel_1;
	private JButton btnUporediStrategije;
	private JButton btnKreirajStrategiju;

	public GlavniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 369);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNew());
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
		}
		return mntmSave;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(2, 2, 8, 8));
			panel.add(getSnage());
			panel.add(getSlabosti());
			panel.add(getSanse());
			panel.add(getPretnje());
		}
		return panel;
	}
	private JTable getSnage() {
		if (Snage == null) {
			Snage = new JTable();
			Snage.setModel(new ModelTabele(Logika.getListaSnage()));
			Snage.setShowGrid(true);
			Snage.setShowVerticalLines(true);
			Snage.setShowHorizontalLines(true);
		}
		return Snage;
	}
	private JTable getSlabosti() {
		if (Slabosti == null) {
			Slabosti = new JTable();
			Slabosti.setModel(new ModelTabele(Logika.getListaSlabosti()));
			Slabosti.setShowGrid(true);
			Slabosti.setShowVerticalLines(true);
			Slabosti.setShowHorizontalLines(true);
		}
		return Slabosti;
	}
	private JTable getSanse() {
		if (Sanse == null) {
			Sanse = new JTable();
			Sanse.setModel(new ModelTabele(Logika.getListaSanse()));
			Sanse.setShowGrid(true);
			Sanse.setShowVerticalLines(true);
			Sanse.setShowHorizontalLines(true);
		}
		return Sanse;
	}
	private JTable getPretnje() {
		if (Pretnje == null) {
			Pretnje = new JTable();
			Pretnje.setModel(new ModelTabele(Logika.getListaPretnje()));
			Pretnje.setShowGrid(true);
			Pretnje.setShowVerticalLines(true);
			Pretnje.setShowHorizontalLines(true);
		}
		return Pretnje;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
		}
		return mntmNew;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(140, 10));
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnKreirajStrategiju());
			panel_1.add(getBtnUporediStrategije());
		}
		return panel_1;
	}
	private JButton getBtnUporediStrategije() {
		if (btnUporediStrategije == null) {
			btnUporediStrategije = new JButton(" Uporedi strategije");
			btnUporediStrategije.setPreferredSize(new Dimension(130, 23));
		}
		return btnUporediStrategije;
	}
	private JButton getBtnKreirajStrategiju() {
		if (btnKreirajStrategiju == null) {
			btnKreirajStrategiju = new JButton(" Kreiraj strategiju");
			btnKreirajStrategiju.setPreferredSize(new Dimension(130, 23));
		}
		return btnKreirajStrategiju;
	}
	
}
