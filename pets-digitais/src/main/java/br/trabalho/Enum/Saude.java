package br.trabalho.Enum;

public enum Saude {

    SAUDAVEL,
    ATENCAO,
    DOENTE,
    MORTO;

    public static Saude estadoSaude(int saude){
        if(saude == 0)
            return MORTO;
        else if (saude > 70) 
            return SAUDAVEL;
        else if (saude >= 40)
            return ATENCAO;
        else
            return DOENTE; 
    }

}
