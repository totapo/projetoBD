package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;

public class DisciplinaDAO {
	private Connection c;
	
	public DisciplinaDAO(){
		this.c = Conn.instanceOf();
		
	}
	
	public ArrayList<Disciplina> selectAll(){
		ArrayList<Disciplina> resp = new ArrayList<Disciplina>();
		ResultSet res;
		String sql = "select * from Disciplina";
		Disciplina b;
		try {
			PreparedStatement t = c.prepareStatement(sql);
			res = t.executeQuery();
			while(res.next()){
				b = new Disciplina(
						res.getString("sigla_disciplina"),
						res.getString("ementa"),
						res.getString("nome"),
						res.getLong("id_disciplina"),
						res.getInt("credito_trabalho"),
						res.getInt("credito_aula"),
						res.getInt("periodo_ideal")
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
	
	public int updateDisciplina(Disciplina novo){
		int resp=0;
		
		PreparedStatement t;
		try {
			String sql = "update disciplina set "
					+ "nome = '"+novo.getNome()+"',"
					+ "sigla_disciplina = '"+novo.getSigla()+"',"
					+ "ementa = '"+novo.getEmenta()+"',"
					+ "credito_trabalho = "+novo.getCreditoTrab()+","
					+ "credito_aula = "+novo.getCreditoAula()+","
					+ "periodo_ideal = "+novo.getPeriodoIdeal()+","
					+ " where id_disciplina = "+novo.getId();
			
			t = c.prepareStatement(sql);
			resp = t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
		
	}
	
	public int insertDisciplina(Disciplina p){
		int resp=0;
		try {
			
			String sql="insert into disciplina values ("
					+p.getId()+","+p.getPeriodoIdeal()+","+p.getCreditoAula()+","+p.getId()+",'"+p.getSigla()+"',"+
					p.getEmenta()+"','"+p.getNome()+"');";
			
			PreparedStatement t = c.prepareStatement(sql);
			resp = t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
}
