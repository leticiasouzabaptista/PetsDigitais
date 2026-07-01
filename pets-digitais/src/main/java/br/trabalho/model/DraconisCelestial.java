package br.trabalho.model;

public class DraconisCelestial extends Criatura {

    private static int totalDraconisCelestial = 0;

    public DraconisCelestial(String nome) {

        super(nome);

        totalDraconisCelestial++;
    }

    public static int getTotalDraconisCelestial(){
        return totalDraconisCelestial;
    }

}
