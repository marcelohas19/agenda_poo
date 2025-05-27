package view;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

public class Janela {
    public static void main(String[] args) throws Exception {

        //cria a janela principal
        JFrame janela = new JFrame("Minha Janela");
        janela.setSize(800, 600);
        janela.setLocation(330, 100);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        //cria o painel da imagem
        JPanel painelImagem = new JPanel();

        //redimensiona a imagem
        int larguraImg = janela.getWidth(); //retorna a largura da janela
        int alturaImg = 250;
        ImageIcon icon = new ImageIcon(Janela.class.getResource("/imagens/logo.png"));
        Image imgOriginal = icon.getImage();
        Image imgRedimensionada =  imgOriginal.getScaledInstance(larguraImg, alturaImg, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionada = new ImageIcon(imgRedimensionada);

        //adiciona a imagem ao painel
        JLabel imagem = new JLabel(iconRedimensionada);
        painelImagem.add(imagem);
        
        // cria o painel principal da janela
        JPanel painelProgrma = new JPanel(new FlowLayout());

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        //campo código
        gbc.gridx = 0;
        gbc.gridy = 0;
        formulario.add(new JLabel("Código"), gbc);

        gbc.gridx = 1;
        JTextField campoCodigo = new JTextField(15);
        formulario.add(campoCodigo, gbc); 

        //campo nome
        gbc.gridx = 0;
        gbc.gridy = 1;
        formulario.add(new JLabel("Nome"), gbc);

        gbc.gridx = 1;
        JTextField campoNome = new JTextField(15);
        formulario.add(campoNome, gbc);

        //campo endereço
        gbc.gridx = 0;
        gbc.gridy = 2;
        formulario.add(new JLabel("Endereço"), gbc);

        gbc.gridx = 1;
        JTextField campoEndereco = new JTextField(15);
        formulario.add(campoEndereco, gbc);

        //campo telefone
        gbc.gridx = 0;
        gbc.gridy = 3;
        formulario.add(new JLabel("Telefone"), gbc);

        gbc.gridx = 1;
        JTextField campoTelefone = new JTextField(15);
        formulario.add(campoTelefone, gbc);


        //campo anotação    
        JPanel anotacao = new JPanel(new GridBagLayout());
        GridBagConstraints gbcAnotacao = new GridBagConstraints();
        gbcAnotacao.insets = new Insets(5, 5, 5, 5);
        gbcAnotacao.gridx = 0;
        gbcAnotacao.gridy = 0;
        gbcAnotacao.anchor = GridBagConstraints.CENTER;

        anotacao.add(new JLabel("ANOTAÇÃO"), gbcAnotacao);

        // Área de texto com rolagem
        gbcAnotacao.gridy = 1;
        gbcAnotacao.fill = GridBagConstraints.BOTH;
        gbcAnotacao.weightx = 1;
        gbcAnotacao.weighty = 1;
        JTextArea campoAnotacao = new JTextArea(7, 18);
        campoAnotacao.setLineWrap(true);
        campoAnotacao.setWrapStyleWord(true);
        JScrollPane scrollAnotacao = new JScrollPane(campoAnotacao);    
        anotacao.add(scrollAnotacao, gbcAnotacao);

        //área dos botões principais
        JPanel painelBotoes =  new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));

        JButton btInserir = new JButton("Inserir");
        JButton btConsultar = new JButton("Consultar");
        JButton btAlterar = new JButton("Alterar");
        JButton btExcluir = new JButton("Excluir");
        JButton btLimpar = new JButton("Limpar");

        painelBotoes.add(btInserir);
        painelBotoes.add(btConsultar);
        painelBotoes.add(btAlterar);
        painelBotoes.add(btExcluir);
        painelBotoes.add(btLimpar);

        // Painel que une formulário e anotação lado a lado
        JPanel painelFormularioAnotacao = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelFormularioAnotacao.add(formulario);
        painelFormularioAnotacao.add(anotacao);

        // Painel dos botões de navegação (abaixo do formulário)
        JPanel painelNavegacao = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        JButton btAnterior = new JButton("Anterior");
        JButton btProximo = new JButton("Próximo");
        JButton btFim = new JButton("Fim NAVEGAÇÃO");
        painelNavegacao.add(btAnterior);
        painelNavegacao.add(btProximo);
        painelNavegacao.add(btFim);
        
        //adiciona o formulario no painel do programa
        painelProgrma.add(formulario);
        painelProgrma.add(anotacao);
        
        
        janela.add(painelImagem, BorderLayout.NORTH);
        janela.add(painelProgrma, BorderLayout.WEST);
        janela.add(painelNavegacao);
        janela.add(painelBotoes, BorderLayout.SOUTH);
        janela.setVisible(true);
    }
}
