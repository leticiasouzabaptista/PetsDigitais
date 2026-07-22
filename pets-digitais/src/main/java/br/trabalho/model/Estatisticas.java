package br.trabalho.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Estatisticas {

    private Mundo mundo;
    private int totalCriaturas;
    private int quantidadeCriaturasMortas;
    private int quantidadeCriaturasVivas;
    private int tamanhoEstoque;
    private Criatura criaturaMaiorNivel;
    private Criatura criaturaMenorNivel;
    private int turno;
    private int totalAquari;
    private int totalDraconis;
    private int totalDraconisCelestial;
    private int totalLumini;
    private int totalFungari;
    private int totalMecanis;

    public Estatisticas(Mundo mundo){
        this.mundo = mundo;
    }

    public void totalCriaturas(){
        this.totalCriaturas = mundo.getCriaturaRepository().totalCriaturas();
    }
    
    public void totalCriaturasMortas(){
        this.quantidadeCriaturasMortas = mundo.getCriaturaRepository().totalCriaturasMortas();
    }

    public void totalCriaturasVivas(){
        this.quantidadeCriaturasVivas = mundo.getCriaturaRepository().totalCriaturasVivas();
    }

    public void totalAquari(){
        this.totalAquari = mundo.getCriaturaRepository().quantidadeCriaturasVivas(TipoCriatura.AQUARI);
    }

    public void totalDraconis(){
        this.totalDraconis = mundo.getCriaturaRepository().quantidadeCriaturasVivas(TipoCriatura.DRACONIS);
    }

    public void totalDraconisCelestial(){
        this.totalDraconisCelestial = mundo.getCriaturaRepository().quantidadeCriaturasVivas(TipoCriatura.DRACONISCELESTIAL);
    }

    public void totalFungari(){
        this.totalFungari = mundo.getCriaturaRepository().quantidadeCriaturasVivas(TipoCriatura.FUNGARI);
    }

    public void totalLumini(){
        this.totalLumini = mundo.getCriaturaRepository().quantidadeCriaturasVivas(TipoCriatura.LUMINI);
    }

    public void totalMecanis(){
        this.totalMecanis = mundo.getCriaturaRepository().quantidadeCriaturasVivas(TipoCriatura.MECANIS);
    }
    
    public void turnoAtual(){
        this.turno = mundo.getTurno();
    }

    public void criaturaMaiorNivel(){

        int nivel = 0;

        if(mundo.getCriaturaRepository().totalCriaturasVivas() == 0)
            this.criaturaMaiorNivel = null;
        else{
            for(Criatura criatura: mundo.getCriaturaRepository().getCriaturas().values()){
                if(criatura.getNivel() >= nivel){
                    this.criaturaMaiorNivel = criatura;
                    nivel = criatura.getNivel();
                }
            }
        }
    }

    public void criaturaMenorNivel(){

        int nivel = 0;

        for(Criatura criatura: mundo.getCriaturaRepository().getCriaturas().values()){
            if(criatura.getNivel() <= nivel){
                this.criaturaMaiorNivel = criatura;
                nivel = criatura.getNivel();
            }
        }
    }

    public void estoque(){
        this.tamanhoEstoque = mundo.getEstoque().getQuantidadeEstoque();
    }

    public int getTotalCriaturas() {
    return totalCriaturas;
    }

    public int getTotalCriaturasMortas() {
        return quantidadeCriaturasMortas;
    }

    public int getTotalCriaturasVivas() {
        return quantidadeCriaturasVivas;
    }

    public int getTotalDraconis() {
        return totalDraconis;
    }

    public int getTotalDraconisCelestial() {
        return totalDraconisCelestial;
    }

    public int getTotalFungari() {
        return totalFungari;
    }

    public int getTotalLumini() {
        return totalLumini;
    }

    public int getTotalMecanis() {
        return totalMecanis;
    }

    public int getTotalAquari() {
        return totalAquari;
    }

    public int getTurno() {
        return turno;
    }

    public Criatura getCriaturaMaiorNivel(){
        return criaturaMaiorNivel;
    }

    public Criatura getCriaturaMenorNivel(){
        return criaturaMenorNivel;
    }

    public int getTamanhoEstoque(){
        return tamanhoEstoque;
    }

    public void atualizar() {

        totalCriaturas();
        totalCriaturasMortas();
        totalCriaturasVivas();
        totalAquari();
        totalDraconis();
        totalDraconisCelestial();
        totalLumini();
        totalFungari();
        totalMecanis();
        criaturaMaiorNivel();
        criaturaMenorNivel();
        estoque();
        turnoAtual();
    }

    public void imprimeEstatisticas() {

        atualizar();
        System.out.println("\nTurno: " + getTurno());
        System.out.println();
        System.out.println("Total de criaturas: " + getTotalCriaturas());
        System.out.println("Criaturas vivas: " + getTotalCriaturasVivas());
        System.out.println("Criaturas mortas: " + getTotalCriaturasMortas());
        System.out.println();
        System.out.println("Aquari: " + getTotalAquari());
        System.out.println("Draconis: " + getTotalDraconis());
        System.out.println("Draconis Celestial: " + getTotalDraconisCelestial());
        System.out.println("Lumini: " + getTotalLumini());
        System.out.println("Fungari: " + getTotalFungari());
        System.out.println("Mecanis: " + getTotalMecanis());
        System.out.println();

        if (criaturaMaiorNivel != null)
            System.out.println("Maior nível: " + criaturaMaiorNivel.getNome() +" (Nível " + criaturaMaiorNivel.getNivel() + ")");

        if (criaturaMenorNivel != null)
            System.out.println("Menor nível: " + criaturaMenorNivel.getNome() + " (Nível " + criaturaMenorNivel.getNivel() + ")");
        System.out.println("Itens no estoque: " + getTamanhoEstoque());
    }

    public void exportarEstatisticas() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String data = agora.format(formatter);

        File pasta = new File("Estatisticas");
        pasta.mkdirs();

        File arquivo = new File(pasta, "estatisticas_" + data + ".csv");

        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            writer.println("chave,valor");
            writer.println("Turno Atual," + getTurno());
            writer.println("Total de criaturas," + getTotalCriaturas());
            writer.println("Criaturas vivas," + getTotalCriaturasVivas());
            writer.println("Criaturas mortas," + getTotalCriaturasMortas());
            writer.println("Aquari," + getTotalAquari());
            writer.println("Draconis," + getTotalDraconis());
            writer.println("Draconis Celestial," + getTotalDraconisCelestial());
            writer.println("Lumini," + getTotalLumini());
            writer.println("Fungari," + getTotalFungari());
            writer.println("Mecanis," + getTotalMecanis());
            writer.println("Tamanho do estoque," + getTamanhoEstoque());
            
            System.out.println("Estatísticas exportadas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao tentar salvar o arquivo CSV: " + e.getMessage());
        }
    }
}
