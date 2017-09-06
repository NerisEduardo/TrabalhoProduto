package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.Dao;
import model.Produto;

public class ModeloDaTabela extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] nomesColunas = { "ID", "NOME", "DESCRIÇÃO", "CÓDIGO", "DURAÇÃO"};
	private ArrayList<Produto> listaProdutos;
	
	public ModeloDaTabela() {
		listaProdutos = new Dao().listar();
	}

	public ModeloDaTabela(int id) {
		listaProdutos = new Dao().buscar(id);
	}

	public ModeloDaTabela(String nome) {
		listaProdutos = new Dao().pesquisar(nome);
	}

	@Override
	public int getColumnCount() {
		return nomesColunas.length;
	}
	
	@Override
	public String getColumnName(int col) {
        return nomesColunas[col];
    }

	@Override
	public int getRowCount() {
		return listaProdutos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return listaProdutos.get(linha).getId();
		case 1:
			return listaProdutos.get(linha).getNome();
		case 2:
			return listaProdutos.get(linha).getDescricao();
		case 3:
			return listaProdutos.get(linha).getCodigo();
		case 4:
			return listaProdutos.get(linha).getDuracao();
		default: return "";
		}
	}
}
