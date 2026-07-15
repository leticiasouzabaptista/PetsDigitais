package br.trabalho.model;

import br.trabalho.Enum.*;
import br.trabalho.util.Formatacao;

public abstract class Criatura {

    private String nome;
    private int idade;
    private int nivel;
    private int experiencia;
    private int energia;
    private int saciedade;
    private int felicidade;
    private int saude;
    private TipoCriatura tipoCriatura;
    private boolean ultimoFoiDescanso;
    private boolean participouDesafio;


    public abstract int getTotalEspecie();
    public abstract void atualizaTurno();
    public abstract DadosTreino getDadosTreino();
    public abstract DadosExplorar getDadosExplorar();
    public abstract DadosBrincar getDadosBrincar();
    public abstract DadosDesafio getDadosDesafio();
    public abstract int recuperarEnergia();
    public abstract void usarHabilidadeEspecial();
    //public abstract boolean podeComer(TipoAlimento tipo);

    public Criatura(String nome, TipoCriatura tipoCriatura) {

        this.nome = nome;
        this.idade = 0;
        this.nivel = 0;
        this.experiencia = 0;
        this.energia = 99;
        this.saciedade = 99;
        this.felicidade = 99;
        this.saude = 99;
        this.tipoCriatura = tipoCriatura;
        this.ultimoFoiDescanso = false;
        this.participouDesafio = false;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nIdade: " + idade + "\nNivel: " + nivel;
    }

    public void exibeInformacoes() {

        System.out.println("╔══════════════════════════════╗");
        Formatacao.imprimirCentralizado(nome, 31);
        System.out.println("╠══════════════════════════════╣");
        System.out.printf("║ Idade: %-21d ║%n", idade);
        System.out.printf("║ Nível: %-21d ║%n", nivel);
        System.out.printf("║ Experiência: %-15d ║%n", experiencia);
        System.out.printf("║ Saciedade: %-17d ║%n", saciedade);
        System.out.printf("║ Felicidade: %-16d ║%n", felicidade);
        System.out.printf("║ Saúde: %-21d ║%n", saude);
        System.out.println("╚══════════════════════════════╝");

    }

    public void exibeEstadoAtual() {

        System.out.println("Saúde: " + Saude.estadoSaude(saude));
        System.out.println("Saciedade: " + Saciedade.estadoSaciedade(saciedade));
        System.out.println("Felicidade: " + Felicidade.estadoFelicidade(felicidade));
        System.out.println("Energia: " + Energia.estadoEnergia(energia));

        // usar aquelas barrinhas aqui.
    }

    public void calculaSaude(){
        saude = (energia + saciedade + felicidade)/3;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public int getNivel(){
        return nivel;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public int getEnergia(){
        return energia;
    }

    public int getSaciedade(){
        return saciedade;
    }

    public int getFelicidade(){
        return felicidade;
    }

    public int getSaude(){
        return saude;
    }

    public TipoCriatura getTipoCriatura(){
        return tipoCriatura;
    }

    private void evoluir(){

        
    }

    public void setExperiencia(int modificador){
        this.experiencia += modificador;

        if(this.experiencia >= 100){
            this.nivel++;
            this.evoluir();
            this.ultimoFoiDescanso = false;
            this.experiencia -= this.experiencia - 99;
        }     
    }

    public void setEnergia(int modificador){
        this.experiencia += modificador;
        this.calculaSaude();
    }

    public void setSaciedade(int modificador){
        this.experiencia += modificador;
        this.calculaSaude();
    }

    public void setFelicidade(int modificador){
        this.experiencia += modificador;
        this.calculaSaude();
    }

    public void setSaude(int modificador){
        this.saude += modificador;
    }

    public void setExperienciaAtividade(int modificador){
        this.experiencia += (modificador - nivel/10);

        if(this.experiencia >= 100){
            this.nivel++;
            this.experiencia -= this.experiencia - 99;
            this.evoluir();
            this.participouDesafio = false;
        }
    }

    public void setEnergiaAtividade(int modificador){
        this.energia -= (modificador + nivel/10);

        this.calculaSaude();

        if(this.experiencia == 0)
            this.saude = 0;
    }

    public void setSaciedadeAtividade(int modificador){
        this.saciedade -= (modificador + nivel/10);

        this.calculaSaude();

        if(this.saciedade == 0)
            this.saude = 0;
    }

    public void setFelicidadeAtividade(int modificador){
        this.felicidade -= (modificador + nivel/10);

        this.calculaSaude();

        if(this.felicidade == 0)
            this.saude = 0;
    }

    public void setUltimoFoiDescanso(boolean acao){
        this.ultimoFoiDescanso = acao;
    }

    public boolean getUltimoFoiDescanso(){
        return ultimoFoiDescanso;
    }

    public boolean verificaMorte(){
        if(this.saude <= 0){
            this.saude = 0;
            return true;
        }
        return false;
    }

    public void alimentar(TipoAlimento alimento){
        if(saude > 0 && saciedade < 90){
            this.setSaciedadeAtividade(alimento.getModificadorSaciedade());
        }
        this.ultimoFoiDescanso = false;
    }

    public boolean descansar(){

        if(saude > 0 && energia < 90 ){
            if(!ultimoFoiDescanso){
                setEnergia(30);
                System.out.println("Você está descansando!");
                setUltimoFoiDescanso(true);
                return true;
            }
        }
        return false;
    }

    public boolean treinar(){

        if(saude > 40 && energia >= 20 && saciedade >= 20){
            setEnergiaAtividade(getDadosTreino().energia());
            setSaciedadeAtividade(getDadosTreino().saciedade());
            setExperienciaAtividade(getDadosTreino().experiencia());
            System.out.println("Você está treinando!");
            this.ultimoFoiDescanso = false;
            return true;
        }
       
        return false;
    }

    public boolean explorar(){

        if(saude > 20 && energia >= 15 && saciedade >= 15){

            setEnergiaAtividade(getDadosTreino().energia());
            setSaciedadeAtividade(getDadosTreino().saciedade());
            setExperienciaAtividade(getDadosTreino().experiencia());
            System.out.println("Você está explorando o reino!");
            this.ultimoFoiDescanso = false;
            return true;
        }
        return false;
    }

    public boolean brincar(){
        
        if(saude > 20 && energia >= 50 && saciedade >= 50){
            setEnergiaAtividade(getDadosBrincar().energia());
            setSaciedadeAtividade(getDadosBrincar().saciedade());
            setExperienciaAtividade(getDadosBrincar().felicidade());
            System.out.println("Você está brincando!");
            this.ultimoFoiDescanso = false;
            return true;
        }
        return false;
    }

    public boolean desafio(){
        if(this.saude > 40 && this.nivel >= 5 && this.energia >= 50 && this.saciedade >= 50){
            if(this.nivel % 15 == 0){
                if(!this.participouDesafio){
                    System.out.println("\nVocê concluiu um desafio!");
                    this.setExperiencia(getDadosDesafio().experiencia());
                    this.setEnergia(getDadosDesafio().energia());
                    this.setSaciedade(getDadosDesafio().saciedade());
                    this.setFelicidade(getDadosDesafio().felicidade());
                    this.participouDesafio = true;
                    return true;
                }
            }
        }
        return false; 
    }


    




















































/* public abstract boolean treinar();
    public abstract boolean explorar();
    public abstract boolean brincar();
 */





    
    /* public abstract DadosTreino getDadosTreino();
    public abstract DadosExplorar getDadosExplorar();
    public abstract DadosBrincar getDadosBrincar();
    public abstract boolean podeComer(TipoAlimento tipo);
    //public abstract int dadosDescansar();
    //public abstract int dadosDesafios();
    //public abstract int dadosEvoluir();

    public void treinar(){
        if(saude > 40 && energia >= 20 && saciedade >= 20){
            setEnergia(getDadosTreino().energia());
            setSaciedade(getDadosTreino().saciedade());
            setExperiencia(getDadosTreino().experiencia());
        }
        else
            System.out.println("Você não está disposto para brincar. Tente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
    }

    public void explorar(){
        if(saude > 20 && energia >= 15 && saciedade >= 15){
            setEnergia(getDadosTreino().energia());
            setSaciedade(getDadosTreino().saciedade());
            setExperiencia(getDadosTreino().experiencia());
        }
        else
            System.out.println("Você não está disposto para brincar. Tente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
    }

    public void brincar(){
        if(saude > 20 && energia >= 50 && saciedade >= 50){
            setEnergia(getDadosBrincar().energia());
            setSaciedade(getDadosBrincar().saciedade());
            setExperiencia(getDadosBrincar().felicidade());

            System.out.println("Você está brincando!");
        }
        else
            System.out.println("Você não está disposto para brincar. Tente novamente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
    }

    /*public void alimentar(TipoAlimento alimento){
        if(saude > 0 && saciedade < 90){
            if(podeComer(alimento)){
                if()
            }
        }
    }

    public void descansar(){
        if(saude > 0 && energia < 90){
            setEnergia(getDadosTreino().energia());
            setSaciedade(getDadosTreino().saciedade());
            setExperiencia(getDadosTreino().experiencia());
        }
        else
            System.out.println("Você não está disposto para brincar. Tente..."); //tentar criar uma execao de erro e ver o que esta abixo do esperado e dar uma solução. lembrar de adicionar nas outras atividades.
    } */
}
