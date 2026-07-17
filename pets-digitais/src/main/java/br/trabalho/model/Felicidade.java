package br.trabalho.model;

public enum Felicidade {

    TRISTE,
    FELIZ;

    public static Felicidade estadoFelicidade(int felicidade){
        if(felicidade < 50)
            return TRISTE;
        else
            return FELIZ;
    }

}
