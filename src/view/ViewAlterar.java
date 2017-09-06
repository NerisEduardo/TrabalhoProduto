package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.Dao;
import model.Produto;

public class ViewAlterar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextField nomeJTextField;
	static JTextField descricaoJTextField;
	static JTextField codigoJTextField;
	static JTextField duracaoJTextField;
	Produto produto = new Produto();
	Dao dao = new Dao();
	int id;
	boolean teste = true;
	
	public ViewAlterar() {
		super("Alterar produto");
		
		try{
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto que deseja alterar:"));
		}catch(Exception e){
			teste = false;
			dispose();
		}
		
		if(teste){
			setLayout(new BorderLayout());
			JTable produtoJTable = new JTable(new ModeloDaTabela(id));
			if(produtoJTable.getRowCount() == 1){
				JScrollPane jScrollPane = new JScrollPane(produtoJTable, 
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				add(jScrollPane, BorderLayout.SOUTH);
				setVisible(true);
				pack();
				
				String message = "Deseja realmente alterar o cadastro?";
				String title = "Temporário";
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				
				if (reply == JOptionPane.YES_OPTION)
				{
					add(botaoAlterar(), BorderLayout.CENTER);
					add(campos(), BorderLayout.NORTH);
					pack();
					setVisible(true);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "ID não existente!");
				dispose();
			}
		}
	}
	
	private JPanel campos(){
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4,2));
		
		jpanel.add(new JLabel("Nome:"));
		nomeJTextField = new JTextField(20);
		jpanel.add(nomeJTextField);
		
		jpanel.add(new JLabel("Descrição:"));
		descricaoJTextField = new JTextField(20);
		jpanel.add(descricaoJTextField);
		
		jpanel.add(new JLabel("Código:"));
		codigoJTextField = new JTextField(20);
		jpanel.add(codigoJTextField);
		
		jpanel.add(new JLabel("Duração:"));
		duracaoJTextField = new JTextField(20);
		jpanel.add(duracaoJTextField);
		
		return jpanel;
	}
	
	private JPanel botaoAlterar(){
		JPanel jpanel = new JPanel();
		
		JButton alterarJButton = new JButton("Alterar");
		alterarJButton.setBackground(Color.black);
		alterarJButton.setForeground(Color.white);
		alterarJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto.setNome(nomeJTextField.getText());
				produto.setDescricao(descricaoJTextField.getText());
				produto.setDuracao(Float.parseFloat(duracaoJTextField.getText()));
				try{	
					produto.setCodigo(Integer.parseInt(codigoJTextField.getText()));
				}catch(Exception e1){
					teste = false;
					JOptionPane.showMessageDialog(null, "Valor inválido!");
					dispose();
				}
				if(teste){
					produto.setId(id);
					dao.alterar(produto);
					JOptionPane.showMessageDialog(null, "Produto Alterado!");
					setVisible(false);
					dispose();
				}
			}
		});
		jpanel.add(alterarJButton);
		
		return jpanel;
	}
}
