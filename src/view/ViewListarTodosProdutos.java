package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewListarTodosProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ViewListarTodosProdutos(){
		super("Lista de Produtos cadastrados");
		setBounds(750, 400, 400, 200);
		
		JTable produtoJTable = new JTable(new ModeloDaTabela());
		if(produtoJTable.getRowCount() > 0){
			JScrollPane jScrollPane = new JScrollPane(produtoJTable, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(jScrollPane);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "A lista está vazia!");
			dispose();
		}
	}
}
