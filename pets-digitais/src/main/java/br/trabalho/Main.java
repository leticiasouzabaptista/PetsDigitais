package br.trabalho;

import br.trabalho.model.Criatura;
import br.trabalho.model.Draconis;
import br.trabalho.service.CriaturaService;

public class Main {
    public static void main(String[] args) {

       CriaturaService teste = new CriaturaService();

       teste.criaCriatura();
    }
}