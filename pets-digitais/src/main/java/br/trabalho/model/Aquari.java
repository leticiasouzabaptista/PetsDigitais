package br.trabalho.model;

public class Aquari extends Criatura implements HE_aquatico {

    private static int totalAquari = 0;

    public Aquari(){
        super();
    }

    public Aquari(String nome) {

        super(nome, TipoCriatura.AQUARI);
        totalAquari++;
    }

    public static int getTotalAquari() {
        return totalAquari;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nNome Único: " + super.getNomeUnico() + "\nEspecie: Aquaris" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void aplicaDesgasteNatural(){
        super.setEnergiaSoma(-4);
        super.setSaciedadeSoma(-3);
        super.setFelicidadeSoma(-2);

        super.calculaSaude();
    }

    @Override
    public void mergulhar(){

        System.out.println(super.getNome() + " preparando para nadar...\n");
        System.out.println(super.getNome() + " esta mergulhando sobre os mares do reino!\n");

        super.setFelicidadeSoma(10);
    }

    @Override
    public void usarHabilidadeEspecial(){
        this.mergulhar();
    }

    @Override
    public void treinar(){
        setExperienciaAtividade(25);
        setEnergiaAtividade(15);
        setSaciedadeAtividade(10);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void explorar(){
        setExperienciaAtividade(20);
        setEnergiaAtividade(10);
        setSaciedadeAtividade(10);
        setFelicidadeAtividade(5);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void descansar(){
        if(!super.getUltimoFoiDescanso()){
            super.setEnergiaAtividade(25);
            System.out.println("Você está descansando!");
            super.setUltimoFoiDescanso(true);
        }
    }

    @Override
    public void brincar(){
        setFelicidadeAtividade(20);
        setEnergiaAtividade(10);
        setSaciedadeAtividade(5);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void desafio(){
        setExperienciaAtividade(45);
        setEnergiaAtividade(20);
        setSaciedadeAtividade(20);
        setFelicidadeAtividade(10);
        super.setParticipouDesafio(true);
    }

    @Override
    protected void evoluir(){
        setEnergiaSoma(1);
        setFelicidade(1);
    }

    @Override
    public int recuperarEnergia(){
        return 25;
    }
}
