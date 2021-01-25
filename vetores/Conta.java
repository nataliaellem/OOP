
public class Conta {

    //atributos
    Cliente dono = new Cliente();
    int numero_da_conta;
    double saldo;
    double limite;
    Operacao[] operacoes = new Operacao[1000];
    int posicao_disponivel;

    // Construtor
    public Conta(){
        this.numero_da_conta = -1;
        this.dono.nome = "Inválido";
        this.saldo = 0.0;
        this.limite = 0.0;
        this.posicao_disponivel = 0;
    }

    //métodos

    //função que retorna a última posição disponível do vetor operações

    public void proxOperacao(){
        int i = 0;
        while (this.operacoes[i] != null && i < 1000){
            i++;
        }
        this.posicao_disponivel = i;
    }

    //depositar
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
        this.proxOperacao();
        int posicao = this.posicao_disponivel;
        this.operacoes[posicao] = new Operacao('d', valor);
    }

    //sacar
    public boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            this.proxOperacao();
            int posicao = this.posicao_disponivel;
            this.operacoes[posicao] = new Operacao('s', valor);
            return true;
        }
        else {
            return false;
        }
    }

    //transferir
    public boolean transferir(Conta contaDestino, double valor){
        boolean retirou;
        if (valor <= this.limite){
            retirou = this.sacar(valor);
        }
        else {
            return false;
        }
        if (retirou) {
            contaDestino.depositar(valor);
            return true;
        }
        else {
            return false;
        }
    }

    //função que imprime o extrato
    public void extrato(){
        for (int i = 0; this.operacoes[i]!=null; i++){
            Operacao o = this.operacoes[i];
            System.out.println(o.data+"\t"+o.tipo+"\t"+o.valor);
        }
    }

    //imprimir
    public void imprimir(){
        System.out.println("Nome: "+this.dono.getNomeCliente());
        System.out.println("Número da conta: "+this.numero_da_conta);
        System.out.println("Saldo atual: "+this.saldo);
        System.out.println("Limite: "+this.limite);
    }
}


