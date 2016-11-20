package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.ProfessorDisciplina;

public class ProfDiscModel extends AbstractTableModel implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ProfessorDisciplina> relacao, exibicao;
	private String[] columnNames;
	public ProfDiscModel(ArrayList<ProfessorDisciplina> lista){
		columnNames = new String[]{"Id_Disc","Sigla","Nome Professor","CPF"};
		relacao = lista;
		exibicao = new ArrayList<ProfessorDisciplina>();//(relacao);
	}
	
	public void update(){
		exibicao.clear();
		exibicao.addAll(relacao);
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
        return columnNames[col];
    }
	
	@Override
	public int getRowCount() {
		return exibicao.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex>exibicao.size() || rowIndex<0) columnIndex=-1;
		switch(columnIndex){
		case 0:return exibicao.get(rowIndex).getIdDis();
		case 1:return exibicao.get(rowIndex).getSiglaDisc();
		case 2:return exibicao.get(rowIndex).getNomeProf();
		case 3:return exibicao.get(rowIndex).getCpf();
		default: return null;
		}
	}

}
