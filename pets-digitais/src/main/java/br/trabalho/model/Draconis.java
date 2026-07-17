package br.trabalho.model;

public class Draconis extends Criatura implements HE_voador {

    private static int totalDraconis = 0;

    public Draconis(){
        super();
    }

    public Draconis(String nome) {

        super(nome, TipoCriatura.DRACONIS);
        totalDraconis++;
    }

    public Draconis(String nome, TipoCriatura tipoCriatura) {

        super(nome, tipoCriatura);
        totalDraconis++;
    }

    public static int getTotalDraconis(){
        return totalDraconis;
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + "\nNome Único: " + super.getNomeUnico() + "\nEspecie: Draconis" + "\nIdade: " + super.getIdade() + "\nNivel: " + super.getNivel();
    }

    @Override
    public void aplicaDesgasteNatural(){
        super.setEnergiaSoma(-5);
        super.setSaciedadeSoma(-4);
        super.setFelicidadeSoma(-2);

        super.calculaSaude();
    }

    @Override
    public void realizarVoo(){

        System.out.println(super.getNome() + " preparando pra voar...\n");
        System.out.println(super.getNome() + " esta voando sobre o reino!\n");

        super.setFelicidadeSoma(10);
    }

    @Override
    public void usarHabilidadeEspecial(){
        this.realizarVoo();
    }

    @Override
    public void treinar(){
        setExperienciaAtividade(35);
        setEnergiaAtividade(25);
        setSaciedadeAtividade(15);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void explorar(){
        setExperienciaAtividade(20);
        setEnergiaAtividade(15);
        setSaciedadeAtividade(10);
        setFelicidadeAtividade(5);
        System.out.println("Você está brincando!");
        super.setUltimoFoiDescanso(false);
    }

    @Override
    public void descansar(){
        if(!super.getUltimoFoiDescanso()){
            super.setEnergiaAtividade(30);
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
        setExperienciaAtividade(60);
        setEnergiaAtividade(30);
        setSaciedadeAtividade(20);
        setFelicidadeAtividade(10);
        super.setParticipouDesafio(true);
    }

    @Override
    protected void evoluir(){
        setEnergiaSoma(2);
    }

    @Override
    public int recuperarEnergia(){
        return 30;
    }
}
