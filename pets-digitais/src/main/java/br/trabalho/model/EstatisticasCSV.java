package br.trabalho.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EstatisticasCSV {

    public static void exportar(Estatisticas estatisticas) throws IOException {

        estatisticas.atualizar();

        File pasta = new File("dadosEstatisticas");
        pasta.mkdirs();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String dataHora = LocalDateTime.now().format(formato);

        String nomeArquivo = "dadosEstatisticas/estatisticas_" + dataHora + ".csv";

        PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));
        writer.println("Estatística,Valor");
        writer.println("Turno," + estatisticas.getTurno());
        writer.println("Total de criaturas," + estatisticas.getTotalCriaturas());
        writer.println("Criaturas vivas," + estatisticas.getTotalCriaturasVivas());
        writer.println("Criaturas mortas," + estatisticas.getTotalCriaturasMortas());
        writer.println("Aquari," + estatisticas.getTotalAquari());
        writer.println("Draconis," + estatisticas.getTotalDraconis());
        writer.println("Draconis Celestial," + estatisticas.getTotalDraconisCelestial());
        writer.println("Lumini," + estatisticas.getTotalLumini());
        writer.println("Fungari," + estatisticas.getTotalFungari());
        writer.println("Mecanis," + estatisticas.getTotalMecanis());

        if (estatisticas.getCriaturaMaiorNivel() != null) {
            writer.println("Criatura de maior nível," +
            estatisticas.getCriaturaMaiorNivel().getNome() +
            " (Nível " +
            estatisticas.getCriaturaMaiorNivel().getNivel() + ")");
        }

        if (estatisticas.getCriaturaMenorNivel() != null) {
            writer.println("Criatura de menor nível," +
            estatisticas.getCriaturaMenorNivel().getNome() +
            " (Nível " +
            estatisticas.getCriaturaMenorNivel().getNivel() + ")");
        }

        writer.println("Itens no estoque," + estatisticas.getTamanhoEstoque());
        writer.close();

        System.out.println("Estatísticas exportadas para com sucesso!");
    }
}
