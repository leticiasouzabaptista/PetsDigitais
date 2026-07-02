package br.trabalho.model;

import java.util.List;

public class Tempo {

    private int contaTempo;
    private int diasJogados;

    public Tempo(){
        this.contaTempo = 0;
        this.diasJogados = 0;
    }

    public void passagemTempo(List <Criatura> criaturas){

        this.contaTempo++;

        if(contaTempo == 5){

            contaTempo = 0;
            diasJogados++;

            for(Criatura criatura: criaturas){
                criatura.atualizaTurno();
            }
        }
    }

    public int getDiasJogados(){
        return diasJogados;
    }
}
