package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewPesquisar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewPesquisar(){
		super("Pesquisa de produto");
		String nome = " ";
		boolean teste = true;
		nome = JOptionPane.showInputDialog("Informe o Nome que deseja pesquisar:");
		
		if(nome == null){
			teste = false;
			dispose();
		}
		
		if(teste){
			setBounds(750, 400, 400, 200);
			JTable produtoJTable = new JTable(new ModeloDaTabela(nome));
			JScrollPane jScrollPane = new JScrollPane(produtoJTable, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(jScrollPane);
			setVisible(true);
		}
	}
}
