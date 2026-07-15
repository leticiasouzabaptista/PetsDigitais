package br.trabalho.model;

public class Fungari extends Criatura {

    private static int totalFungari = 0;

    public Fungari(String nome) {

        super(nome, TipoCriatura.FUNGARI);
        totalFungari++;
    }

    @Override
    public int getTotalEspecie(){
        return totalFungari;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEspecie: Draconis" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void usarHabilidadeEspecial(){
        System.out.println("\nEssa criatura não possui Habilidade Especial.");
    }

    @Override
    public void atualizaTurno(){
        super.setEnergia(-3);
        super.setSaciedade(-2);
        super.setFelicidade(-2);

        super.calculaSaude();
    }
    
    @Override
    public DadosTreino getDadosTreino(){
        return new DadosTreino(20, 10, 10);
    }

    @Override
    public DadosBrincar getDadosBrincar(){
        return new DadosBrincar(15, 5, 5);
    }

    @Override
    public DadosExplorar getDadosExplorar(){
        return new DadosExplorar(10, 5, 5, 5);
    }

    @Override
    public DadosDesafio getDadosDesafio(){
        return new DadosDesafio(40, 15, 15, 5);
    }

    @Override
    public int recuperarEnergia(){
        return 20;
    }
    
    /* @Override
    public boolean podeComer(TipoAlimento alimento) {

        return alimento == TipoAlimento.COGUMELOS || alimento == TipoAlimento.FRUTAS || alimento == TipoAlimento.BANQUETEREAL;
    }
 */
}
