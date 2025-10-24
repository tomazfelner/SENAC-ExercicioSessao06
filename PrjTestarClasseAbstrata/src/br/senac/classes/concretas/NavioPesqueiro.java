package br.senac.classes.concretas;

import br.senac.classes.abstratas.Navio;
import br.senac.classes.tipoPesca.TipoPesca;
import java.util.Scanner;

/**
 * @author tomaz
 */
public class NavioPesqueiro extends Navio {

    private int capacidade;
    private TipoPesca tipoPesca;
    private int totalPescadoEmbarcado;

    public NavioPesqueiro() {
        super();
    }

    public NavioPesqueiro(int capacidade, TipoPesca tipoPesca, String nome, long peso, int comprimento) {
        super(nome, peso, comprimento);
        this.capacidade = capacidade;
        this.tipoPesca = tipoPesca;
    }

    public NavioPesqueiro(String nome, long peso, int comprimento, int capacidade, TipoPesca tipoPesca) {
        this.setNome(nome);
        this.setPeso(peso);
        this.setComprimento(comprimento);
        this.capacidade = capacidade;
        this.tipoPesca = tipoPesca;
    }

    public void apresentarQuantidadeDePescado() {
        System.out.println("\n<---- QNT. PESCADOS ---->");
        System.out.printf("\tO navio possui %d pescado(s) embarcados.\n", this.totalPescadoEmbarcado);
    }

    public void pescar(int quantidadePescado) {
        if (totalPescadoEmbarcado == capacidade){
            System.out.println("ATENCAO! Nao tem como embarcar mais nenhum pescado.");
            return;
        }
        int calcularPescados = this.totalPescadoEmbarcado + quantidadePescado;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n<----- EMBARQUE ----->");
        while (calcularPescados > this.capacidade) {
            int calcularLimiteUltrapassado = calcularPescados - this.capacidade;
            System.out.printf("\tATENCAO! O navio nao consegue comportar o(s) %d pescado(s).\n\t%d pescado(s) acima do limite.\n", quantidadePescado, calcularLimiteUltrapassado);
            System.out.println("\n\tRespeite o limite! Quantos pescados irao embarcar?");
            quantidadePescado = scanner.nextInt();
            calcularPescados = this.totalPescadoEmbarcado + quantidadePescado;
        }
        int calcularLimiteRestante = this.capacidade - calcularPescados;
        if (calcularPescados == this.capacidade) {
            System.out.printf("\tLiberado o embarque do(s) %d pescado(s).\nATENCAO! Limite maximo atingido.\n", quantidadePescado);
        } else {
            System.out.printf("\tLiberado o embarque do(s) %d pescado(s). Limite restante: %d pescado(s).\n", quantidadePescado, calcularLimiteRestante);
        }
        this.totalPescadoEmbarcado = calcularPescados;
    }

    public void desembarcarTodoPescado() {
        System.out.println("\n<----- ESVAZIAR NAVIO ----->");
        if (this.totalPescadoEmbarcado > 0) {
            System.out.printf("\tDesembarcando todos os pescados no frigorifico.\n\tTotal de pescados desembarcados: %d.\n", this.totalPescadoEmbarcado);
            this.totalPescadoEmbarcado = 0;
        } else {
            System.out.println("\tNao ha pescados para desembarcar.\n");
        }
    }

    @Override
    public void partir() {
        System.out.println("\nO NAVIO ESTA PARTINDO.");
    }

    @Override
    public void navegar() {
        System.out.println("\nO NAVIO ESTA NAVEGANDO.");
    }

    @Override
    public void parar() {
        System.out.println("\nO NAVIO ESTA PARANDO.");
    }

    @Override
    public void atracar() {
        System.out.println("\nO NAVIO ESTA ATRACANDO.");
    }

}
