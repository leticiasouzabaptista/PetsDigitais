package br.trabalho.model;

public class Lumini extends Criatura {

    private static int totalLumini = 0;

    public Lumini(String nome) {

        super(nome);

        totalLumini++;
    }

    public static int getTotalLumini(){
        return totalLumini;
    }

}
