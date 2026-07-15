package br.trabalho.model;

public class Lumini extends Criatura implements HE_luminescente {

    private static int totalLumini = 0;

    public Lumini(String nome) {

        super(nome, TipoCriatura.LUMINI);

        totalLumini++;
    }

    @Override
    public int getTotalEspecie(){
        return totalLumini;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nEspecie: Lumini" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void atualizaTurno(){
        super.setEnergia(-8);
        super.setSaciedade(-2);
        super.setFelicidade(-3);

        super.calculaSaude();
    }

    @Override
    public void emitirLuz(){

        System.out.println(super.getNome() + " preparando para emitir luz...\n");
        System.out.println(super.getNome() + " esta iluminando o reino!\n");

        super.setFelicidade(10);
    }

    @Override
    public void usarHabilidadeEspecial(){
        this.emitirLuz();
    }

    @Override
    public DadosTreino getDadosTreino(){
        return new DadosTreino(25, 20, 10);
    }

    @Override
    public DadosBrincar getDadosBrincar(){
        return new DadosBrincar(35, 5, 5);
    }

    @Override
    public DadosExplorar getDadosExplorar(){
        return new DadosExplorar(15, 20, 5, 10);
    }

    @Override
    public DadosDesafio getDadosDesafio(){
        return new DadosDesafio(45, 35, 15, 15);
    }

    @Override
    public int recuperarEnergia(){
        return 40;
    }

    /* @Override
    public boolean podeComer(TipoAlimento alimento) {

        return alimento == TipoAlimento.FOTONS || alimento == TipoAlimento.NECTARLUMINOSO || alimento == TipoAlimento.BANQUETEREAL;
    }
 */
}
