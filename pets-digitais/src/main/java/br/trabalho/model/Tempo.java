package br.trabalho.model;

public class Tempo {

    private int contaTempo;
    private int diasJogados;

    public Tempo(){
        this.contaTempo = 0;
        this.diasJogados = 0;
    }

    public void passagemTempo(){

        this.contaTempo++;

        if(contaTempo == 5){
            Criatura.atualizaTurno();
            contaTempo = 0;
            diasJogados++;
        }
    }

    public int getDiasJogados(){
        return diasJogados;
    }
}
