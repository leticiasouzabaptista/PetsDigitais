package br.trabalho.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import br.trabalho.util.Formatacao;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "especie",
        visible = true) 
@JsonSubTypes({
        @JsonSubTypes.Type(value = Aquari.class, name = "Aquari"),
        @JsonSubTypes.Type(value = Draconis.class, name = "Draconis"),
        @JsonSubTypes.Type(value = Fungari.class, name = "Fungari"),
        @JsonSubTypes.Type(value = DraconisCelestial.class, name = "DraconisCelestial"),
        @JsonSubTypes.Type(value = Lumini.class, name = "Lumini"),
        @JsonSubTypes.Type(value = Mecanis.class, name = "Mecanis")})
@JsonIgnoreProperties(ignoreUnknown = true)

public abstract class Criatura {

    private String nome;
    private int idade;
    private int nivel;
    private int experiencia;
    private int energia;
    private int saciedade;
    private int felicidade;
    private int saude;
    private TipoCriatura especie;

    @JsonIgnore
    private boolean ultimoFoiDescanso;
    @JsonIgnore
    private boolean participouDesafio;
    @JsonIgnore
    private String nomeUnico = null;

    public abstract void aplicaDesgasteNatural();
    public abstract int recuperarEnergia();
    public abstract void brincar();
    public abstract void treinar();
    public abstract void explorar();
    public abstract void descansar();
    public abstract void desafio();
    protected abstract void evoluir();
    public abstract void usarHabilidadeEspecial();
    public Criatura(){}

    public Criatura(String nome, TipoCriatura especie) {

        this.nome = nome;
        this.idade = 0;
        this.nivel = 0;
        this.experiencia = 0;
        this.energia = 99;
        this.saciedade = 99;
        this.felicidade = 99;
        this.saude = 99;
        this.especie = especie;
        this.ultimoFoiDescanso = false;
        this.participouDesafio = false;
        this.nomeUnico = this.gerarNomeUnico();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Criatura))
            return false;

        Criatura outra = (Criatura) obj;

        return idade == outra.getIdade() &&
            nivel == outra.getNivel() &&
            experiencia == outra.getExperiencia() &&
            energia == outra.getEnergia() &&
            saciedade == outra.getSaciedade() &&
            felicidade == outra.getFelicidade() &&
            saude == outra.getSaude();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            nome,
            idade,
            nivel,
            experiencia,
            energia,
            saciedade,
            felicidade,
            saude,
            especie);
    }

    public String gerarNomeUnico(){

        Random random = new Random();
        Set<String> nomesGerados = new HashSet<>();
        String nomeUnico;

        do {
            nomeUnico = this.nome + (1000 + random.nextInt(9000));
        } while (nomesGerados.contains(nomeUnico));

        nomesGerados.add(nomeUnico);
        return nomeUnico;
    }

    public void setNomeUnico(String nomeUnico){
        this.nomeUnico = nomeUnico;
    }

    public void exibeInformacoes() {

        System.out.println("╔═══════════════════════════════════╗");
        Formatacao.imprimirCentralizado(nome);
        System.out.println("╠═══════════════════════════════════╣");
        Formatacao.imprimirLinha("Nome Único", nomeUnico);
        Formatacao.imprimirLinha("Idade", idade);
        Formatacao.imprimirLinha("Nível", nivel);
        Formatacao.imprimirLinha("Experiência", experiencia);
        Formatacao.imprimirLinha("Saciedade", saciedade);
        Formatacao.imprimirLinha("Felicidade", felicidade);
        Formatacao.imprimirLinha("Saúde", saude);
        System.out.println("╚═══════════════════════════════════╝");
    }

    public void exibeEstadoAtual() {

        System.out.println("╔═══════════════════════════════════╗");
        Formatacao.imprimirCentralizado(nome);
        System.out.println("╠═══════════════════════════════════╣");
        Formatacao.imprimirLinha("Nome Único", nomeUnico);
        Formatacao.imprimirLinhaVazia();
        Formatacao.imprimirLinha("Saúde", Formatacao.barra(saude), Saude.estadoSaude(saude).toString());
        Formatacao.imprimirLinhaVazia();
        Formatacao.imprimirLinha("Felicidade", Formatacao.barra(felicidade), Felicidade.estadoFelicidade(felicidade).toString());
        Formatacao.imprimirLinhaVazia();
        Formatacao.imprimirLinha("Saciedade", Formatacao.barra(saciedade), Saciedade.estadoSaciedade(saciedade).toString());
        Formatacao.imprimirLinhaVazia();
        Formatacao.imprimirLinha("Energia", Formatacao.barra(energia), Energia.estadoEnergia(energia).toString());
        System.out.println("╚═══════════════════════════════════╝");
    }

    public void calculaSaude(){
        saude = (energia + saciedade + felicidade)/3;
    }

    public String getNome(){
        return nome;
    }

    public String getNomeUnico(){
        return nomeUnico;
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
        return especie;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public void setSaciedade(int saciedade){
        this.saciedade = saciedade;
    }

    public void setFelicidade(int felicidade){
        this.felicidade = felicidade;
    }

    public void setSaude(int saude){
        this.saude = saude;
    }

    public void setExperienciaSoma(int modificador){
        this.experiencia += modificador;

        if(this.experiencia >= 100){
            this.nivel++;
            this.evoluir();
            this.ultimoFoiDescanso = false;
            this.experiencia -= this.experiencia - 99;
        }     
    }

    public void setEnergiaSoma(int modificador){
        this.energia += modificador;
        this.calculaSaude();
    }

    public void setSaciedadeSoma(int modificador){
        this.saciedade += modificador;
        this.calculaSaude();
    }

    public void setFelicidadeSoma(int modificador){
        this.felicidade += modificador;
        this.calculaSaude();
    }

    public void setSaudeSoma(int modificador){
        this.saude += modificador;
    }

    public boolean participouDesafio(){
        return participouDesafio;
    }

    public void setParticipouDesafio(boolean acao){
        this.participouDesafio = acao;
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
}