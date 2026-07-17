package br.trabalho.model;

import java.io.IOException;
import br.trabalho.repository.CriaturaRepository;
import br.trabalho.repository.Estoque;

public class Mundo {

    private CriaturaRepository repository;
    private Estoque estoque;
    private int unidadesTempo;
    private int turno;

    public Mundo(){
        repository = new CriaturaRepository();
        estoque = new Estoque();
        this.unidadesTempo = 0;
        this.turno = 0;
        //importarEstoque();
    }

    public int getTurno(){
        return turno;
    }

    public CriaturaRepository getCriaturaRepository(){
        return repository;
    }

    public Estoque getEstoque(){
        return estoque;
    }

    public void avancaTempo(){
        this.unidadesTempo++;
        if(this.unidadesTempo == 5){
            this.avancaTurno();
            this.unidadesTempo = 0;
            for(Criatura criatura: repository.getCriaturas().values()){
                criatura.aplicaDesgasteNatural();
            }
        }    
    }

    private void avancaTurno(){
        this.turno++;
    }

    /* public void importarEstoque() {

        try {
            getEstoque().importarEstoque();
            System.out.println("\nImportação realizada com sucesso!");
        } catch (IOException e) {
            System.out.println("\nErro ao importar estoque: " + e.getMessage());
        }
    } */
}
