package br.trabalho.model;

import java.util.List;
import java.util.Map;

import br.trabalho.repository.CriaturaRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class Estoque {

    private Map<TipoAlimento, Integer> estoque;
    private CriaturaRepository repository;

    public Estoque(){
        estoque = new HashMap();

        estoque.put(TipoAlimento.FRUTAS, 0);
        estoque.put(TipoAlimento.CARNE, 0);
        estoque.put(TipoAlimento.NECTARLUMINOSO, 0);
        estoque.put(TipoAlimento.FOTONS, 0);
        estoque.put(TipoAlimento.COGUMELOS, 0);
        estoque.put(TipoAlimento.CRISTAISENERGETICOS, 0);
        estoque.put(TipoAlimento.BANQUETEREAL, 0);
    }

    public int getQuantidadeEstoque(){
        return estoque.size();
        //se tiver vazio
    }

    public void imprimeEstoque(){
        System.out.println("\nFrutas: " + estoque.get(TipoAlimento.FRUTAS) + 
        "\nCarne " + estoque.get(TipoAlimento.CARNE) + 
        "\nFotons: " + estoque.get(TipoAlimento.FOTONS) + 
        "\nNectar Luminoso: " + estoque.get(TipoAlimento.NECTARLUMINOSO) + 
        "\nCogumelos: " + estoque.get(TipoAlimento.COGUMELOS) +
        "\nCristais Energéticos: " + estoque.get(TipoAlimento.CRISTAISENERGETICOS) + 
        "\nBanquete Real: " + estoque.get(TipoAlimento.BANQUETEREAL));
    }

    public boolean existeNoEstoque(TipoAlimento alimento){
        if(estoque.get(alimento) > 0)
            return true;
        return false;
    }

    public void reabastece() {

        for (TipoCriatura criatura: TipoCriatura.values()) {

            int minimo = repository.quantidadeCriaturas(criatura) * 3;

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

        for(TipoAlimento alimento : alimentos){

            estoque.put(
                alimento,
                estoque.get(alimento) + quantidadePorAlimento
            );
        }
    }
}
