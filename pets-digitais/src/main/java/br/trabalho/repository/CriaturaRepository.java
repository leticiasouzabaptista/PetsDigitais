package br.trabalho.repository;

import br.trabalho.Exceptions.CriaturaNaoEncontradaException;
import br.trabalho.model.*;
import br.trabalho.util.Leituras;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CriaturaRepository {

    private List <Criatura> criaturasVivas;
    private List <Criatura> criaturasMortas;
    ObjectMapper objectMapper;

    public CriaturaRepository(){
        criaturasVivas = new ArrayList<>();
        criaturasMortas = new ArrayList<>();
        objectMapper = new ObjectMapper();
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

    public void verificaCriaturaExiste(Criatura criatura){
        
        for(Criatura pet: criaturasVivas){
            if(pet.getNome().equals(criatura.getNome()))
                return;
        }

        for(Criatura pet: criaturasMortas){
            if(pet.getNome().equals(criatura.getNome()))
                return;
        }

        throw new CriaturaNaoEncontradaException();
    }

    public void verificaCriaturaMorta(Criatura criatura){
        
        for(Criatura pet: criaturasMortas){
            if(pet.getNome().equals(criatura.getNome()))
                throw new CriaturaNaoEncontradaException();return;
        }
        return;
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

    public void exportarCriaturas() throws IOException{

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String data = agora.format(formatter);

        File pasta = new File("DadosCriaturas");
        pasta.mkdirs();
        File arquivo = new File(pasta, "criaturas_" + data + ".json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(arquivo, criaturasVivas);
        //aqui ta salvando no projeto, mas também posso fazer escolhendo em qua pasta vai ser salva a exportaçaõ jfilechooser.
    }
}
