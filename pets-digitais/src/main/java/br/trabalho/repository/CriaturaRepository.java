package br.trabalho.repository;

import br.trabalho.model.*;
import java.util.Map;
import java.util.HashMap;

public class CriaturaRepository {

    private Map <Integer, Criatura> criaturas;

    public CriaturaRepository(){
        criaturas = new HashMap<>();
    }

    public static void salvaCriatura(Criatura criatura){
        criaturas.put(codigo, criatura);
    }

}
