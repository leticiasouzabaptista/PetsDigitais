package br.trabalho.model;

public class Lumini extends Criatura implements HE_luminescente {

    private static int totalLumini = 0;

    public Lumini(){
        super();
    }

    public Lumini(String nome) {

        super(nome, TipoCriatura.LUMINI);
        totalLumini++;
    }

    public static int getTotalLumini(){
        return totalLumini;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nNome Único: " + super.getNomeUnico() + "\nEspecie: Lumini" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void aplicaDesgasteNatural(){
        super.setEnergiaSoma(-8);
        super.setSaciedadeSoma(-2);
        super.setFelicidadeSoma(-3);

        super.calculaSaude();
    }

    @Override
    public void emitirLuz(){

        System.out.println(super.getNome() + " preparando para emitir luz...\n");
        System.out.println(super.getNome() + " esta iluminando o reino!\n");

        super.setFelicidadeSoma(10);
    }

    @Override
    public void usarHabilidadeEspecial(){
        this.emitirLuz();
    }

    @Override
    public void treinar(){
        setExperienciaAtividade(25);
        setEnergiaAtividade(20);
        setSaciedadeAtividade(10);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void explorar(){
        setExperienciaAtividade(20);
        setEnergiaAtividade(10);
        setSaciedadeAtividade(5);
        setFelicidadeAtividade(10);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void descansar(){
        if(!super.getUltimoFoiDescanso()){
            super.setEnergiaAtividade(40);
            System.out.println("Você está descansando!");
            super.setUltimoFoiDescanso(true);
        }
    }

    @Override
    public void brincar(){
        setFelicidadeAtividade(35);
        setEnergiaAtividade(5);
        setSaciedadeAtividade(5);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void desafio(){
        setExperienciaAtividade(45);
        setEnergiaAtividade(35);
        setSaciedadeAtividade(15);
        setFelicidadeAtividade(15);
        super.setParticipouDesafio(true);
    }

    @Override
    protected void evoluir(){
        setFelicidadeSoma(2);
    }

    @Override
    public int recuperarEnergia(){
        return 40;
    }
}
