package br.senac.interfaces;

/*
 * Esta interface representa um navio de passageiros.
 */
public interface Passageiro {

    // embarque de passageiros
    public void embarcarPassageiros(int quantidadePassageiros);

    // desembarque de passageiros
    public void desembarcarPassageiros(int quantidadePassageiros);

    // apresentar quantidade de passageiros embarcados
    public void apresentarQuantidadePassageirosEmbarcados();

    // desembarque de todos os passageiros
    public void desembarcarTodosOsPassageiros();
}
