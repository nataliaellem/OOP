public class ContaUniversitaria extends Conta{

    // Construtor
    public ContaUniversitaria(){
        this.limite = 0;
    }

    // Métodos


    @Override
    public double calculaTaxas() {
        return 0;
    }

    public void setLimite(double valor){

        if (valor > 500 || valor < 0){
            throw new IllegalArgumentException();
        }

        else {
            this.limite = valor;
        }

    }

}

