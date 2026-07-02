package br.trabalho.model;

public class Draconis extends Criatura implements HE_voador {

    private static int totalDraconis = 0;

    public Draconis(String nome) {

        super(nome);

        totalDraconis++;
    }

    public static int getTotalDraconis(){
        return totalDraconis;
    }

     @Override
    public void realizarVoo(){

        System.out.println(super.getNome() + " preparando pra voar...\n");
        System.out.println(super.getNome() + " esta voando sobre o reino!\n");

        super.setFelicidade(10);
    }

}
