package br.trabalho.model;

public class Lumini extends Criatura implements HE_luminescente {

    private static int totalLumini = 0;

    public Lumini(String nome) {

        super(nome);

        totalLumini++;
    }

    public static int getTotalLumini(){
        return totalLumini;
    }

    @Override
    public void emitirLuz(){

        System.out.println(super.getNome() + " preparando para emitir luz...\n");
        System.out.println(super.getNome() + " esta iluminando o reino!\n");

        super.setFelicidade(10);

    }

}
