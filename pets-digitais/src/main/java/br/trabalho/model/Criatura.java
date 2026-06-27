package br.trabalho.model;

import br.trabalho.Enum.*;

public abstract class Criatura {

    private String nome;
    private int idade;
    private int nivel;
    private int experiencia;
    private int energia;
    private int saciedade;
    private int felicidade;
    private int saude;

    public Criatura(String nome) {

        this.nome = nome;
        this.idade = 0;
        this.nivel = 0;
        this.experiencia = 0;
        this.energia = 99;
        this.saciedade = 99;
        this.felicidade = 99;
        this.saude = 99;
    }

    public void exibeInformacoes() {

        System.out.println("Criatura criada com sucesso!");
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║"+       nome        +"║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ Idade:            ║");
        System.out.println("║ Nivel:             ║");
        System.out.println("║ Experiencia:         ║");
        System.out.println("║ Saciedade:                  ║");
        System.out.println("║ Felicidade:                  ║");
        System.out.println("║ Saude:                  ║");
        System.out.println("╚══════════════════════════════╝");

    }

    public void exibeEstadoAtual() {

        System.out.println("Saúde: " + Saude.estadoSaude(saude));
        System.out.println("Saciedade: " + Saciedade.estadoSaciedade(saciedade));
        System.out.println("Felicidade: " + Felicidade.estadoFelicidade(felicidade));
        System.out.println("Energia: " + Energia.estadoEnergia(energia));

        // usar aquelas barrinhas aqui.
    }

}
