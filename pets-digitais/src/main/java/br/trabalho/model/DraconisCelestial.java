package br.trabalho.model;

public class DraconisCelestial extends Criatura implements HE_voador, HE_autodidata {

    private static int totalDraconisCelestial = 0;

    public DraconisCelestial(String nome) {

        super(nome);

        totalDraconisCelestial++;
    }

    public static int getTotalDraconisCelestial(){
        return totalDraconisCelestial;
    }

    @Override
    public void realizarVoo(){

        System.out.println(super.getNome() + " preparando pra voar...\n");
        System.out.println(super.getNome() + " esta voando sobre o reino!\n");

        super.setFelicidade(10);
    }

    //arrumar essa logica de há cada 10 niveis somar 30.
    @Override
    public void estudar(){

        System.out.println(super.getNome() + " preparando pra voar...\n");
        System.out.println(super.getNome() + " esta voando sobre o reino!\n");

        super.setExperiencia(30);

    }

}
