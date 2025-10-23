package br.senac.classes.concretas;

import br.senac.classes.abstratas.Navio;
import br.senac.classes.tipoPesca.TipoPesca;

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
    
    public void apresentarQuantidadeDePescado(){
        System.out.printf("O navio possui %d pescado(s) embarcados.",this.totalPescadoEmbarcado);
    }
    
    public void pescar(int quantidadePescado){
        int calcularPescados = this.totalPescadoEmbarcado + quantidadePescado;
        
        if (calcularPescados > this.capacidade){
            int calcularLimiteUltrapassado = calcularPescados - this.totalPescadoEmbarcado;
            System.out.printf("ATENCAO!\nO navio nao consegue comportar o(s) %d pescado(s).\n\t%d pescado(s) acima do limite.",quantidadePescado,calcularLimiteUltrapassado);
        }else{
            int calcularLimiteRestante = this.capacidade - calcularPescados;
            if (calcularPescados == this.capacidade){
                System.out.printf("Liberado o embarque do(s) %d pescado(s).\nATENCAO! Limite maximo atingido.",quantidadePescado);     
            }else{
                System.out.printf("Liberado o embarque do(s) %d pescado(s). Limite restante: %d pescado(s).",quantidadePescado,calcularLimiteRestante);
            }
            this.totalPescadoEmbarcado = calcularPescados;
        }
    }

    public void desembarcarTodoPescado(){
        if (this.totalPescadoEmbarcado > 0) {
            System.out.printf("ATENCAO!\nDesembarcando todos os pescados no frigorifico.\nTotal de pescados desembarcados: %d.", this.totalPescadoEmbarcado);
            this.totalPescadoEmbarcado = 0;
        } else {
            System.out.println("Nao ha pescados para desembarcar.");
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
