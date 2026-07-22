package br.trabalho.repository;

import java.util.List;
import java.util.Map;
import br.trabalho.model.TipoAlimento;
import br.trabalho.model.TipoCriatura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Estoque {

    private Map<TipoAlimento, Integer> estoque;
    private CriaturaRepository repository;

    public Estoque(){
        estoque = new HashMap<>();
    }

    public int getQuantidadeEstoque(){
        return estoque.size();
    }

    public void imprimeEstoque(){
        System.out.println("\nFrutas: " + estoque.getOrDefault(TipoAlimento.FRUTAS, 0) + 
        "\nCarne: " + estoque.getOrDefault(TipoAlimento.CARNE, 0) + 
        "\nFótons: " + estoque.getOrDefault(TipoAlimento.FOTONS, 0) + 
        "\nNéctar Luminoso: " + estoque.getOrDefault(TipoAlimento.NECTARLUMINOSO, 0) + 
        "\nCogumelos: " + estoque.getOrDefault(TipoAlimento.COGUMELOS, 0) +
        "\nCristais Energéticos: " + estoque.getOrDefault(TipoAlimento.CRISTAISENERGETICOS, 0) + 
        "\nBanquete Real: " + estoque.getOrDefault(TipoAlimento.BANQUETEREAL, 0));
    }

    public boolean existeNoEstoque(TipoAlimento alimento){
        if(estoque.get(alimento) > 0)
            return true;
        return false;
    }

    public void reabastece() {

        for (TipoCriatura criatura: TipoCriatura.values()) {

            int minimo = repository.quantidadeCriaturasVivas(criatura) * 3;

            int disponivel = calculaEstoqueDisponivel(criatura);

            if (disponivel < minimo) {
                adicionaAlimentos(criatura);
            }
        }
    }

    private int calculaEstoqueDisponivel(TipoCriatura criatura){

        int total = 0;

        for(TipoAlimento alimento : criatura.getAlimentosPermitidos())
            total += estoque.get(alimento);

        return total;
    }

    private void adicionaAlimentos(TipoCriatura especie){

        List<TipoAlimento> alimentos = especie.getAlimentosPermitidos();

        int quantidadePorAlimento = 10 / alimentos.size();

        for(TipoAlimento alimento : alimentos)
            estoque.put( alimento, estoque.get(alimento) + quantidadePorAlimento);
    }

    public void carregarAlimento(TipoAlimento tipo, int quantidade){
        estoque.put(tipo, estoque.get(tipo) + quantidade);
    }

    public void carregarEstoque(String caminhoArquivo, Estoque estoque) {

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty())
                    continue;

                String[] colunas = linha.split(",");

                String nomeTexto = colunas[0].trim();
                int quantidade = Integer.parseInt(colunas[1].trim());

                TipoAlimento tipo = TipoAlimento.converterDeTexto(nomeTexto);

                if (tipo != null) {
                    estoque.carregarAlimento(tipo, quantidade);
                } else {
                    System.err.println("Aviso: Alimento não reconhecido no CSV: " + nomeTexto);
                }
            }
            System.out.println("Estoque carregado com sucesso do CSV!");
        } 
        catch (IOException e) {
            System.err.println("Erro ao abrir ou ler o arquivo CSV: " + e.getMessage());
        } 
        catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor numérico no CSV: " + e.getMessage());
        }
    }
}
