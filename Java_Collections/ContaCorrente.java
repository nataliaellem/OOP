public class ContaCorrente extends Conta{

    //Construtor

    public ContaCorrente(){

        this.limite = 100;

    }

    // Métodos


    @Override
    public double calculaTaxas() {
        if (this.getDono() instanceof ClientePessoaFisica){
            return 10.0;
        }
        else if (this.getDono() instanceof ClientePessoaJuridica){
            return 20.0;
        }
        return 0;
    }

    public void setLimite(double valor){
        if (valor >= 100)
            this.limite = valor;
        else {
            System.out.println("Valor invalido.");
        }
    }

}

