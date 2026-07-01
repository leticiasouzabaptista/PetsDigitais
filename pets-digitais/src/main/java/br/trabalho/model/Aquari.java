package br.trabalho.model;

public class Aquari extends Criatura {

    private static int totalAquari = 0;

    public Aquari (String nome) {

        super(nome);

        totalAquari++;
    }

    public static int getTotalAquari(){
        return totalAquari;
    }



}
