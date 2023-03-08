package com.jcg.hibernate.crud.operations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class InterfaceUsuario extends JFrame implements ActionListener {
    private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextField campoEndereco;
    private JButton botaoSalvar;
    private JButton botaoLer;

    public InterfaceUsuario() {
        super("Formulário de Cadastro");

        // Cria os campos de texto para nome, telefone e endereço
        campoNome = new JTextField(20);
        campoTelefone = new JTextField(20);
        campoEndereco = new JTextField(20);
        

        // Cria um botão para salvar os dados
        botaoSalvar = new JButton("Salvar");
        botaoLer = new JButton("Ler");
        botaoLer.addActionListener(this);
        botaoSalvar.addActionListener(this);

        // Cria o painel e adiciona os campos de texto e o botão
        JPanel painel = new JPanel(new GridLayout(4, 2));
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);
        painel.add(new JLabel("Endereço:"));
        painel.add(campoEndereco);
        painel.add(botaoSalvar);
        painel.add(botaoLer);

        // Adiciona o painel à janela principal
        getContentPane().add(painel);

        // Configura a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Ao clicar no botão, atribui os valores dos campos a 3 variáveis
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        String endereco = campoEndereco.getText();
        // Exibe os valores das variáveis no console
        if(e.getSource() == botaoLer){
            List<Contato>viewContatos = DbOperations.displayRecords();
		if(viewContatos != null & viewContatos.size() > 0) {
			for(Contato contatoObj : viewContatos) {
				System.out.print(contatoObj.toString());
			}
		}
        }else if(e.getSource() == botaoSalvar){
            DbOperations.createRecord(nome, telefone, endereco);
        }
    }

    public static void main(String[] args) {
        new InterfaceUsuario();
    }

}