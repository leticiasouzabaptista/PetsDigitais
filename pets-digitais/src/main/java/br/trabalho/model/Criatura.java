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

    public Criatura(String nome,
            int idade,
            int nivel,
            int experiencia,
            int energia,
            int saciedade,
            int felicidade,
            int saude) {

        this.nome = nome;
        this.idade = idade;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.energia = energia;
        this.saciedade = saciedade;
        this.felicidade = felicidade;
        this.saude = saude;
    }

    public void exibeInformacoes() {

        System.out.printf("Nome: %s\nIdade: %d\nNivel: %d\nExperiência: %d\nEnergia: %d\nSaciedade: %d\nFeliciade: %d\nSaude: %d\n", nome, idade, nivel, experiencia, energia, saciedade, felicidade, saude);

        // usar aquelas barrinhas aqui.
    }

    public void exibeEstadoAtual() {

        System.out.println("Saúde: " + Saude.estadoSaude(saude));
        System.out.println("Saciedade: " + Saciedade.estadoSaciedade(saciedade));
        System.out.println("Felicidade: " + Felicidade.estadoFelicidade(felicidade));
        System.out.println("Energia: " + Energia.estadoEnergia(energia));
    }

}
