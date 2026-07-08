package br.trabalho.model;

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
    public boolean treinar(){
        if(super.getSaude() > 40 && super.getEnergia() >= 20 && super.getSaciedade() >= 20){
            super.setEnergia(25);
            super.setSaciedade(15);
            super.setExperiencia(10);

            System.out.println("Você está treinando!");

            return true;
        }
        else
            System.out.println("Você não está disposto para treinar. Tente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
        return false;
    }

    @Override
    public boolean explorar(){
        if(super.getSaude() > 20 && super.getEnergia() >= 15 && super.getSaciedade() >= 15){
            super.setEnergia(10);
            super.setSaciedade(10);
            super.setExperiencia(15);
            super.setFelicidade(5);

            System.out.println("Você está explorando o reino!");

            return true;
        }
        else
            System.out.println("Você não está disposto para explorar. Tente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.

        return false;
    }

    @Override
    public boolean brincar(){
        if(super.getSaude() > 20 && super.getEnergia() >= 50 && super.getSaciedade() >= 50){
            super.setFelicidade(20);
            super.setSaciedade(5);
            super.setEnergia(10);

            System.out.println("Você está brincando!");

            return true;
        }
        else
            System.out.println("Você não está disposto para brincar. Tente novamente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
        return false;
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
