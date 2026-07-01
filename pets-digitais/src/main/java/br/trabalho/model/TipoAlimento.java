package br.trabalho.model;

public enum TipoAlimento {

    FRUTAS(20),
    CARNE(35),
    FOTONS(20),
    NECTARLUMINOSO(35),
    COGUMELOS(20),
    CRISTAISENERGETICOS(35),
    BANQUETEREAL(50);

    private int saciedade;

    TipoAlimento(int saciedade){
        this.saciedade = saciedade;
    }

    public int getModificadorSaciedade(){
        return saciedade;
    }
}
