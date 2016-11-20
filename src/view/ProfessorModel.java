package view;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import model.Professor;

public class ProfessorModel extends AbstractTableModel{
	//table model para descriÃ§Ã£o das linhas de controle do firmware
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Professor> professores,exibicao;
	private String[] columnNames;
	
	public ProfessorModel(ArrayList<Professor> profs){
		columnNames = new String[]{"CPF", "RG","Nome", "Nascimento", "Contratação", "Curso", "Email", "Email prof.", "Status", "Tel","Endereço", "Link Curriculo"};
		professores = profs;
		exibicao = new ArrayList<Professor>();//(professores);
	}
	
	public void update(){
		exibicao.clear();
		exibicao.addAll(professores);
	}
	
	@Override
	public int getRowCount() {
		return exibicao.size();
	}
	
	@Override
	public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(rowIndex>exibicao.size() || rowIndex<0) columnIndex=-1;
		switch(columnIndex){
		case 0:return exibicao.get(rowIndex).getCpf();
		case 1:return exibicao.get(rowIndex).getRg();
		case 2:return exibicao.get(rowIndex).getNome();
		case 3:
			Date d = exibicao.get(rowIndex).getDt_nascimento();
			return d.getDate()+"/"+d.getMonth()+"/"+ d.getYear();
		case 4:
			d = exibicao.get(rowIndex).getDt_contratacao();
			return d.getDate()+"/"+d.getMonth()+"/"+ d.getYear();
		case 5: return exibicao.get(rowIndex).getCurso();
		case 6:return exibicao.get(rowIndex).getEmail();
		case 7:return exibicao.get(rowIndex).getEmail_prof();
		case 8:return exibicao.get(rowIndex).getEmail_prof();
		case 9:return exibicao.get(rowIndex).getTelefone();
		case 10:return exibicao.get(rowIndex).getEndereco();
		case 11:return exibicao.get(rowIndex).getCurriculo();
		default: return null;
		}
	}
}
