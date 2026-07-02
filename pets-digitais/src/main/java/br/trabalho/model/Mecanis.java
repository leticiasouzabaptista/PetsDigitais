package br.trabalho.model;

public class Mecanis extends Criatura implements HE_mecanico {

    private static int totalMecanis = 0;

    public Mecanis (String nome) {

        super(nome);

        totalMecanis++;
    }

    public static int getTotalMecanis(){
        return totalMecanis;
    }

    @Override
    public void realizarManutencao(){

        System.out.println(super.getNome() + " preparando cura...\n");
        System.out.println(super.getNome() + " auementou sua saúde!\n");

        super.setSaude(10);
    }

}
