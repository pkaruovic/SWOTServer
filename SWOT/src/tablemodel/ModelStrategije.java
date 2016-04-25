package tablemodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import logika.Strategija;

public class ModelStrategije extends AbstractTableModel{
	private ArrayList<Strategija> podaci;
	private String[] naziv = new String[]{"Strategija", "Atraktivnost"};
	
	public ModelStrategije(ArrayList<Strategija> strategije) {
		if(strategije == null){
			podaci = new ArrayList<Strategija>();
		}else{
			podaci = strategije;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return naziv[column];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return naziv.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return podaci.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		Strategija s = podaci.get(red);
		
		switch(kolona){
		case 0:
			return s.getNaziv();
		case 1:
			return s.getSumaUkupnihAtraktivnosti();
		}
		return null;
	}

}
