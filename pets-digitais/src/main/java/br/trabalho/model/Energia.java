package br.trabalho.model;

public enum Energia {

    CANSADO,
    DISPOSTA;

    public static Energia estadoEnergia(int energia){
        if(energia < 50)
            return CANSADO;
        else
            return DISPOSTA;
    }

}
