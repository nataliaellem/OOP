public class ContaCorrente extends Conta{

    //Construtor

    public ContaCorrente(){

        this.limite = 100;

    }

    // Métodos

    public void setLimite(double valor){
        if (valor >= 100)
            this.limite = valor;
        else {
            System.out.println("Valor invalido.");
        }
    }

}
