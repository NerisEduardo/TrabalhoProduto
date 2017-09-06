package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private Connection cnx = null;
	private String usuario = "SA";
	private String senha = "";
	private String PathBase = "C:\\Users\\Eduardo\\Documents\\Facul\\Trabalhos Java\\Trabalho1811\\base\\trabProva";
	private final String URL = "jdbc:hsqldb:file:" + PathBase + ";shutdown=true;hsqldb.write_delay=false; ";
	
	public Conexao(){
		try {
			Class.forName(DRIVER_CLASS);
			cnx = DriverManager.getConnection(URL, usuario, senha);
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException - ");
			e.printStackTrace();
		}catch (SQLException e) {
			System.err.println("SQLException");
		}
	}
	
	public Connection getConexao(){
		return cnx;
	}
}
