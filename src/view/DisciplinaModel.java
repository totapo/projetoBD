package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Disciplina;

public class DisciplinaModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Disciplina> disciplinas,exibicao;
	private String[] columnNames;
	public DisciplinaModel(ArrayList<Disciplina> lista){
		columnNames = new String[]{"Id","Sigla","Nome","Ementa","Créditos Aula", "Creditos Trabalho","Período Ideal"};
		disciplinas = lista;
		exibicao = new ArrayList<Disciplina>();//(disciplinas);
	}
	
	public void update(){
		exibicao.clear();
		exibicao.addAll(disciplinas);
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
		case 0:return exibicao.get(rowIndex).getId();
		case 1:return exibicao.get(rowIndex).getSigla();
		case 2:return exibicao.get(rowIndex).getNome();
		case 3:return exibicao.get(rowIndex).getEmenta();
		case 4:return exibicao.get(rowIndex).getCreditoAula();
		case 5:return exibicao.get(rowIndex).getCreditoTrab();
		case 6:return exibicao.get(rowIndex).getPeriodoIdeal();
		default: return null;
		}
	}

}
