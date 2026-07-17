package br.trabalho.model;

import br.trabalho.util.Leituras;

public class DraconisCelestial extends Draconis implements HE_autodidata {

    private static int totalDraconisCelestial = 0;

    public DraconisCelestial(){
        super();
    }

    public DraconisCelestial(String nome) {

        super(nome, TipoCriatura.DRACONISCELESTIAL);
        totalDraconisCelestial++;
    }

    public static int getTotalDraconisCelestial(){
        return totalDraconisCelestial;
    }

    //arrumar essa logica de há cada 10 niveis somar 30.
    @Override
    public void estudar(){

        System.out.println(super.getNome() + " preparando pra voar...\n");
        System.out.println(super.getNome() + " esta voando sobre o reino!\n");

        super.setExperienciaSoma(30);

    }

    @Override
    public void usarHabilidadeEspecial(){
        System.out.println("\n1. Realizar Voo\n2. Estudar");
        int opcao = Leituras.leInt();

        switch (opcao) {
            case 1:
                this.realizarVoo();
                break;
            case 2:
                this.estudar();
                break;
        
            default:
                System.out.println("Opcao inválida, tente novamente:");
        }
    }
}
