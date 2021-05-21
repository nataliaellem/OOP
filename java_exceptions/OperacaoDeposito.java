public class OperacaoDeposito extends Operacao {

    public OperacaoDeposito(double valor) {
        super.setTipo('d');
        super.setValor(valor);
    }

    public String toString(){
        String opDepositoStr = "Tipo de operação: Deposito" + "\n" +
                "Data: " + super.getData() + "\n" +
                "Valor: " + super.getValor();
        return opDepositoStr;
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}
