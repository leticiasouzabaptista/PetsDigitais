package br.trabalho.model;

import br.trabalho.util.Leituras;

public class DraconisCelestial extends Criatura implements HE_voador, HE_autodidata {

    private static int totalDraconisCelestial = 0;

    public DraconisCelestial(String nome) {

        super(nome, TipoCriatura.DRACONISCELESTIAL);

        totalDraconisCelestial++;
    }

    @Override
    public int getTotalEspecie(){
        return totalDraconisCelestial;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEspecie: Fungari" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void atualizaTurno(){
        super.setEnergia(-5);
        super.setSaciedade(-4);
        super.setFelicidade(-2);

        super.calculaSaude();
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

    @Override
    public void usarHabilidadeEspecial(){
        System.out.println("\n1. Realizar Voo\n2. Estudar");
        int opcao = Leituras.leInt();

        //ve onde esse switch vai ficar mesmo e colocar opcao -1 e dentro de um while
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

    @Override
    public DadosTreino getDadosTreino(){
        return new DadosTreino(35, 25, 15);
    }

    @Override
    public DadosBrincar getDadosBrincar(){
        return new DadosBrincar(20, 10, 5);
    }

    @Override
    public DadosExplorar getDadosExplorar(){
        return new DadosExplorar(20, 15, 10, 5);
    }

    @Override
    public DadosDesafio getDadosDesafio(){
        return new DadosDesafio(60, 30, 20, 10);
    }

    @Override
    public int recuperarEnergia(){
        return 30;
    }

    /* @Override
    public boolean podeComer(TipoAlimento alimento) {

        return alimento == TipoAlimento.CARNE || alimento == TipoAlimento.FRUTAS || alimento == TipoAlimento.BANQUETEREAL;
    } */
}
