package br.trabalho.controller;

import java.util.Scanner;
import br.trabalho.model.Criatura;
import br.trabalho.util.Leituras;
import br.trabalho.repository.CriaturaRepository;

public class CriaturaController {

    CriaturaController(){
    }

    public void criaCriatura(){

        System.out.print("Nome: ");
        String nome = Leituras.leFrase();

        System.out.print("Escolha uma especie: ");

        System.out.print("1. Draconis\nCriaturas descendentes dos antigos dragões. Possuem grande vitalidade e aprendem habilidades mais rapidamente que as demais espécies.\n");
        System.out.print("2. Lumini\nCriaturas formadas por energia luminosa. Recuperam a felicidade rapidamente, porém se cansam com maior facilidade.\n");
        System.out.print("3. Fungari\nSeres inspirados em fungos mágicos. Possuem grande resistência à fome e ao cansaço, mas evoluem mais lentamente.\n");
        System.out.print("4. Aquari\nCriaturas adaptadas aos ambientes aquáticos. Recuperam sua saúde mais rapidamente que as demais espécies.\n");
        System.out.print("5. Mecanis\nCriaturas parcialmente artificiais. Necessitam de manutenção frequente e possuem elevada resistência física.\n");
        System.out.print("6. Draconis Celstial\nUma rara linhagem dos Draconis. Todo Draconis Celestial compartilha as características dos Draconis comuns, porém possui habilidades adicionais relacionadas à energia celestial.\n");

        int opcao = Leituras.leInt();
        switch (opcao) {
            case 1:
                
                break;
        
            default:
                break;
        }

    }

}
