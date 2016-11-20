package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/Ensino";
	private static final String user = "projetoBD";
	private static final String password = "tijolo22";
	
	private static Connection con;
	static{
		try {
			//Class.forName("org.postgresql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection instanceOf(){
		if(con==null){
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return con;
	}
	
	public static void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con=null;
	}
	
}
