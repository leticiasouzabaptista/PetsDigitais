package br.trabalho.service;

import java.util.Scanner;

import br.trabalho.model.Aquari;
import br.trabalho.model.Criatura;
import br.trabalho.model.Draconis;
import br.trabalho.model.DraconisCelestial;
import br.trabalho.model.Estoque;
import br.trabalho.model.Fungari;
import br.trabalho.model.Lumini;
import br.trabalho.model.Mecanis;
import br.trabalho.model.TipoAlimento;
import br.trabalho.util.Leituras;
import br.trabalho.repository.CriaturaRepository;

public class CriaturaService {

    private CriaturaRepository repository;
    private Estoque estoque;

    public CriaturaService(){
        repository = new CriaturaRepository();
        estoque = new Estoque();
    }

    public void criaCriatura(){

        System.out.print("\nNome: ");
        String nome = Leituras.leFrase();

        System.out.print("╔════════════════════════╗\n");
        System.out.print("║   Escolha uma Espécie  ║\n");
        System.out.print("╚════════════════════════╝");

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
                repository.salvaCriatura(new Draconis(nome));
                System.out.println("\nCriatura criada com sucesso!");
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 2:{
                repository.salvaCriatura(new Lumini(nome));
                System.out.println("\nCriatura criada com sucesso!");
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 3:{
                repository.salvaCriatura(new Fungari(nome));
                System.out.println("\nCriatura criada com sucesso!");
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 4:{
                repository.salvaCriatura(new Aquari(nome));
                System.out.println("\nCriatura criada com sucesso!");
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 5:{
                repository.salvaCriatura(new Mecanis(nome));
                System.out.println("\nCriatura criada com sucesso!");
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 6:{
                repository.salvaCriatura(new DraconisCelestial(nome));
                System.out.println("\nCriatura criada com sucesso!");
                repository.getCriatura(nome).exibeInformacoes();
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

        if(repository.getCriaturas().isEmpty())
            System.out.println("O reino esá sem Pets");//melhorar essa frase
        else{
            for(Criatura criatura: repository.getCriaturas()){
            System.out.println("------------------------");
            System.out.println(criatura);
            System.out.println("------------------------");
            }
        }        
    }

    public void removeCriatura(Criatura criatura){
        repository.removeCriatura(criatura);
    }

    public void exibeInformacoes(Criatura criatura){
        if(repository.criaturaExiste(criatura))
            criatura.exibeInformacoes();
        else
            System.out.println("Criatura não encontrada no reino.");
    }

    public void exibeSatus(Criatura criatura){
        if(repository.criaturaExiste(criatura))
            criatura.exibeEstadoAtual();
        else
            System.out.println("Criatura não encontrada no reino.");
    }

    public void brincar(Criatura criatura){
        if(repository.criaturaExiste(criatura)){
            if(!criatura.brincar())
                System.out.print("A criatura não está disposta pra brincar.");
        }
        else
            System.out.println("Criatura não encontrada no reino.");
    }

    public void treinar(Criatura criatura){
        if(repository.criaturaExiste(criatura)){
            if(!criatura.treinar())
                System.out.print("A criatura não está disposta pra treinar.");
        }
        else
            System.out.println("Criatura não encontrada no reino.");
    }

    public void explorar(Criatura criatura){
        if(repository.criaturaExiste(criatura)){
            if(!criatura.explorar())
                System.out.print("A criatura não está disposta pra explorar.");
        }
        else
            System.out.println("Criatura não encontrada no reino.");
    }

    public void alimentar(Criatura criatura, TipoAlimento alimento){
        if(repository.criaturaExiste(criatura)){
            if(criatura.getTipoCriatura().podeComer(alimento)){
                if(estoque.existeNoEstoque(alimento)){
                    criatura.alimentar(alimento);
                    estoque.reabastece();
                }
                else
                    System.out.println("Alimento não esta no estoque.");
            }
            else
                System.out.println("\nCriatura não pode comer este alimento.");
        }
        else
            System.out.println("Criatura não encontrada no reino.");    
    }

    public void dormir(Criatura criatura){
        repository.getCriatura(criatura.getNome()).brincar();
    }

    public void desafio(Criatura criatura){
        repository.getCriatura(criatura.getNome()).brincar();
    }

    public void habilidadeEspecial(Criatura criatura){
        repository.getCriatura(criatura.getNome()).brincar();
    }
}
