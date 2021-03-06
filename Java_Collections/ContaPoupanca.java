public class ContaPoupanca extends Conta{

    //Construtor
    public ContaPoupanca(){

        this.limite = 100;

    }

    // Métodos


    @Override
    public double calculaTaxas() {
        return 0;
    }

    public void setLimite(double valor) {
        if (valor <= 1000 && valor >= 100)
            this.limite = valor;
        else {
            System.out.println("Valor inválido.");
        }
    }

}

