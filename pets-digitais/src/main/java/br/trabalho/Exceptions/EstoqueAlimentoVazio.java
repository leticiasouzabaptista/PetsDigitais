package br.trabalho.Exceptions;

public class EstoqueAlimentoVazio extends RuntimeException {

    public EstoqueAlimentoVazio(){
        super("Estoque desse alimento vazio.");
    }

}
