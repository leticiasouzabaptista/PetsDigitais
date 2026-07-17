package br.trabalho.repository;

import br.trabalho.Exceptions.CriaturaNaoEncontradaException;
import br.trabalho.model.*;
import java.util.List;
import javax.swing.JFileChooser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


public class CriaturaRepository {

    private Map <String, Criatura> criaturasVivas;
    private Map <String, Criatura> criaturasMortas;
    ObjectMapper objectMapper;

    public CriaturaRepository(){
        criaturasVivas = new HashMap<>();
        criaturasMortas = new HashMap<>();
        objectMapper = new ObjectMapper();
    }

    private void atualizaListas(){

        Iterator<Criatura> iterator = criaturasVivas.values().iterator();

        while (iterator.hasNext()) {
            Criatura criatura = iterator.next();

            if (criatura.getSaude() <= 0) {
                criaturasMortas.put(criatura.getNomeUnico(), criatura);
                iterator.remove(); 
            }
        }
    }

    public int quantidadeCriaturasVivas(TipoCriatura especie) {

        int contador = 0;
        for (Criatura criatura : criaturasVivas.values()) {
            if (criatura.getTipoCriatura() != null) {
                String nomeEspecieCriatura = criatura.getTipoCriatura().name();
                
                if (nomeEspecieCriatura.equalsIgnoreCase(especie.name())) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int totalCriaturasMortas(){
        atualizaListas();
        return criaturasMortas.size();
    }

    public int totalCriaturasVivas(){
        atualizaListas();
        return criaturasVivas.size();
    }

    public int totalCriaturas() {
        return criaturasMortas.size() + criaturasVivas.size();
    }

    public void salvaCriatura(Criatura criatura){
        criaturasVivas.put(criatura.getNomeUnico(), criatura);
        atualizaListas();
    }

   
    public Criatura getCriatura(String nomeUnico){

        if(criaturasVivas.containsKey(nomeUnico))
            return criaturasVivas.get(nomeUnico);

        if(criaturasMortas.containsKey(nomeUnico))
            return criaturasMortas.get(nomeUnico);

        throw new CriaturaNaoEncontradaException();
    }

    public void verificaCriaturaExiste(Criatura criatura){
        
        if(criaturasVivas.containsKey(criatura.getNomeUnico())|| criaturasMortas.containsKey(criatura.getNomeUnico())){
            return;
        }

        throw new CriaturaNaoEncontradaException();
    }

    public void verificaCriaturaMorta(Criatura criatura){
        if(criaturasMortas.containsKey(criatura.gerarNomeUnico()))
            return;// arrumar esse e o de cim, não é legal deixar só return
    }

    public Map<String, Criatura> getCriaturas(){
        return new HashMap<>(criaturasVivas);
    }

    public void removeCriatura(Criatura criatura){
        if(criaturasVivas.values().removeIf(pet -> pet.getNome() == criatura.getNome()))
            System.out.println("Pet " + criatura.getNome() + " removida do Reino.");
        else
            throw new CriaturaNaoEncontradaException();
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

    public void importarCriaturas() throws IOException{
        JFileChooser chooser = new JFileChooser();
        int opcao = chooser.showOpenDialog(null);

        if (opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = chooser.getSelectedFile();
            List<Criatura> criaturasImportadas = objectMapper.readValue(arquivo, new TypeReference<List<Criatura>>(){});

            for (Criatura criatura : criaturasImportadas) {
                if (criatura.getNomeUnico() == null) 
                    criatura.setNomeUnico(criatura.gerarNomeUnico());
                criatura.calculaSaude(); 
                criaturasVivas.put(criatura.getNomeUnico(), criatura);
            }
        }
    }
}
