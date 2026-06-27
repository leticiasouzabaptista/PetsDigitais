package br.trabalho.model;

public class Mecanis extends Criatura {

    private static int totalMecanis = 0;

    public Mecanis (String nome) {

        super(nome);

        totalMecanis++;
    }

    public static int getTotalMecanis(){
        return totalMecanis;
    }

}
