import java.io.OptionalDataException;
import java.util.Date;

public abstract class Operacao implements ITaxas, Comparable<Operacao> {

    private Date data;
    private char tipo;
    private double valor;
    private static int TOTAL_OPERACOES = 0;


    //Construtor
    public Operacao() {
        data = new Date();
        Operacao.TOTAL_OPERACOES++;
    }

    //Métodos

    // Método compareTo da interface Comperable que irá 
    // comparar os objetos Operacao em relação às datas
    public int compareTo(Operacao o){
        if (this.data.compareTo(o.data) < 0){
            return -1;
        }
        else if (this.data.compareTo(o.data) > 0){
            return 1;
        }
        else {
            return 0;
        }
    }


    public void imprimir(){
        System.out.println(this.data + "\t" + this.tipo + "\t" + this.valor);
    }

    //getters

    public double getValor(){
        return this.valor;
    }

    public char getTipo(){
        return this.tipo;
    }

    public Date getData(){
        return this.data;
    }


    //seters

    public void setTipo(char tipo){
        if (tipo == 'd' || tipo == 's'){
            this.tipo = tipo;
        }
    }

    public void setValor(double valor){
        this.valor = valor;
    }
}

