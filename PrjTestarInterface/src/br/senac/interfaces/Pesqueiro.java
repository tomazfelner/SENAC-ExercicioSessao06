package br.senac.interfaces;

/*
 * Esta interface representa um Navio Pesqueiro.
 */
public interface Pesqueiro {

    // pescar
    public void pescar(int quantidadePescado);

    // apresentar a quantidade de Pescado
    public void apresentarQuantidadeDePescado();

    // desembarque de todos os passageiros
    public void desembarcarTodoPescado();
}
