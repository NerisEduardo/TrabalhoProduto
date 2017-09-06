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
import javax.swing.JTextField;

import dao.Dao;
import model.Produto;

public class ViewInserir extends JFrame{
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
	boolean teste = true;

	public ViewInserir() {
		super("Insere novo produto");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,500);
		
		setLayout(new BorderLayout());
		add(botaoInserir(), BorderLayout.CENTER);
		add(campos(), BorderLayout.NORTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
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
	
	private JPanel botaoInserir(){
		JPanel jpanel = new JPanel();
		
		JButton salvarJButton = new JButton("Inserir");
		salvarJButton.setBackground(Color.black);
		salvarJButton.setForeground(Color.white);
		salvarJButton.addActionListener(new ActionListener() {
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
					dao.inserir(produto);
					JOptionPane.showMessageDialog(null, "Produto inserido!");
					setVisible(false);
				}
			}
		});
		jpanel.add(salvarJButton);
		
		return jpanel;
	}
}
