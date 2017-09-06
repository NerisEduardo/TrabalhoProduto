package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;
import conexao.Conexao;

public class Dao {
	
	private final String SQL_INSERE_PRODUTO = "INSERT INTO PRODUTOS(NOME,DESCRICAO,CODIGO,DURACAO) VALUES (?,?,?,?)";
	private final String SQL_ALTERA_PRODUTO = "UPDATE PRODUTOS SET NOME=?, DESCRICAO=?, CODIGO=?, DURACAO=? WHERE ID=?";
	private final String SQL_EXCLUI_PRODUTO = "DELETE FROM PRODUTOS WHERE ID=?";
	private final String SQL_SELECIONA_PRODUTO = "SELECT * FROM PRODUTOS";
	
	private static PreparedStatement preparedStatement = null;
	
	public boolean inserir(Produto produto){
		boolean ret = false;
		Connection con = new Conexao().getConexao();
		try{
			preparedStatement = con.prepareStatement(SQL_INSERE_PRODUTO);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setInt(3, produto.getCodigo());
			preparedStatement.setFloat(4, produto.getDuracao());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ret;
	}
	
	public ArrayList<Produto> listar() {  
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();
		Connection con = new Conexao().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement(SQL_SELECIONA_PRODUTO);
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Produto produto = new Produto();  
	        	produto.setId(resultSet.getInt("ID"));
	        	produto.setNome(resultSet.getString("NOME"));  
	        	produto.setDescricao(resultSet.getString("DESCRICAO"));  
	        	produto.setCodigo(resultSet.getInt("CODIGO"));
	        	produto.setDuracao(resultSet.getFloat("DURACAO"));  
	            listaDeProdutos.add(produto);  
	        }		        
	    	}catch (SQLException e) {  
	    	  e.printStackTrace();
	    	}  
	  
	    return listaDeProdutos;
	} 
	
	public boolean alterar(Produto produto){
		boolean ret = false;
		Connection con = new Conexao().getConexao();
		try{
			preparedStatement = con.prepareStatement(SQL_ALTERA_PRODUTO);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setInt(3, produto.getCodigo());
			preparedStatement.setFloat(4, produto.getDuracao());
			preparedStatement.setInt(5, produto.getId());
			ret = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean excluir(Produto produto){
		boolean ret = false;
		Connection con = new Conexao().getConexao();
		try{
			preparedStatement = con.prepareStatement(SQL_EXCLUI_PRODUTO);
			preparedStatement.setInt(1, produto.getId());
			ret = preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<Produto> buscar(int id) {  
		ArrayList<Produto> buscar = new ArrayList<>();
		Connection con = new Conexao().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM PRODUTOS WHERE id LIKE '"+ id + "%';");
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Produto temp = new Produto();  
	        	temp.setId(resultSet.getInt("ID"));
	            temp.setNome(resultSet.getString("NOME"));  
	            temp.setDescricao(resultSet.getString("DESCRICAO"));  
	            temp.setCodigo(resultSet.getInt("CODIGO"));  
	            temp.setDuracao(resultSet.getFloat("DURACAO"));  
	            buscar.add(temp);  
	        }		        
	    	}catch (SQLException e) {  
	    	  e.printStackTrace();
	    	}  
	  
	    return buscar;
	}

	public ArrayList<Produto> pesquisar(String nome) {
		ArrayList<Produto> buscar = new ArrayList<>();
		Connection con = new Conexao().getConexao();
		
	    try {  
	    	PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM PRODUTOS WHERE nome LIKE '"+ nome + "%';");
		    ResultSet resultSet = preparedStatement.executeQuery();  
	        
		    while (resultSet.next()) {  
		    	Produto temp = new Produto();  
	        	temp.setId(resultSet.getInt("ID"));
	            temp.setNome(resultSet.getString("NOME"));  
	            temp.setDescricao(resultSet.getString("DESCRICAO"));  
	            temp.setCodigo(resultSet.getInt("CODIGO"));  
	            temp.setDuracao(resultSet.getFloat("DURACAO"));  
	            buscar.add(temp);  
	        }		        
	    	}catch (SQLException e) {  
	    	  e.printStackTrace();
	    	}  
	  
	    return buscar;
	}
}
