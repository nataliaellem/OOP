public class OperacaoSaque extends Operacao {

    public OperacaoSaque(double valor){
        super.setTipo('s');
        super.setValor(valor);
    }

    public String toString(){
        String opSaqueStr = "Tipo de operação: Saque" + "\n" +
                            "Data: " + super.getData() + "\n" +
                            "Valor: " + super.getValor();
        return opSaqueStr;
    }

}
