import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgendaGUI extends JFrame {
    // Componentes
    private JTextField txtNome, txtEndereco, txtTelefone;
    private JTextArea txtAnotacoes;
    private JButton btnCadastrar, btnConsultar, btnAlterar, btnExcluir, btnLimpar;

    public AgendaGUI() {
        setTitle("Agenda de Contatos");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel painel = new JPanel(new GridLayout(6, 2));

        // Campos
        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painel.add(txtEndereco);

        painel.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        painel.add(txtTelefone);

        painel.add(new JLabel("Anotações:"));
        txtAnotacoes = new JTextArea(3, 20);
        painel.add(new JScrollPane(txtAnotacoes));

        // Botões
        btnCadastrar = new JButton("Cadastrar");
        btnConsultar = new JButton("Consultar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");

        painel.add(btnCadastrar);
        painel.add(btnConsultar);
        painel.add(btnAlterar);
        painel.add(btnExcluir);
        painel.add(btnLimpar);

        add(painel, BorderLayout.CENTER);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> cadastrar());
        btnConsultar.addActionListener(e -> consultar());
        btnAlterar.addActionListener(e -> alterar());
        btnExcluir.addActionListener(e -> excluir());
        btnLimpar.addActionListener(e -> limparCampos());

        setVisible(true);
    }

    // Métodos de ação
    private void cadastrar() {
        // Lógica para cadastrar contato
        JOptionPane.showMessageDialog(this, "Contato cadastrado com sucesso!");
    }

    private void consultar() {
        // Lógica para consultar contato
        JOptionPane.showMessageDialog(this, "Consulta realizada!");
    }

    private void alterar() {
        // Lógica para alterar contato
        JOptionPane.showMessageDialog(this, "Contato alterado!");
    }

    private void excluir() {
        // Lógica para excluir contato
        JOptionPane.showMessageDialog(this, "Contato excluído!");
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtAnotacoes.setText("");
    }

    public static void main(String[] args) {
        new AgendaGUI();
    }
}
