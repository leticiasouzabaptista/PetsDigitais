package br.trabalho.model;

public enum Saude {
    SAUDAVEL,
    ATENCAO,
    DOENTE,
    MORTA;

    public static Saude estadoSaude(int saude) {
        if (saude == 0)
            return MORTA;

        if (saude > 70)
            return SAUDAVEL;

        if (saude > 40)
            return ATENCAO;

        return DOENTE;
    }
}
