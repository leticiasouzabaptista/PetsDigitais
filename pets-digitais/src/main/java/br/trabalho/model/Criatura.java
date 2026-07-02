package br.trabalho.model;

import br.trabalho.Enum.*;
import br.trabalho.util.Formatacao;

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

        System.out.println("╔══════════════════════════════╗");
        Formatacao.imprimirCentralizado(nome, 31);
        System.out.println("╠══════════════════════════════╣");
        System.out.printf("║ Idade: %-21d ║%n", idade);
        System.out.printf("║ Nível: %-21d ║%n", nivel);
        System.out.printf("║ Experiência: %-15d ║%n", experiencia);
        System.out.printf("║ Saciedade: %-17d ║%n", saciedade);
        System.out.printf("║ Felicidade: %-16d ║%n", felicidade);
        System.out.printf("║ Saúde: %-21d ║%n", saude);
        System.out.println("╚══════════════════════════════╝");

    }

    public void exibeEstadoAtual() {

        System.out.println("Saúde: " + Saude.estadoSaude(saude));
        System.out.println("Saciedade: " + Saciedade.estadoSaciedade(saciedade));
        System.out.println("Felicidade: " + Felicidade.estadoFelicidade(felicidade));
        System.out.println("Energia: " + Energia.estadoEnergia(energia));

        // usar aquelas barrinhas aqui.
    }

    public void calculaSaude(){
        saude = (energia + saciedade + felicidade)/3;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public int getNivel(){
        return nivel;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public int getEnergia(){
        return energia;
    }

    public int getSaciedade(){
        return saciedade;
    }

    public int getFelicidade(){
        return felicidade;
    }

    public int getSaude(){
        return saude;
    }

    public void setIdade(){
        //this.experiencia += modificador;
    }

    public void setNivel(){
        //this.experiencia += modificador;
    }

    public void setExperiencia(int modificador){
        this.experiencia += modificador - nivel/10;
    }

    public void setEnergia(int modificador){
        this.experiencia -= modificador + nivel/10;
    }

    public void setSaciedade(int modificador){
        this.experiencia -= modificador + nivel/10;
    }

    public void setFelicidade(int modificador){
        this.experiencia -= modificador + nivel/10;
    }

    public abstract void atualizaTurno();
    
}
