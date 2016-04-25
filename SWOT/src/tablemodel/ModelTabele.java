package tablemodel;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import logika.Swot;

public class ModelTabele extends AbstractTableModel{
	private ArrayList<Swot> podaci;
	private String[] nazivKolone = new String[]{"Naziv", "Ponder"};
	
	public ModelTabele(ArrayList<Swot> lista) {
		if(lista == null){
			lista = new ArrayList<Swot>();
		}else{
			podaci = lista;
		}
	}
	
	@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
	@Override
	public String getColumnName(int column) {
		return nazivKolone[column];
	}
	
	@Override
	public int getColumnCount() {
		return nazivKolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return podaci.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		Swot pom = podaci.get(red);
		
		switch(kolona){
		case 0:
			return pom.getNaziv();
		case 1:
			return pom.getPonder();
		}
		return null;
	}
}
