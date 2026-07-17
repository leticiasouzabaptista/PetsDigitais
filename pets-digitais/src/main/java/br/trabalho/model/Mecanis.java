package br.trabalho.model;

public class Mecanis extends Criatura implements HE_mecanico {

    private static int totalMecanis = 0;

    public Mecanis(){
        super();
    }

    public Mecanis (String nome) {

        super(nome, TipoCriatura.MECANIS);
        totalMecanis++;
    }

    public static int getTotalMecanis(){
        return totalMecanis;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nNome Único: " + super.getNomeUnico() + "\nEspecie: Mecanis" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void aplicaDesgasteNatural(){
        super.setEnergiaSoma(-2);
        super.setSaciedadeSoma(-5);
        super.setFelicidadeSoma(-1);

        super.calculaSaude();
    }

    @Override
    public void realizarManutencao(){

        System.out.println(super.getNome() + " preparando cura...\n");
        System.out.println(super.getNome() + " auementou sua saúde!\n");

        super.setSaudeSoma(10);
    }

    @Override
    public void usarHabilidadeEspecial(){
        this.realizarManutencao();
    }

    @Override
    public void treinar(){
        setExperienciaAtividade(40);
        setEnergiaAtividade(15);
        setSaciedadeAtividade(20);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void explorar(){
        setExperienciaAtividade(25);
        setEnergiaAtividade(10);
        setSaciedadeAtividade(15);
        setFelicidadeAtividade(5);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void descansar(){
        if(!super.getUltimoFoiDescanso()){
            super.setEnergiaAtividade(15);
            System.out.println("Você está descansando!");
            super.setUltimoFoiDescanso(true);
        }
    }

    @Override
    public void brincar(){
        setFelicidadeAtividade(10);
        setEnergiaAtividade(5);
        setSaciedadeAtividade(10);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void desafio(){
        setExperienciaAtividade(50);
        setEnergiaAtividade(20);
        setSaciedadeAtividade(25);
        setFelicidadeAtividade(10);
        super.setParticipouDesafio(true);
    }

    @Override
    protected void evoluir(){
        setEnergiaSoma(3);
    }

    @Override
    public int recuperarEnergia(){
        return 15;
    }
}
