package br.senac.classes.concretas;

import br.senac.classes.abstratas.Navio;
import br.senac.interfaces.Passageiro;
import java.util.Scanner;

/**
 * @author tomaz
 */
public class NavioPassageiro extends Navio implements Passageiro {

    private int numeroPassageiros;
    private int totalPassageirosEmbarcados;

    public NavioPassageiro() {
        super();
    }

    public NavioPassageiro(int numeroPassageiros, String nome, long peso, int comprimento) {
        super(nome, peso, comprimento);
        this.numeroPassageiros = numeroPassageiros;
    }

    public NavioPassageiro(String nome, long peso, int comprimento, int numeroPassageiros) {
        this.setNome(nome);
        this.setPeso(peso);
        this.setComprimento(comprimento);
        this.numeroPassageiros = numeroPassageiros;
    }

    @Override
    public void apresentarQuantidadePassageirosEmbarcados() {
        System.out.println("\n<---- QNT. PASSAGEIROS ---->");
        System.out.printf("\tO navio possui %d passageiro(s) embarcados", this.totalPassageirosEmbarcados);
    }

    @Override
    public void embarcarPassageiros(int quantidadePassageiros) {
        if (totalPassageirosEmbarcados == numeroPassageiros) {
            System.out.println("ATENCAO! Nao tem como embarcar mais nenhum passageiro.");
            return;
        }
        int calcularEmbarcados = this.totalPassageirosEmbarcados + quantidadePassageiros;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n<-------- EMBARQUE -------->");
        while (calcularEmbarcados > this.numeroPassageiros) {

            int calcularLimiteUltrapassado = calcularEmbarcados - this.numeroPassageiros;
            System.out.printf("\tATENCAO! O navio nao consegue comportar o(s) %d passageiro(s).\n\t%d passageiro(s) acima do limite.", quantidadePassageiros, calcularLimiteUltrapassado);
            System.out.println("\n\tRespeite o limite! Quantos passageiros irao embarcar?");
            quantidadePassageiros = scanner.nextInt();
            calcularEmbarcados = this.totalPassageirosEmbarcados + quantidadePassageiros;
            calcularLimiteUltrapassado = calcularEmbarcados - this.numeroPassageiros;
        }
        int calcularLimiteRestante = this.numeroPassageiros - calcularEmbarcados;
        if (calcularEmbarcados == this.numeroPassageiros) {
            System.out.printf("\tLiberado o embarque do(s) %d passageiro(s).\n\tATENCAO! Limite maximo atingido.", quantidadePassageiros);
        } else {
            System.out.printf("\tLiberado o embarque do(s) %d passageiro(s).\n\tLimite restante: %d passageiro(s).", quantidadePassageiros, calcularLimiteRestante);
        }
        this.totalPassageirosEmbarcados = calcularEmbarcados;
    }

    @Override
    public void desembarcarPassageiros(int quantidadePassageiros) {
        int calcularDesembarque = this.totalPassageirosEmbarcados - quantidadePassageiros;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n<------ DESEMBARQUE ------>");
        while (calcularDesembarque < 0) {
            System.out.printf("\tATENCAO! Numero de passageiros desembarcando maior que o numero de passageiros a bordo.");
            System.out.printf("\n\tHa %d passageiro(s) e desembarcando %d passageiro(s).", this.totalPassageirosEmbarcados, quantidadePassageiros);
            System.out.println("\n\tRespeite o limite! Quantos passageiros irao desembarcar?");
            quantidadePassageiros = scanner.nextInt();
            calcularDesembarque = this.totalPassageirosEmbarcados - quantidadePassageiros;
        }
        System.out.printf("\tDesembarque de %d passageiro(s) efetuado com sucesso!", quantidadePassageiros);
        if (calcularDesembarque == 0) {
            System.out.println("\n\tO navio foi esvaziado.");
        } else {
            int calcularLimiteRestante = this.numeroPassageiros - calcularDesembarque;
            System.out.printf("\n\tNovo limite para embarque: %d passageiro(s).\n", calcularLimiteRestante);
        }
        this.totalPassageirosEmbarcados = calcularDesembarque;
    }

    @Override
    public void desembarcarTodosOsPassageiros() {
        System.out.println("\n<----- ESVAZIAR NAVIO ----->");
        if (this.totalPassageirosEmbarcados > 0) {
            System.out.printf("\tDesembarcando todos os passageiros.\n\tTotal de passageiros desembarcados: %d.\n", this.totalPassageirosEmbarcados);
            this.totalPassageirosEmbarcados = 0;
        } else {
            System.out.println("\tNao ha passageiros para desembarcar.");
        }
    }

    @Override
    public void partir() {
        System.out.println("O NAVIO ESTA PARTINDO.");
    }

    @Override
    public void navegar() {
        System.out.println("O NAVIO ESTA NAVEGANDO.");
    }

    @Override
    public void parar() {
        System.out.println("O NAVIO ESTA PARANDO.");
    }

    @Override
    public void atracar() {
        System.out.println("O NAVIO ESTA ATRACANDO.");
    }
}
