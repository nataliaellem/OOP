import java.io.OptionalDataException;
import java.util.Date;

public class Operacao {

    public Date data;

    public char tipo;

    public double valor;


    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
    }

}
