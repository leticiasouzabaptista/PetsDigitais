package br.trabalho.model;

public class Fungari extends Criatura {

    private static int totalFungari = 0;

    public Fungari(){
        super();
    }

    public Fungari(String nome) {

        super(nome, TipoCriatura.FUNGARI);
        totalFungari++;
    }

    public static int getTotalFungari(){
        return totalFungari;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nNome Único: " + super.getNomeUnico() + "\nEspecie: Draconis" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void usarHabilidadeEspecial(){
        System.out.println("\nEssa criatura não possui Habilidade Especial.");
    }

    @Override
    public void aplicaDesgasteNatural(){
        super.setEnergiaSoma(-3);
        super.setSaciedadeSoma(-2);
        super.setFelicidadeSoma(-2);

        super.calculaSaude();
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
        setExperienciaAtividade(10);
        setEnergiaAtividade(5);
        setSaciedadeAtividade(5);
        setFelicidadeAtividade(5);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void descansar(){
        if(!super.getUltimoFoiDescanso()){
            super.setEnergiaAtividade(20);
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
        setExperienciaAtividade(40);
        setEnergiaAtividade(15);
        setSaciedadeAtividade(15);
        setFelicidadeAtividade(5);
        super.setParticipouDesafio(true);
    }

    @Override
    protected void evoluir(){
        setSaciedadeSoma(2);
    }

    @Override
    public int recuperarEnergia(){
        return 20;
    }
}
