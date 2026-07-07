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
    public boolean podeComer(TipoAlimento alimento) {

        return alimento == TipoAlimento.COGUMELOS || alimento == TipoAlimento.CRISTAISENERGETICOS || alimento == TipoAlimento.BANQUETEREAL;
    }

}
