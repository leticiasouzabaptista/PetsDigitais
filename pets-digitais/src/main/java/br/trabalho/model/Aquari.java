package br.trabalho.model;

import br.trabalho.Enum.Energia;

public class Aquari extends Criatura {

    private static int totalAquari = 0;

    public Aquari (String nome) {

        super(nome);
        totalAquari++;
    }

    public static int getTotalAquari(){
        return totalAquari;
    }

    @Override
    public DadosTreino getDadosTreino() {
        return new DadosTreino(15, 10, 25);
    }

    @Override
    public void treinar(){
        if(super.getSaude() > 40 && super.getEnergia() >= 20 && super.getSaciedade() >= 20){
            super.setEnergia(15 + ModificadorAcesso.modificador(super.getNivel()));
            super.setSaciedade(10 + ModificadorAcesso.modificador(super.getNivel()));
            super.setExperiencia(25 - ModificadorAcesso.modificador(super.getNivel()));
        }
        else
            System.out.println("Você não está disposto para brincar. Tente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
    }

    @Override
    public void explorar(){
        if(super.getSaude() > 20 && super.getEnergia() >= 15 && super.getSaciedade() >= 15){
            super.setEnergia(10 + ModificadorAcesso.modificador(super.getNivel()));
            super.setSaciedade(10 + ModificadorAcesso.modificador(super.getNivel()));
            super.setFelicidade(5 + ModificadorAcesso.modificador(super.getNivel()));
            super.setExperiencia(15 - ModificadorAcesso.modificador(super.getNivel()));
        }   
    }

    @Override
    public void brincar(){
        if(super.getSaude() > 20 && super.getEnergia() >= 50 && super.getSaciedade() >= 50){
            super.setEnergia(10 + ModificadorAcesso.modificador(super.getNivel()));
            super.setSaciedade(5 + ModificadorAcesso.modificador(super.getNivel()));
            super.setFelicidade(20 - ModificadorAcesso.modificador(super.getNivel()));
        }   
    }





}
