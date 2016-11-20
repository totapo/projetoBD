package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;

public class ProfessorDAO {
	private Connection c;
	
	public ProfessorDAO(){
		this.c = Conn.instanceOf();
		
	}
	
	public ArrayList<Professor> selectAll(){
		ArrayList<Professor> resp = new ArrayList<Professor>();
		ResultSet res;
		String sql = "select * from Professor, Funcionario, Pessoa, Curso where Professor.id_curso=Curso.id_curso and Professor.CPF = Funcionario.CPF and Funcionario.CPF = Pessoa.CPF";
		Professor b;
		try {
			PreparedStatement t = c.prepareStatement(sql);
			res = t.executeQuery();
			while(res.next()){
				
				b = new Professor(
						res.getString("CPF"),
						res.getString("curriculo_lattes"),
						res.getString("RG"),
						res.getString("email_pessoa"),
						res.getString("email_profissional"),
						res.getString("status_funcionario"),
						res.getString("end_cep"),
						res.getString("end_logradouro"),
						res.getString("end_numero"),
						res.getString("end_complemento"),
						res.getString("telefone_fixo_pessoa"),
						res.getString("nome_pessoa"),
						res.getDate("dt_nascimento"),
						res.getDate("dt_contratacao"),
						res.getString("nome_curso"),
						res.getInt("id_curso")
						);
				
				resp.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public int deleteProfessor(String delete){
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
	
	public int updateProfessor(Professor novo){
		int resp=0;
		String sql = "update pessoa set "
				+ "RG = '"+novo.getRg()+"', "
				+ "email_pessoa = '"+novo.getEmail()+"',"
				+ "dt_nascimento = '"+novo.getDt_nascimento()+"',"
				+ "end_cep ='"+novo.getCep()+"'?,"
				+ "end_logradouro = '"+novo.getLogradouro()+"',"
				+ "end_numero = '"+novo.getNumero()+"',"
				+ "end_complemento = '"+novo.getComplemento()+"',"
				+ "telefone_fixo_pessoa = '"+novo.getTelefone()+"',"
				+ "nome_pessoa = '"+novo.getNome()+"'"
				+ " where CPF = '"+novo.getCpf()+"'";
		PreparedStatement t;
		try {
			t = c.prepareStatement(sql);
			resp = t.executeUpdate();
			
			sql = "update funcionario set "
					+ "dt_contratacao = '"+novo.getDt_contratacao()+"',"
					+ "status_funcionario = '"+novo.getStatus()+"',"
					+ "email_profissional = '"+novo.getEmail_prof()+"',"
					+ " where CPF = '"+novo.getCpf()+"'";
			
			t = c.prepareStatement(sql);
			resp = t.executeUpdate();
			
			sql = "update professor set "
					+ "curriculo_lattes = '"+novo.getCurriculo()+"',"
					+ "id_curso = "+novo.getIdCurso()+","
					+ " where CPF = '"+novo.getCpf()+"'";
			
			t = c.prepareStatement(sql);
			resp = t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
		
	}
	
	public int insertProfessor(Professor p){
		int resp=0;
		try {
			String sql1="insert into pessoa values ("
				+"'"+p.getRg()+"','"
				+p.getDt_nascimento().toString()+"',"
				+p.getCep()+",'"
				+p.getLogradouro()+"','"
				+((p.getComplemento()==null)?"":p.getComplemento())+"','"
				+p.getTelefone()+"','"
				+p.getCpf()+"',"
				+p.getNome()+"'"
				+")";
		
			PreparedStatement t = c.prepareStatement(sql1);
			resp = t.executeUpdate();
			
			sql1="insert into funcionario values ("
					+"'"+p.getCpf()+"','"
					+p.getDt_contratacao().toString()+"','"
					+p.getStatus()+",'"
					+p.getEmail_prof()+"');";
			
			t = c.prepareStatement(sql1);
			resp = t.executeUpdate();
			
			sql1="insert into professor values ("
					+"'"+p.getCpf()+"','"
					+p.getCurriculo()+"',"
					+p.getIdCurso()+");";
			
			t = c.prepareStatement(sql1);
			resp = t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
}

