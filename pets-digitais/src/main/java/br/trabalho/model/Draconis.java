package br.trabalho.model;

public class Draconis extends Criatura {

    private static int totalDraconis = 0;

    public Draconis(String nome) {

        super(nome);

        totalDraconis++;
    }

    public static int getTotalDraconis(){
        return totalDraconis;
    }

}
