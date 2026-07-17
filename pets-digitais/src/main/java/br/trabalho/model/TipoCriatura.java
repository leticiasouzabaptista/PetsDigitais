package br.trabalho.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoCriatura {

   // 1. Passamos o nome exato do JSON como String antes da lista de alimentos
    DRACONIS("Draconis", List.of(TipoAlimento.FRUTAS, TipoAlimento.CARNE, TipoAlimento.BANQUETEREAL)),
    DRACONISCELESTIAL("DraconisCelestial", List.of(TipoAlimento.CARNE, TipoAlimento.FOTONS, TipoAlimento.BANQUETEREAL)),
    AQUARI("Aquari", List.of(TipoAlimento.NECTARLUMINOSO, TipoAlimento.CRISTAISENERGETICOS, TipoAlimento.BANQUETEREAL)),
    FUNGARI("Fungari", List.of(TipoAlimento.FRUTAS, TipoAlimento.COGUMELOS, TipoAlimento.BANQUETEREAL)),
    MECANIS("Mecanis", List.of(TipoAlimento.COGUMELOS, TipoAlimento.CRISTAISENERGETICOS, TipoAlimento.BANQUETEREAL)),
    LUMINI("Lumini", List.of(TipoAlimento.FOTONS, TipoAlimento.NECTARLUMINOSO, TipoAlimento.BANQUETEREAL));

    private final String nomeJson; // <-- Guardará o nome do JSON
    private final List<TipoAlimento> alimentosPermitidos;

    // 2. Ajustamos o construtor para receber a String e a Lista
    TipoCriatura(String nomeJson, List<TipoAlimento> alimentosPermitidos) {
        this.nomeJson = nomeJson;
        this.alimentosPermitidos = alimentosPermitidos;
    }

    @JsonValue // 3. Diz ao Jackson para exportar para o JSON usando este formato textual
    public String getNomeJson() {
        return nomeJson;
    }

    @JsonCreator // 4. Diz ao Jackson como converter a String do JSON para este Enum ao importar
    public static TipoCriatura fromString(String valor) {
        for (TipoCriatura tipo : TipoCriatura.values()) {
            if (tipo.nomeJson.equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Espécie desconhecida: " + valor);
    }

    // Seus métodos originais continuam iguaizinhos
    public boolean podeComer(TipoAlimento alimento) {
        return alimentosPermitidos.contains(alimento);
    }

    public List<TipoAlimento> getAlimentosPermitidos(){
        return alimentosPermitidos;
    }
   
   
   
   
    /*  DRACONIS(List.of(TipoAlimento.FRUTAS, TipoAlimento.CARNE, TipoAlimento.BANQUETEREAL)),
    DRACONISCELESTIAL(List.of(TipoAlimento.CARNE, TipoAlimento.FOTONS, TipoAlimento.BANQUETEREAL)),
    AQUARI(List.of(TipoAlimento.NECTARLUMINOSO, TipoAlimento.CRISTAISENERGETICOS, TipoAlimento.BANQUETEREAL)),
    FUNGARI(List.of(TipoAlimento.FRUTAS, TipoAlimento.COGUMELOS, TipoAlimento.BANQUETEREAL)),
    MECANIS(List.of(TipoAlimento.COGUMELOS, TipoAlimento.CRISTAISENERGETICOS, TipoAlimento.BANQUETEREAL)),
    LUMINI(List.of(TipoAlimento.FOTONS, TipoAlimento.NECTARLUMINOSO, TipoAlimento.BANQUETEREAL));

    private final List<TipoAlimento> alimentosPermitidos;

    TipoCriatura(List<TipoAlimento> alimentosPermitidos) {
        this.alimentosPermitidos = alimentosPermitidos;
    }

    public boolean podeComer(TipoAlimento alimento) {
        return alimentosPermitidos.contains(alimento);
    }

    public List<TipoAlimento> getAlimentosPermitidos(){
        return alimentosPermitidos;
    } */
}
