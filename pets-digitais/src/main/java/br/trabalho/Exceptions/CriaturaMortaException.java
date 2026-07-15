package br.trabalho.Exceptions;

public class CriaturaMortaException extends RuntimeException{

    public CriaturaMortaException(){
        super("Criatura está morta.");
    }

}
