package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.Dao;
import model.Produto;

public class ViewExcluir extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Produto produto = new Produto();
	Dao dao = new Dao();
	int id;
	boolean teste = true;
	
	public ViewExcluir() {
		super("Exclui produto");
		
		try{
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto que deseja excluir:"));
		}catch(Exception e){
			teste = false;
			dispose();
		}
		
		if(teste){
			setBounds(750, 400, 400, 200);
			JTable produtoJTable = new JTable(new ModeloDaTabela(id));
			if(produtoJTable.getRowCount() == 1){
				JScrollPane jScrollPane = new JScrollPane(produtoJTable, 
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				add(jScrollPane);
				setVisible(true);
				
				String message = "Deseja realmente excluir o cadastro?";
				String title = "Temporário";
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				
				if (reply == JOptionPane.YES_OPTION)
				{
					produto.setId(id);
					dao.excluir(produto);
					JOptionPane.showMessageDialog(null, "CADASTRO EXCLUÍDO!");
					dispose();
				}
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "ID não existente!");
				dispose();
			}
		}
	}
}
