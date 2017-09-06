package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewProduto extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ViewProduto() {
		super("Sistema de Cadastro de Produtos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		
		setLayout(new BorderLayout());
		add(botoes(), BorderLayout.NORTH);
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	private Component botoes() {
		JPanel jpanel = new JPanel();
		
		JButton insere = new JButton("Inserir");
		insere.setBackground(Color.black);
		insere.setForeground(Color.white);
		insere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewInserir();
			}
		});
		
		JButton listar = new JButton("Listar");
		listar.setBackground(Color.black);
		listar.setForeground(Color.white);
		listar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewListarTodosProdutos();
			}
		});
		
		JButton exclui = new JButton("Excluir");
		exclui.setBackground(Color.black);
		exclui.setForeground(Color.white);
		exclui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewExcluir();
			}
		});
		
		JButton alterar = new JButton("Alterar");
		alterar.setBackground(Color.black);
		alterar.setForeground(Color.white);
		alterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAlterar();
			}
		});
		
		JButton sair = new JButton ("Sair");
		sair.setBackground(Color.BLACK);
		sair.setForeground(Color.WHITE);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Obrigado!");
				System.exit(0);
			}
		});
		
		JButton pesquisar = new JButton ("Pesquisar");
		pesquisar.setBackground(Color.BLACK);
		pesquisar.setForeground(Color.WHITE);
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewPesquisar();
			}
		});
		
		
		jpanel.add(insere);
		jpanel.add(pesquisar);
		jpanel.add(listar);
		jpanel.add(alterar);
		jpanel.add(exclui);
		jpanel.add(sair);
		
		return jpanel;
	}
}
