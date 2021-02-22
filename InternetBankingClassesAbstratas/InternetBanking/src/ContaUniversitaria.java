public class ContaUniversitaria extends Conta{

    // Construtor
    public ContaUniversitaria(){
        this.limite = 0;
    }

    // Métodos
    public void setLimite(double valor){

        if(valor <= 500 && valor >= 0) {
            this.limite = valor;
        }
        else{
            System.out.println("Valor invalido.");
        }

    }

}
