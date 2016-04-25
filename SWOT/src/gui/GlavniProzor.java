package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontrola.Kontroler;
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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnDodaj;
	private JMenuItem mntmExit;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JButton btnSwot;


	public GlavniProzor() {

		setTitle("SWOT");

		setPreferredSize(new Dimension(800, 600));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
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
			mnFile.add(getMntmExit());
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
			mntmOpen.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		}
		return mntmSave;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(2, 2, 8, 8));
			panel.add(getScrollPane());
			panel.add(getScrollPane_1());
			panel.add(getScrollPane_2());
			panel.add(getScrollPane_3());
		}
		return panel;
	}
	private JTable getSnage() {
		if (Snage == null) {
			Snage = new JTable();
			Snage.setModel(new ModelTabele(Kontroler.getListaSnage()));
			Snage.setShowGrid(true);
			Snage.setShowVerticalLines(true);
			Snage.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			Snage.getColumnModel().getColumn(1).setPreferredWidth(10);
		}
		return Snage;
	}
	private JTable getSlabosti() {
		if (Slabosti == null) {
			Slabosti = new JTable();
			Slabosti.setModel(new ModelTabele(Kontroler.getListaSlabosti()));
			Slabosti.setShowGrid(true);
			Slabosti.setShowVerticalLines(true);
			Slabosti.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			Slabosti.getColumnModel().getColumn(1).setPreferredWidth(10);
		}
		return Slabosti;
	}
	private JTable getSanse() {
		if (Sanse == null) {
			Sanse = new JTable();
			Sanse.setModel(new ModelTabele(Kontroler.getListaSanse()));
			Sanse.setShowGrid(true);
			Sanse.setShowVerticalLines(true);
			Sanse.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			Sanse.getColumnModel().getColumn(1).setPreferredWidth(10);
		}
		return Sanse;
	}
	private JTable getPretnje() {
		if (Pretnje == null) {
			Pretnje = new JTable();
			Pretnje.setModel(new ModelTabele(Kontroler.getListaPretnje()));
			Pretnje.setShowGrid(true);
			Pretnje.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			Pretnje.getColumnModel().getColumn(1).setPreferredWidth(10);
		}
		return Pretnje;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
			mntmNew.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		}
		return mntmNew;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(140, 10));
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnSwot());
			panel_1.add(getBtnKreirajStrategiju());
			panel_1.add(getBtnUporediStrategije());
			//panel_1.add(getBtnDodaj());
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
			btnKreirajStrategiju.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIStrategija prozorNovaStrategija = new GUIStrategija();
					prozorNovaStrategija.setVisible(true);
				}
			});
			btnKreirajStrategiju.setPreferredSize(new Dimension(130, 23));
		}
		return btnKreirajStrategiju;
	}

	
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setPreferredSize(new Dimension(130, 23));
		}
		return btnDodaj;
	}
	private JButton getBtnSwot() {
		if (btnSwot == null) {
			btnSwot = new JButton("SWOT");
			btnSwot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Kontroler.napraviProzorNoviSwot();
				}
			});
			btnSwot.setPreferredSize(new Dimension(130, 20));
		}
		return btnSwot;

	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Kontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setIcon(new ImageIcon(GlavniProzor.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		}
		return mntmExit;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getSnage());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getSlabosti());
		}
		return scrollPane_1;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getSanse());
		}
		return scrollPane_2;
	}
	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setViewportView(getPretnje());
		}
		return scrollPane_3;
	}

	public void srediTabeluSnage(ArrayList<Swot> listaSnage) {
		ModelTabele mt = (ModelTabele)Snage.getModel();
		mt.osveziTabelu(listaSnage);
	}

	public void srediTabeluSlabosti(ArrayList<Swot> listaSlabosti) {
		ModelTabele mt = (ModelTabele)Slabosti.getModel();
		mt.osveziTabelu(listaSlabosti);
	}
	
	public void srediTabeluSanse(ArrayList<Swot> listaSanse) {
		ModelTabele mt = (ModelTabele)Sanse.getModel();
		mt.osveziTabelu(listaSanse);
	}
	
	public void srediTabeluPretnje(ArrayList<Swot> listaPretnje) {
		ModelTabele mt = (ModelTabele)Pretnje.getModel();
		mt.osveziTabelu(listaPretnje);
	}
}
