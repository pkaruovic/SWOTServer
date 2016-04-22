package tablemodel;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import logika.Swot;

public class ModelTabele extends AbstractTableModel{
	private ArrayList<Swot> podaci;
	private String[] heder = new String[]{"Naziv", "Ponder"};
	
	public ModelTabele(ArrayList<Swot> lista) {
		podaci = lista;
	}
	
	@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(rowIndex == podaci.size()){
				return true;
			}
		
			return false;
		}
	@Override
	public String getColumnName(int column) {
		return heder[column];
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return podaci.size()+1;
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		if(podaci.size() != 0){
			switch(kolona){
		case 0:
			return podaci.get(red).getNaziv();
		case 1:
			return podaci.get(red).getPonder();
		}
	}
		return null;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}
}
