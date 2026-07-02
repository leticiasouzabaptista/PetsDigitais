package br.trabalho.model;

public class Aquari extends Criatura implements HE_aquatico {

    private static int totalAquari = 0;

    public Aquari (String nome) {

        super(nome);

        totalAquari++;
    }

    public static int getTotalAquari(){
        return totalAquari;
    }

    @Override
    public void mergulhar(){

        System.out.println(super.getNome() + " preparando para nadar...\n");
        System.out.println(super.getNome() + " esta mergulhando sobre os mares do reino!\n");

        super.setFelicidade(10);
    }



}
