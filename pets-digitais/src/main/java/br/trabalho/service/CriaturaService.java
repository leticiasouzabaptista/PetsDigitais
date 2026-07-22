package br.trabalho.service;

import java.io.IOException;
import br.trabalho.model.Aquari;
import br.trabalho.model.Criatura;
import br.trabalho.model.Draconis;
import br.trabalho.model.DraconisCelestial;
import br.trabalho.model.Fungari;
import br.trabalho.model.Lumini;
import br.trabalho.model.Mecanis;
import br.trabalho.model.Mundo;
import br.trabalho.model.TipoAlimento;
import br.trabalho.util.Leituras;

public class CriaturaService {
    
    private Mundo mundo;

    public CriaturaService(Mundo mundo){
        this.mundo = mundo;
    }  
        
    public void criaCriatura(){

        System.out.print("\nNome: ");
        String nome = Leituras.leFrase();

        System.out.println("===== Escolha uma espécie =====");
        System.out.print("\n1. Draconis\nCriaturas descendentes dos antigos dragões. Possuem grande vitalidade e aprendem habilidades mais rapidamente que as demais espécies.\n");
        System.out.print("\n2. Lumini\nCriaturas formadas por energia luminosa. Recuperam a felicidade rapidamente, porém se cansam com maior facilidade.\n");
        System.out.print("\n3. Fungari\nSeres inspirados em fungos mágicos. Possuem grande resistência à fome e ao cansaço, mas evoluem mais lentamente.\n");
        System.out.print("\n4. Aquari\nCriaturas adaptadas aos ambientes aquáticos. Recuperam sua saúde mais rapidamente que as demais espécies.\n");
        System.out.print("\n5. Mecanis\nCriaturas parcialmente artificiais. Necessitam de manutenção frequente e possuem elevada resistência física.\n");
        System.out.print("\n6. Draconis Celstial\nUma rara linhagem dos Draconis. Todo Draconis Celestial compartilha as características dos Draconis comuns, porém possui habilidades adicionais relacionadas à energia celestial.\n");

        boolean opcaoValida = false;
        while(!opcaoValida){
            
            int opcao = Leituras.leInt();

            switch (opcao) {
            case 1:{
                Criatura criatura = new Draconis(nome);
                mundo.getCriaturaRepository().salvaCriatura(criatura);
                System.out.println("\nCriatura criada com sucesso!");
                mundo.getCriaturaRepository().getCriatura(criatura.getNomeUnico()).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 2:{
                Criatura criatura = new Lumini(nome);
                mundo.getCriaturaRepository().salvaCriatura(criatura);
                System.out.println("\nCriatura criada com sucesso!");
                mundo.getCriaturaRepository().getCriatura(criatura.getNomeUnico()).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 3:{
                Criatura criatura = new Fungari(nome);
                mundo.getCriaturaRepository().salvaCriatura(criatura);
                System.out.println("\nCriatura criada com sucesso!");
                mundo.getCriaturaRepository().getCriatura(criatura.getNomeUnico()).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 4:{
                Criatura criatura = new Aquari(nome);
                mundo.getCriaturaRepository().salvaCriatura(criatura);
                System.out.println("\nCriatura criada com sucesso!");
                mundo.getCriaturaRepository().getCriatura(criatura.getNomeUnico()).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 5:{
                Criatura criatura = new Mecanis(nome);
                mundo.getCriaturaRepository().salvaCriatura(criatura);
                System.out.println("\nCriatura criada com sucesso!");
                mundo.getCriaturaRepository().getCriatura(criatura.getNomeUnico()).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 6:{
                Criatura criatura = new DraconisCelestial(nome);
                mundo.getCriaturaRepository().salvaCriatura(criatura);
                System.out.println("\nCriatura criada com sucesso!");
                mundo.getCriaturaRepository().getCriatura(criatura.getNomeUnico()).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            default:{
                System.out.println("Opção não válida.\nTente novamente.");
                }
            }
        }
    }

    public void criaturasCadastradas(){

        if(mundo.getCriaturaRepository().getCriaturas().isEmpty())
            System.out.println("O reino está sem Pets");//melhorar essa frase
        else{
            for(Criatura criatura: mundo.getCriaturaRepository().getCriaturas().values()){
            System.out.println("------------------------");
            System.out.println(criatura);
            System.out.println("------------------------");
            }
        }        
    }

    public void removeCriatura(Criatura criatura){
        mundo.getCriaturaRepository().removeCriatura(criatura);
    }

    public void exibeInformacoes(Criatura criatura){
        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        criatura.exibeInformacoes();
    }

    public void exibeSatus(Criatura criatura){
        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        criatura.exibeEstadoAtual();
    }

    public void brincar(Criatura criatura){

        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);
        
        if(criatura.getSaude() > 20 && criatura.getEnergia() >= 50 && criatura.getSaciedade() >= 50){
            criatura.brincar();
            mundo.avancaTempo();
        }
        else
            System.out.println("Você não está disposto para brincar. Tente novamente...");
    }

    public void treinar(Criatura criatura){

        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);

        if(criatura.getSaude() > 40 && criatura.getEnergia() >= 20 && criatura.getSaciedade() >= 20){
            criatura.treinar();
            mundo.avancaTempo();
        }
        else
            System.out.println("Você não está disposto para treinar. Tente...");
    }

    public void explorar(Criatura criatura){

        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);
       
        if(criatura.getSaciedade() > 20 && criatura.getEnergia() >= 15 && criatura.getSaciedade() >= 15){
            criatura.explorar();
            mundo.avancaTempo();
        }
        else
            System.out.println("Você não está disposto para explorar. Tente...");
    }

    public void alimentar(Criatura criatura, TipoAlimento alimento){
        
        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);

        if(criatura.getTipoCriatura().podeComer(alimento)){
            if(mundo.getEstoque().existeNoEstoque(alimento)){
                criatura.alimentar(alimento);
                mundo.getEstoque().reabastece();
            }
            else
                System.out.println("Alimento não esta no estoque.");
        }
        else
            System.out.println("\nCriatura não pode comer este alimento."); 
    }

    public void dormir(Criatura criatura){

        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);

        if(criatura.getSaude() > 0 && criatura.getEnergia() < 90 ){
            criatura.descansar();
            mundo.avancaTempo();
        }
        else
            System.out.println("Você ainda não esta cansado para...");
    }

    public void desafio(Criatura criatura){

        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);

        if(criatura.getSaude() > 40 && criatura.getNivel() >= 5 && criatura.getEnergia() >= 50 && criatura.getSaciedade() >= 50){
            if(criatura.getNivel() % 15 == 0){
                if(!criatura.participouDesafio()){
                    criatura.desafio();
                    System.out.println("\nVocê concluiu um desafio!");
                }
            }
            else
                System.out.print("A criatura não está apta para realizar o desafio.");
        }
        else
            System.out.print("A criatura não está disposta para realizar o desafio.");
    }

    public void habilidadeEspecial(Criatura criatura){

        mundo.getCriaturaRepository().verificaCriaturaExiste(criatura);
        mundo.getCriaturaRepository().verificaCriaturaMorta(criatura);
        criatura.usarHabilidadeEspecial();
    }

    public void exportarCriaturas(){
        try{
            mundo.getCriaturaRepository().exportarCriaturas();
            System.out.println("\nExportação realizada com sucesso!");
        }
        catch(IOException e){
            System.out.println("\nErro ao exportar criaturas: " + e.getMessage());
        }
    }

    public void importarCriaturas(){
        try{
            mundo.getCriaturaRepository().importarCriaturas();
            System.out.println("\nImportação realizada com sucesso!");
        }
        catch(IOException e){
            System.out.println("\nErro ao importar criaturas: " + e.getMessage());
        }
    }
}
