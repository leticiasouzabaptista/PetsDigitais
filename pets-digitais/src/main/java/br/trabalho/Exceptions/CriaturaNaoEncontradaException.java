package br.trabalho.Exceptions;

public class CriaturaNaoEncontradaException extends RuntimeException {

    public CriaturaNaoEncontradaException(){
        super("Criatura não encontrada no reino.");
    }

}
