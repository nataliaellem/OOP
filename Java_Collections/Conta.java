import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Conta implements ITaxas{

    //atributos
    private Cliente dono;
    private String numeroDaConta;
    private double saldo;
    protected double limite;

    private ArrayList<Operacao> operacoes;

    public static int TOTAL_CONTAS = 0;


    // Construtor
    public Conta(){

        this.dono = null;
        this.saldo = 0.0;
        this.limite = 0.0;

        this.operacoes = new ArrayList<>();

        Conta.TOTAL_CONTAS++;
    }

    //métodos

    // Método para truncar um double para duas casas decimais

    private static String truncar(Double valor) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(valor);
    }

    // Método que imprime o extrato das taxas

    public void imprimirExtratoTaxas(){
        double totalTaxas = 0;

        System.out.println("=== Extrato das Taxas ===");
        double manutencao = this.calculaTaxas();
        totalTaxas = totalTaxas + manutencao;

        System.out.println("Manutenção da conta: " + manutencao + "\n");
        System.out.println("Operações");
        for (Operacao op : this.operacoes){
            if(op instanceof OperacaoSaque){
                double taxa = op.calculaTaxas();
                totalTaxas += taxa;

                System.out.println("Saque: " + taxa);
            }
        }
        System.out.println("\nTotal: "+ truncar(totalTaxas));
    }

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
        this.operacoes.add(new OperacaoDeposito(valor));
    }

    //sacar
    public boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            this.operacoes.add(new OperacaoSaque(valor));
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
    // Se o parâmetro passado for 1, a ordenação é pelas datas,
    // se for 2, a ordenação é pelo tipo de operação (1° saque 2° depósito)

    public void imprimirExtrato(int tipoOrdenacao){
        if (tipoOrdenacao == 1){
            System.out.println("\n\n==== Extrato ordenado por data ====\n");
            Collections.sort(this.operacoes);
    
            for (Operacao op : this.operacoes){
                op.imprimir();
            }
        } else if (tipoOrdenacao == 2){
            System.out.println("\n\n==== Extrato Ordenado por tipo ====\n");

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

    public ArrayList getOperacoes(){
        return this.operacoes;
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



