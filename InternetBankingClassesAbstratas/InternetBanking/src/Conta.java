public abstract class Conta {

    //atributos
    private Cliente dono;
    private String numeroDaConta;
    private double saldo;
    protected double limite;

    private Operacao[] operacoes;
    private int numOperacoes;

    public static int TOTAL_CONTAS = 0;


    // Construtor
    public Conta(){

        this.dono = null;
        this.saldo = 0.0;
        this.limite = 0.0;

        this.numOperacoes = 0;
        this.operacoes = new Operacao[1000];

        Conta.TOTAL_CONTAS++;
    }

    //métodos

    // Reimplementando o método toString da superclasse object
    public String toString(){
        String contaStr = "Número da conta: " + this.numeroDaConta + "\n" +
                             "Saldo atual: " + this.saldo + "\n" +
                             "Limite: " + this.limite;
        return contaStr;
    }


    // Reimplementando o método equals da superclasse object
    @Override
    public boolean equals(Object objeto) {
        if (getClass() != objeto.getClass()) return false;
        Conta conta = (Conta) objeto;
        return this.numeroDaConta.equals(conta.numeroDaConta);
    }


    //depositar
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
        this.operacoes[numOperacoes] = new OperacaoDeposito(valor);
        numOperacoes++;
    }

    //sacar
    public boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            this.operacoes[numOperacoes] = new OperacaoSaque(valor);
            numOperacoes++;
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

    public void imprimirExtrato(){
        for (int i = 0; i < this.numOperacoes; i++){
            this.operacoes[i].imprimir();
        }
    }


    //getters

    public String getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getLimite() {
        return this.limite;
    }

    public Operacao[] getOperacoes(){
        Operacao[] operacoes = this.operacoes;
        return operacoes;
    }

    public Cliente getDono(){
        return this.dono;
    }

   //setters

   public void setNumeroDaConta(String numero) {
        this.numeroDaConta = numero;
   }

   public void setDono(Cliente cliente){

        this.dono = cliente;

   }

   public abstract void setLimite(double valor);
}


