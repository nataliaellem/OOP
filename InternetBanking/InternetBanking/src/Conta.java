
public class Conta {

    //atributos
    Cliente dono = new Cliente();
    int numero_da_conta;
    double saldo;
    double limite;

    // Construtor
    public Conta(){
        this.numero_da_conta = -1;
        this.dono.nome = "Inválido";
        this.saldo = 0.0;
        this.limite = 0.0;
    }

    //métodos

    //depositar
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
    }

    //sacar
    public boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
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

    //imprimir
    public void imprimir(){
        System.out.println("Nome: "+this.dono.getNomeCliente());
        System.out.println("Número da conta: "+this.numero_da_conta);
        System.out.println("Saldo atual: "+this.saldo);
        System.out.println("Limite: "+this.limite);
    }
}


