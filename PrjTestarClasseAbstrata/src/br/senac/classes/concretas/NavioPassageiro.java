package br.senac.classes.concretas;

import br.senac.classes.abstratas.Navio;

/**
 * @author tomaz
 */
public class NavioPassageiro extends Navio {

    private int numeroPassageiros;
    private int totalPassageirosEmbarcados;

    public NavioPassageiro() {
    }

    public NavioPassageiro(int numeroPassageiros, String nome, long peso, int comprimento) {
        super(nome, peso, comprimento);
        this.numeroPassageiros = numeroPassageiros;
    }

    public NavioPassageiro(String nome, long peso, int comprimento, int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public void apresentarQuantidadePassageirosEmbarcados() {
        System.out.printf("O navio possui %d passageiro(s) embarcados", this.totalPassageirosEmbarcados);
    }

    public void embarcaarPassageiros(int passageirosEmbarcados) {
        int calcularEmbarcados = this.totalPassageirosEmbarcados + passageirosEmbarcados;

        if (calcularEmbarcados > this.numeroPassageiros) {
            int calcularLimite = calcularEmbarcados - this.numeroPassageiros;
            System.out.printf("ATENCAO!\nO navio não comporta mais o(s) %d passageiro(s).\n\t%d passageiro(s) acima do limite.", passageirosEmbarcados, calcularLimite);
        } else {
            int calcularLimite = this.numeroPassageiros - calcularEmbarcados;
            if (calcularEmbarcados == this.numeroPassageiros) {
                System.out.printf("Liberado o embarque do(s) %d passageiro(s). Limite maximo atingido.", passageirosEmbarcados);
            } else {
                System.out.printf("Liberado o embarque do(s) %d passageiro(s). Limite restante: %d passageiro(s).", passageirosEmbarcados, calcularLimite);
            }
            this.totalPassageirosEmbarcados = calcularEmbarcados;
        }
    }

    public void desembarcarPassageiros(int passageirosDesembarcados) {
        int calcularDesembarque = this.totalPassageirosEmbarcados - passageirosDesembarcados;

        if (calcularDesembarque < 0) {
            System.out.printf("ATENCAO!\nNumero de passageiros desembarcando maior que o numero de passageiros a bordo.");
            System.out.printf("Ha %d passageiro(s) e desembarcando %d passageiro(s).", this.totalPassageirosEmbarcados, passageirosDesembarcados);
        } else {
            System.out.printf("Desembarque de %d passageiro(s) efetuado com sucesso!", passageirosDesembarcados);
            if (calcularDesembarque == 0) {
                System.out.println("\nO navio foi esvaziado.");
            } else {
                int calcularLimite = this.numeroPassageiros - calcularDesembarque;
                System.out.printf("\nNovo limite para embarque: %d passageiro(s).", calcularLimite);
            }
            this.totalPassageirosEmbarcados = calcularDesembarque;
        }
    }

    public void desembarcarTodosOsPassageiros() {
        if (this.totalPassageirosEmbarcados > 0) {
            System.out.printf("ATENCAO!\nDesembarcando todos os passageiros.\nTotal de passageiros desembarcados: %d.", this.totalPassageirosEmbarcados);
            this.totalPassageirosEmbarcados = 0;
        } else {
            System.out.println("Nao ha passageiros para desembarcar.");
        }
    }

    @Override
    public void partir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void navegar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void parar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atracar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
