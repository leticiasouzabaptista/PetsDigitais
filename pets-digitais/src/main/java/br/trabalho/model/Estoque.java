package br.trabalho.model;

import java.util.List;
import java.util.ArrayList;

public class Estoque {

    private List<TipoAlimento> estoqueAquari;
    private List<TipoAlimento> estoqueDraconis;
    private List<TipoAlimento> estoqueDraconisCelestial;
    private List<TipoAlimento> estoqueFungari;
    private List<TipoAlimento> estoqueLumini;
    private List<TipoAlimento> estoqueMecanis;
    private int aquariEstoqueMinimo;
    private int draconisEstoqueMinimo;
    private int draconisCelestialEstoqueMinimo;
    private int fungariEstoqueMinimo;
    private int luminiEstoqueMinimo;
    private int mecanisEstoqueMinimo;

    public Estoque(){
        estoqueAquari = new ArrayList<>();
        estoqueDraconis = new ArrayList<>();
        estoqueDraconisCelestial = new ArrayList<>();
        estoqueFungari = new ArrayList<>();
        estoqueLumini = new ArrayList<>();
        estoqueMecanis = new ArrayList<>();

        //adicionar alguns alimentos em cada lista pra iniciar
    }

    public void aquariEstoqueMinimo(){
        aquariEstoqueMinimo = Aquari.getTotalAquari() * 3;
    }

    public void draconisEstoqueMinimo(){
        draconisEstoqueMinimo = Draconis.getTotalDraconis() * 3;
    }

    public void draconisCelestialEstoqueMinimo(){
        draconisCelestialEstoqueMinimo = DraconisCelestial.getTotalDraconisCelestial() * 3;
    }

    public void FungariEstoqueMinimo(){
        fungariEstoqueMinimo = Fungari.getTotalFungari() * 3;
    }

    public void LuminiEstoqueMinimo(){
        luminiEstoqueMinimo = Lumini.getTotalLumini() * 3;
    }

    public void MecanisEstoqueMinimo(){
        mecanisEstoqueMinimo = Mecanis.getTotalMecanis() * 3;
    }

    public int quantidadeDisponivel(TipoCriatura criatura){

        switch (criatura) {
            case AQUARI: 
                return estoqueAquari.size();
            case DRACONIS: 
                return estoqueDraconis.size();
            case DRACONISCELESTIAL: 
                return estoqueDraconisCelestial.size();
            case FUNGARI: 
                return estoqueFungari.size();
            case LUMINI: 
                return estoqueLumini.size();
            case MECANIS: 
                return estoqueMecanis.size();
        
            default:
                return 0;
        }
    }

    public void reabasteceAquari(){

        for(int i = 0; i<4; i++){
            estoqueAquari.add(TipoAlimento.NECTARLUMINOSO);
        }

        for(int i = 0; i<4; i++){
            estoqueAquari.add(TipoAlimento.CRISTAISENERGETICOS);
        }

        for(int i = 0; i<2; i++){
            estoqueAquari.add(TipoAlimento.BANQUETEREAL);
        }
    }

    public void reabasteceDraconis(){

        
        for(int i = 0; i<4; i++){
            estoqueDraconis.add(TipoAlimento.FRUTAS);
        }

        
        for(int i = 0; i<4; i++){
            estoqueDraconis.add(TipoAlimento.CARNE);
        }

        
        for(int i = 0; i<2; i++){
            estoqueDraconis.add(TipoAlimento.BANQUETEREAL);
        }
    }

    public void reabasteceDraconisCelestial(){

        for(int i = 0; i<4; i++){
            estoqueDraconisCelestial.add(TipoAlimento.CARNE);
        }

        for(int i = 0; i<4; i++){
            estoqueDraconisCelestial.add(TipoAlimento.FOTONS);
        }
        
        for(int i = 0; i<2; i++){
            estoqueDraconisCelestial.add(TipoAlimento.BANQUETEREAL);
        }
    }

    public void reabasteceFungari(){

        for(int i = 0; i<4; i++){
            estoqueFungari.add(TipoAlimento.FRUTAS);
        }

        for(int i = 0; i<4; i++){
            estoqueFungari.add(TipoAlimento.COGUMELOS);
        }

        for(int i = 0; i<2; i++){
            estoqueFungari.add(TipoAlimento.BANQUETEREAL);
        }
    }

    public void reabasteceLumini(){

        for(int i = 0; i<4; i++){
            estoqueLumini.add(TipoAlimento.FOTONS);
        }

        for(int i = 0; i<4; i++){
            estoqueLumini.add(TipoAlimento.NECTARLUMINOSO);
        }

        for(int i = 0; i<2; i++){
            estoqueLumini.add(TipoAlimento.BANQUETEREAL);
        }
    }

    public void reabasteceMecanis(){

        for(int i = 0; i<4; i++){
            estoqueMecanis.add(TipoAlimento.COGUMELOS);
        }

        for(int i = 0; i<4; i++){
            estoqueMecanis.add(TipoAlimento.CRISTAISENERGETICOS);
        }
        
        for(int i = 0; i<2; i++){
            estoqueMecanis.add(TipoAlimento.BANQUETEREAL);
        }
    }
    
}
