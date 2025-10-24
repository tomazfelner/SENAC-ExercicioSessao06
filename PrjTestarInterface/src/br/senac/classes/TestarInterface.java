package br.senac.classes;

import br.senac.classes.concretas.NavioPassageiro;
import br.senac.classes.concretas.NavioPesqueiro;
import br.senac.classes.tipoPesca.TipoPesca;
import java.util.Scanner;

/**
 * @author tomaz
 */
public class TestarInterface {

    public static void main(String[] args) {
        int menuSelector;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Desejas testar qual tipo de Navio?");
        System.out.println("1 - Navios Passageiros");
        System.out.println("2 - Navios Pesqueiros");
        menuSelector = scanner.nextInt();

        switch (menuSelector) {
            case 1:
                testarNaviosPassageiros();
                break;
            case 2:
                testarNaviosPesqueiros();
                break;
        }
    }

    static void testarNaviosPassageiros() {
        Scanner scanner = new Scanner(System.in);
        String nome = "Atlas";
        long peso = 70000;
        int comprimento = 295;
        int numeroPassageiros = 3000;
        int passageirosEmbarcando;
        int passageirosDesembarcando;

        NavioPassageiro navioPassageiro = new NavioPassageiro(nome, peso, comprimento, numeroPassageiros);

        System.out.println("--------------- FICHA TECNICA DO NAVIO ---------------");
        System.out.printf("Nome: %s.\n", nome);
        System.out.printf("Peso: %d toneladas.\n", peso);
        System.out.printf("Comprimento: %d metros.\n", comprimento);
        System.out.printf("Capacidade Maxima de Passageiros: %d.\n", numeroPassageiros);
        System.out.println("------------------------------------------------------");
        System.out.println("O navio esta para sair. Quantos passageiros embarcaram?");
        passageirosEmbarcando = scanner.nextInt();
        navioPassageiro.embarcarPassageiros(passageirosEmbarcando);
        navioPassageiro.partir();
        navioPassageiro.navegar();
        navioPassageiro.atracar();
        System.out.println("O navio fez uma parada, quantos passageiros desembarcaram?");
        passageirosDesembarcando = scanner.nextInt();
        navioPassageiro.desembarcarPassageiros(passageirosDesembarcando);
        System.out.println("O navio vai voltar ao trajeto, quantos passageiros embarcaram?");
        passageirosEmbarcando = scanner.nextInt();
        navioPassageiro.embarcarPassageiros(passageirosEmbarcando);
        navioPassageiro.partir();
        navioPassageiro.navegar();
        navioPassageiro.atracar();
        System.out.println("O navio chegou ao destino final, vamos desembarcar todos os passageiros.");
        navioPassageiro.desembarcarTodosOsPassageiros();
    }

    static void testarNaviosPesqueiros() {
        Scanner scanner = new Scanner(System.in);
        String nome = "Poseidon";
        long peso = 200000;
        int comprimento = 42;
        int capacidade = 120000;
        TipoPesca tipoPesca = TipoPesca.BACALHAU;
        int pescadoEmbarcando;

        NavioPesqueiro navioPesqueiro = new NavioPesqueiro(nome, peso, comprimento, capacidade, tipoPesca);

        System.out.println("--------------- FICHA TECNICA DO NAVIO ---------------");
        System.out.printf("Nome: %s.\n", nome);
        System.out.printf("Peso: %d toneladas.\n", peso);
        System.out.printf("Comprimento: %d metros.\n", comprimento);
        System.out.printf("Capacidade Maxima de Pescados: %d.\n", capacidade);
        System.out.printf("Tipo de Pesca: %s.\n", tipoPesca);
        System.out.println("------------------------------------------------------");
        navioPesqueiro.partir();
        navioPesqueiro.navegar();
        navioPesqueiro.parar();
        System.out.println("Houve uma pesca em boa quantidade, quantos pescados?");
        pescadoEmbarcando = scanner.nextInt();
        navioPesqueiro.pescar(pescadoEmbarcando);
        navioPesqueiro.partir();
        navioPesqueiro.navegar();
        navioPesqueiro.atracar();
        System.out.println("O navio fez uma parada para descarregar.");
        navioPesqueiro.desembarcarTodoPescado();
        navioPesqueiro.partir();
        navioPesqueiro.navegar();
        navioPesqueiro.parar();
        System.out.println("Houve uma pesca em boa quantidade, quantos pescados?");
        pescadoEmbarcando = scanner.nextInt();
        navioPesqueiro.pescar(pescadoEmbarcando);
        navioPesqueiro.partir();
        navioPesqueiro.navegar();
        navioPesqueiro.parar();
        System.out.println("Houve uma pesca em boa quantidade, quantos pescados?");
        pescadoEmbarcando = scanner.nextInt();
        navioPesqueiro.pescar(pescadoEmbarcando);
        navioPesqueiro.partir();
        navioPesqueiro.navegar();
        navioPesqueiro.atracar();
        System.out.println("O navio chegou ao destino final, vamos descarregar todos os pescados.");
        navioPesqueiro.desembarcarTodoPescado();
    }
}