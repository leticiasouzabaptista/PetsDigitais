package br.trabalho.menu;

import br.trabalho.service.CriaturaService;
import br.trabalho.util.Formatacao;
import br.trabalho.util.Leituras;
import br.trabalho.model.Criatura;
import br.trabalho.model.Estatisticas;
import br.trabalho.model.Mundo;
import br.trabalho.model.TipoAlimento;

public class Menu {

    private Mundo mundo;
    private CriaturaService criaturaService;
    private Estatisticas estatisticas;
    private int opcao;

    public Menu() {
        this.mundo = new Mundo();
        this.criaturaService = new CriaturaService(mundo);
        this.estatisticas = new Estatisticas(mundo);
    }


    public Criatura identificaCriatura(){
        System.out.print("\nNome único do Pet: ");
        String nomeUnico = Leituras.leNomeUnico();
        return mundo.getCriaturaRepository().getCriatura(nomeUnico);
    }

    public void imprimePrimeiroMenu(){
        System.out.println("\n1. Pets\n2. Estaísticas do Sistema\n3. Encerrar Sistema");
    }

    public void imprimeCriaturasMenu(){
        System.out.println("\n1. Criar Pet\n2. Importar Pets\n3. Exportar Pets\n4. Exibir Pets Cadastrados\n5. Remover Pet do Sistema\n6. Exibir Informacoes do Pet\n7. Exibir Status completo do Pet\n8. Realizar Atividades com o Pet");
    }

    public void imprimeAtividadesMenu(){
        
        System.out.println("\n1. Alimentar\n2. Brincar\n3. Dormir\n4. Treinar\n5. Participar de Desafio\n6. Realizar Atividade Especial");
    }

    public void imprimeEstatisticasMenu(){
        
        System.out.println("\n╔══════════════════════════════╗");
        Formatacao.imprimirCentralizado("Estatísticas");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("\n1. Exibe estatísticas do sistema\n2. Exportar estatísticas do sistema");
    }

    public void imprimeAlimentosMenu(){
        System.out.println("\n1. Frutas\n2. Carne\n3. Fótons\n4. Néctar Luminoso\n5. Cogmuelos\n6. Cristais Energéticos\n7. Banquete Real");
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
                    criaturaService.importarCriaturas();
                    break;
                case 3:
                    criaturaService.exportarCriaturas();
                    break;
                case 4:
                    criaturaService.criaturasCadastradas();
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
                    break;
                }
            }
        }
    }

    public void atividadesMenu(){

        boolean volta = false;
        while (!volta) {

            this.imprimeAtividadesMenu();
            opcao = Leituras.leInt();

            switch (opcao) {
                case -1:
                    volta = true;
                    return;
                case 1:
                    this.alimentosMenu();
                    break;
                case 2:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                case 3:
                    criaturaService.dormir(this.identificaCriatura());
                    break;
                case 4:
                    criaturaService.treinar(this.identificaCriatura());
                    break;
                case 5:
                    criaturaService.desafio(this.identificaCriatura());
                    break;
                case 6:
                    criaturaService.brincar(this.identificaCriatura());
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
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
                    estatisticas.imprimeEstatisticas();
                    break;
                case 2:
                    criaturaService.brincar(null);
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
                    break;
                }
            }
        }
    }

    public void alimentosMenu(){

        boolean volta = false;
        while (!volta) {

            this.imprimeAlimentosMenu();
            opcao = Leituras.leInt();

            switch (opcao) {
                case -1:
                    volta = true;
                    return;
                case 1:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.FRUTAS);
                    break;
                case 2:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.CARNE);
                    break;
                case 3:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.FOTONS);
                    break;
                case 4:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.NECTARLUMINOSO);
                    break;
                case 5:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.COGUMELOS);
                    break;
                case 6:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.CRISTAISENERGETICOS);
                    break;
                case 7:
                    criaturaService.alimentar(this.identificaCriatura(), TipoAlimento.BANQUETEREAL);
                    break;
                default:{
                    System.out.print("\nOpcão não válida, tente novamente: ");
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
                    break;
                }      
            }
        }  
    }
}
