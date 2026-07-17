package br.trabalho.model;

public enum Saciedade {

    FAMINTA,
    SATISFEITA;

    public static Saciedade estadoSaciedade(int saciedade){
        if(saciedade < 50)
            return FAMINTA;
        else
            return SATISFEITA;
    }
}
