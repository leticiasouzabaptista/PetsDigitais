package br.trabalho.model;

import br.trabalho.Enum.Energia;

public class Aquari extends Criatura {

    private static int totalAquari = 0;

    public Aquari(String nome) {

        super(nome);
        totalAquari++;
    }

    public static int getTotalAquari() {
        return totalAquari;
    }









    @Override
    public DadosTreino getDadosTreino() {
        return new DadosTreino(15, 10, 25);
    }

    @Override
    public DadosExplorar getDadosExplorar() {
        return new DadosExplorar(15, 10, 10, 5);
    }

    @Override
    public DadosBrincar getDadosBrincar() {
        return new DadosBrincar(20, 10, 5);
    }

    @Override
    public boolean podeComer(TipoAlimento alimento) {

        return alimento == TipoAlimento.CARNE
                || alimento == TipoAlimento.FRUTAS
                || alimento == TipoAlimento.BANQUETEREAL;
    }
}
