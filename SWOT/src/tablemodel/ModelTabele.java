package tablemodel;

import java.awt.List;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public class ModelTabele extends AbstractTableModel{
	private LinkedList<Object> podaci;
	private String[] heder = {"Naziv", "Ponder"};
	
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
		return podaci.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		
		switch(kolona){
		case 0:
			return podaci.get(red);
		}
		return null;
	}

}
