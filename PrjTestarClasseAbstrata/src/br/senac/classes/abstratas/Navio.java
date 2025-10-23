package br.senac.classes.abstratas;

/*
 * Esta classe representa a classe abstrata Navio
 */
public abstract class Navio {

    private String nome;
    private long peso;
    private int comprimento;

    public Navio() {
        super();
    }

    public Navio(String nome, long peso, int comprimento) {
        this.nome = nome;
        this.peso = peso;
        this.comprimento = comprimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public abstract void partir();

    public abstract void navegar();

    public abstract void parar();

    public abstract void atracar();
}
