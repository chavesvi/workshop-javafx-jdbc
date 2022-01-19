package jdbc.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoUtil {
	
private static Connection conexao;
	
	public static Connection getConnection(String url, String user, String password){
		if (conexao == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection(url,user,password);
			}
			catch (ClassNotFoundException e) {
				throw new DbException(e.getMessage());
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conexao;
	}
	
	public static void closeConnection(){
		if (conexao != null) {
			try {
				conexao.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
				
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
