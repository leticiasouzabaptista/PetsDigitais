package br.trabalho.repository;

import br.trabalho.model.*;
import java.util.List;
import java.util.ArrayList;


public class CriaturaRepository {

    private List <Criatura> criaturas;

    public CriaturaRepository(){
        criaturas = new ArrayList<>();
    }

    public void salvaCriatura(Criatura criatura){
        criaturas.add(criatura);
    }

    public Criatura getCriatura(String nome){

        for(Criatura criatura: criaturas){
            if(criatura.getNome().equals(nome))
                return criatura;
        }

        return null;
    }

}
