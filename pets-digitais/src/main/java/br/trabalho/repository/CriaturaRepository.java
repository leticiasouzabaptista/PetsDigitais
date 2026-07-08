package br.trabalho.repository;

import br.trabalho.model.*;
import br.trabalho.util.Leituras;

import java.util.List;
import java.util.ArrayList;


public class CriaturaRepository {

    private List <Criatura> criaturasVivas;
    private List <Criatura> criaturasMortas;

    public CriaturaRepository(){
        criaturasVivas = new ArrayList<>();
        criaturasMortas = new ArrayList<>();
    }

    private void atualizaListas(){

        for(Criatura criatura: criaturasVivas){
            if(criatura.getSaude() <= 0){
                criaturasMortas.add(criatura);
                criaturasVivas.remove(criatura);
            }
        }
    }

    public int quantidadeCriaturas(TipoCriatura especie) {

        int contador = 0;

        for (Criatura criatura : criaturasVivas) {

            if (criatura.getTipoCriatura() == especie)
                contador++;
        }
        return contador;
    }

    public void salvaCriatura(Criatura criatura){
        criaturasVivas.add(criatura);
    }

    public Criatura getCriatura(String nome){

        for(Criatura criatura: criaturasVivas){
            if(criatura.getNome().equals(nome))
                return criatura;
        }

        return null;
    }

    public boolean criaturaExiste(Criatura criatura){
        
        for(Criatura pet: criaturasVivas){
            if(criatura.getNome().equals(criatura.getNome()))
                return true;
        }

        return false;
    }

    public List<Criatura> getCriaturas(){
        return new ArrayList<>(criaturasVivas);
    }

    public void removeCriatura(Criatura criatura){
        //lembrar de colocar a especie aqui também
        if(criaturasVivas.removeIf(pet -> pet.getNome() == criatura.getNome()))
            System.out.println("Pet " + criatura.getNome() + " removida do Reino.");
        else
            System.out.println("Criatura não encontrada no reino.");
    }


    
}
