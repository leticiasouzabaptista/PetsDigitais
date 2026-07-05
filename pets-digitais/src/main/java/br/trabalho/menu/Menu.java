package br.trabalho.menu;

import java.util.Scanner;

import br.trabalho.service.CriaturaService;
import br.trabalho.util.Leituras;
import br.trabalho.repository.*;
import br.trabalho.model.Criatura;

public class Menu {

    private CriaturaService criaturaService;
    private CriaturaRepository repository;
    private int opcao;

    public Menu(){
        criaturaService = new CriaturaService();
        repository = new CriaturaRepository();

    }

    public Criatura identificaCriatura(){
        System.out.print("Nome do Pet: ");
        String nome = Leituras.leFrase();
        System.out.print("Especie do Pet: ");
        String especie = Leituras.leFrase();
        return repository.getCriatura(nome);
    }

    public void imprimePrimeiroMenu(){
        System.out.println("\n1. Pets\n2. Estaísticas do Sistema\n3. Encerrar Sistema");
    }

    public void imprimeCriaturasMenu(){
        System.out.println("\n1. Criar Pet\n2. Importar Pets\n3. Exportar Pets\n4. Exibir Pets Cadastrados\n5. Remover Pet do Sistema\n6. Exibir Informacoes do Pet\n7. Exibir status completo do Pet\n8. Realizar Atividades com o Pet");
    }

    public void imprimeAtividadesMenu(){
        System.out.println("\n1. Alimentar\n2. Brincar\n3. Dormir\n4. Treinar\n5. Participar de Desafio\n6. Realizar Atividade Especial");
    }

    public void imprimeEstatisticasMenu(){
        System.out.println("\n1. Exibe estatísticas do sistema\n2. Exportar estatísticas do sistema");
    }

    public void criaturasMenu(){

        boolean volta = false;
        while (!volta) {

            this.imprimeCriaturasMenu();
            opcao = Leituras.leInt();

            switch (opcao) {
                case -1:
                    volta = true;
                    return;
                case 1:
                    criaturaService.criaCriatura();
                    break;
                case 2:
                    criaturaService.criaCriatura();
                    break;
                case 3:
                    criaturaService.criaturasCadastradas();
                    break;
                case 4:
                    criaturaService.criaCriatura();
                    break;
                case 5:
                    criaturaService.removeCriatura(this.identificaCriatura());
                    break;
                case 6:
                    criaturaService.exibeInformacoes(this.identificaCriatura());;
                    break;
                case 7:
                    criaturaService.exibeSatus(this.identificaCriatura());
                    break;
                case 8:
                    this.atividadesMenu();
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
                    opcao = Leituras.leInt();
                    break;
                }
            }
        }
    }

    public void atividadesMenu(){

        boolean volta = false;
        while (!volta) {

            this.imprimeCriaturasMenu();
            opcao = Leituras.leInt();

            switch (opcao) {
                case -1:
                    volta = true;
                    return;
                case 1:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                case 2:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                case 3:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                case 4:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                case 5:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                case 6:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
                    opcao = Leituras.leInt();
                    break;
                }
            }
        }
    }

    public void estatisticasMenu(){

        boolean volta = false;
        while (!volta) {

            this.imprimeEstatisticasMenu();
            opcao = Leituras.leInt();

            switch (opcao) {
                case -1:
                    volta = true;
                    return;
                case 1:
                    criaturaService.brincar(null);
                    //repository.exibeEstatisticasSistema();
                    break;
                case 2:
                    criaturaService.brincar(null);
                    //repository.expostarEstatiscicasSistema();
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
                    opcao = Leituras.leInt();
                    break;
                }
            }
        }
    }

    public void executar(){

        while(opcao != 3){

            this.imprimePrimeiroMenu();
            opcao = Leituras.leInt();
            
            switch (opcao) {
                case 1:
                    this.criaturasMenu();
                    break;
                case 2:
                    this.estatisticasMenu();
                    break;
                case 3:
                    System.out.println("\nSistema encerrado com sucesso!");
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
                    opcao = Leituras.leInt();
                    break;
                }      
            }
        }  
    }
}
