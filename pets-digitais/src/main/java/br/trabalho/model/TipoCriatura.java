package br.trabalho.model;

import java.util.List;

public enum TipoCriatura {

    DRACONIS(List.of(TipoAlimento.FRUTAS, TipoAlimento.CARNE, TipoAlimento.BANQUETEREAL)),
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
}
