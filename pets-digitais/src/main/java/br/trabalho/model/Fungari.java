package br.trabalho.model;

public class Fungari extends Criatura {

    private static int totalFungari = 0;

    public Fungari(String nome) {

        super(nome);

        totalFungari++;
    }

    public static int getTotalFungari(){
        return totalFungari;
    }

}
