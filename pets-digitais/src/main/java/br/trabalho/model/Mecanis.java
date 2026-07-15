package br.trabalho.model;

public class Mecanis extends Criatura implements HE_mecanico {

    private static int totalMecanis = 0;

    public Mecanis (String nome) {

        super(nome, TipoCriatura.MECANIS);

        totalMecanis++;
    }

    @Override
    public int getTotalEspecie(){
        return totalMecanis;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEspecie: Mecanis" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void atualizaTurno(){
        super.setEnergia(-2);
        super.setSaciedade(-5);
        super.setFelicidade(-1);

        super.calculaSaude();
    }

    @Override
    public void realizarManutencao(){

        System.out.println(super.getNome() + " preparando cura...\n");
        System.out.println(super.getNome() + " auementou sua saúde!\n");

        super.setSaude(10);
    }

    @Override
    public void usarHabilidadeEspecial(){
        this.realizarManutencao();
    }

    @Override
    public DadosTreino getDadosTreino(){
        return new DadosTreino(40, 15, 20);
    }

    @Override
    public DadosBrincar getDadosBrincar(){
        return new DadosBrincar(10, 5, 10);
    }

    @Override
    public DadosExplorar getDadosExplorar(){
        return new DadosExplorar(25, 10, 15, 5);
    }

    @Override
    public DadosDesafio getDadosDesafio(){
        return new DadosDesafio(50, 20, 25, 10);
    }

    @Override
    public int recuperarEnergia(){
        return 15;
    }

    /* @Override
    public boolean podeComer(TipoAlimento alimento) {

        return alimento == TipoAlimento.COGUMELOS || alimento == TipoAlimento.CRISTAISENERGETICOS || alimento == TipoAlimento.BANQUETEREAL;
    } */

}
