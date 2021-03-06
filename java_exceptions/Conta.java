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
    protected Conta(){

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
    public void depositar(double valor) throws ValorNegativoException{

        if (valor < 0){
            throw new ValorNegativoException("Erro. Depósito negativo: " + valor);
        }

        this.saldo = this.saldo + valor;
        this.operacoes.add(new OperacaoDeposito(valor));
    }

    //sacar
    public boolean sacar(double valor) throws ValorNegativoException, SemLimiteException{
        if (valor < 0) {
            throw new ValorNegativoException("Erro. Saque negativo: " + valor);
        }

        if (valor > this.limite){
            throw new SemLimiteException("Erro. Limite ultrapassado, valor: " + valor);
        }

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
    public boolean transferir(Conta contaDestino, double valor) throws ValorNegativoException, SemLimiteException {
        
        boolean retirou = this.sacar(valor);

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
    // se for 2, a ordenação é pelo tipo de operação (1° depósito 2° saque)

    public void imprimirExtrato(int tipoOrdenacao){
        ArrayList<Operacao> operacoesOriginal = new ArrayList<>(); 

        for (Operacao op : this.operacoes){
            operacoesOriginal.add(op);
        }
        if (tipoOrdenacao == 1){
            System.out.println("\n\n==== Extrato ordenado por data ====\n");
            
            for (Operacao op : this.operacoes){
                op.imprimir();
            }
        } else if (tipoOrdenacao == 2){
            System.out.println("\n\n==== Extrato Ordenado por tipo ====\n");
            
            // Utilizando Collections.sort para ordenar o array de acordo com o atributo 'tipo' dos objetos
            Collections.sort(this.operacoes);
            for (Operacao op : this.operacoes){
                op.imprimir();
            }
            
            // Fazendo com que o array operacoes deste objeto seja igual antes
            // A iteração para remover elementos deve ser feita usando o array operacoesOriginal pois este tem o mesmo tamanho 
            // que o array this.operacoes, e é necessário remover todos os elementos. Além disso, não se tem o tamanho de 'this.operacoes'
            for (Operacao o : operacoesOriginal){
                this.operacoes.remove(o);
            }
            for(Operacao o : operacoesOriginal){
                this.operacoes.add(o);
            }

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



