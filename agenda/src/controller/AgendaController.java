package controller;

import view.*;
import modell.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AgendaController {
    private AgendaModell model;
    private AgendaView view;

    public void AgendaController(AgendaModell model, AgendaView view){
        this.model = model;
        this.view = view;

        this.view.setListMoedel(this.model);

        this.view.nomedafuncaoincerir(new AdicionarPessoaListener());
        this.view.nomedafuncaocinsultar(new ConsultaPessoasListener());
        this.view.nomedafuncaoalterar(new AlterarPessoaListener());
        this.view.nomedafuncaoexcluir(new ExcluirPessoaListener());
        this.view.nomedafuncaolimpar(nw LimpaListener());

        

    }
    public void iniciarAplicacao(){
        view.setVisible(true);
    }
}
