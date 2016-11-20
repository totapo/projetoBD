package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProfessorDisciplina;

public class DiscProfDAO {
private Connection c;
	
	public DiscProfDAO(){
		this.c = Conn.instanceOf();
		
	}
	
	public ArrayList<ProfessorDisciplina> selectAll(){
		ArrayList<ProfessorDisciplina> resp = new ArrayList<ProfessorDisciplina>();
		ResultSet res;
		String sql = "select Disc_Prof.CPF, Disc_Prof.id_Disciplina, Pessoa.nome_pessoa, Disciplina.nome from Disc_Prof, Disciplina, Professor, Funcionario, Pessoa where ProfessorDisciplina.CPF = Professor.CPF"
				+ " and Professor.CPF = Funcionario.CPF and Funcionario.CPF=Pessoa.CPF";
		ProfessorDisciplina b;
		try {
			PreparedStatement t = c.prepareStatement(sql);
			res = t.executeQuery();
			while(res.next()){
				b = new ProfessorDisciplina(
						res.getInt("id_disciplina"),
						res.getString("CPF"),
						res.getString("nome_pessoa"),
						res.getString("nome")
						);
				
				resp.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public int deleteDisciplina(String delete){
		int resp=0;
		PreparedStatement t;
		try {
			t = c.prepareStatement(delete);
			resp = t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	public int insertProfessorDisciplina(ProfessorDisciplina p){
		int resp=0;
		try {
			
			String sql="insert into Disc_Prof values ('"
					+p.getCpf()+"',"+p.getIdDis()+");";
			
			PreparedStatement t = c.prepareStatement(sql);
			resp = t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
}
