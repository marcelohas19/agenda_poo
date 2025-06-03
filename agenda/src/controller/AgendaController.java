package controller;

import view.*;
import modell.*;
import modell.AgendaModel.Pessoa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class AgendaController {  //cria a class de controle, e seus atributos.
    private AgendaModel model;
    private AgendaView view;

    public void AgendaController(AgendaModell model, AgendaView view){ //construtor que rece a view e o model
        this.model = model;
        this.view = view;

        this.view.setListMoedel(this.model);

        //cria os metodos dos eventos dos botões
        this.view.nomedafuncaoincerir(new AdicionarPessoaListener());
        this.view.nomedafuncaocinsultar(new ConsultaPessoasListener());
        this.view.nomedafuncaoalterar(new AlterarPessoaListener());
        this.view.nomedafuncaoexcluir(new ExcluirPessoaListener());
        this.view.nomedafuncaolimpar(nw LimpaListener());
    }

    //evento do botão "adicionar"
    class AdicionarPessoaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            String nome = view.getNome();
            String endereco = view.getEndereco();
            String telefone = view.getTelefone();
            String anotacao = view.getAnotacaoa();

            if(nome.trim().isEmpty()){
                view.mostrarMensagem("ERRO DE VALIDAÇÃO: ", "Nome não pode estar vazio.");
            }

            Pessoa novaPessoa = new Pessoa(nome, endereco, telefone, anotacao);
            model.adicionarPessoa(novaPessoa);

            view.limparCampos();
            view.mostrarMensagem("SUCESSO", "Pessoa adicionada com sucesso.");

        }
    }

    //evento do botão consultar
    class ConsultaPessoasListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String codigo;
            String nome = view.getNome;

            
        }
    }

    //evento do botão alterar
    class AlterarPessoaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    public void iniciarAplicacao(){
        view.setVisible(true);
    }
}
