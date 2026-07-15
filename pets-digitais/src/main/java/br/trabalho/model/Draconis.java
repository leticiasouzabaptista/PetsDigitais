package br.trabalho.model;

public class Draconis extends Criatura implements HE_voador {

    private static int totalDraconis = 0;

    public Draconis(String nome) {

        super(nome, TipoCriatura.DRACONIS);

        totalDraconis++;
    }

    @Override
    public int getTotalEspecie(){
        return totalDraconis;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEspecie: Draconis" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
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

    @Override
    public void usarHabilidadeEspecial(){
        this.realizarVoo();
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
