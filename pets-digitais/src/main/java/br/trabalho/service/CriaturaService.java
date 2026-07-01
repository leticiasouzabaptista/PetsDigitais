package br.trabalho.service;

import java.util.Scanner;

import br.trabalho.model.Aquari;
import br.trabalho.model.Criatura;
import br.trabalho.model.Draconis;
import br.trabalho.model.DraconisCelestial;
import br.trabalho.model.Fungari;
import br.trabalho.model.Lumini;
import br.trabalho.model.Mecanis;
import br.trabalho.util.Leituras;
import br.trabalho.repository.CriaturaRepository;

public class CriaturaService {

    private CriaturaRepository repository;

    public CriaturaService(){
        repository = new CriaturaRepository();
    }

    public void criaCriatura(){

        System.out.print("Nome: ");
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
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 2:{
                repository.salvaCriatura(new Lumini(nome));
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 3:{
                repository.salvaCriatura(new Fungari(nome));
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 4:{
                repository.salvaCriatura(new Aquari(nome));
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 5:{
                repository.salvaCriatura(new Mecanis(nome));
                repository.getCriatura(nome).exibeInformacoes();
                opcaoValida = true;
                break;
                }
            case 6:{
                repository.salvaCriatura(new DraconisCelestial(nome));
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

}
