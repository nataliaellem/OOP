public class Cliente {
    String nome;
    String CPF;
    String endereco;
    int idade;
    char sexo;

    //Métodos paara obter os atributos do cliente
    public String getNomeCliente(){
        return this.nome;
    }

    public String getCPFCliente(){
        return this.CPF;
    }

    public String getEnderecoCliente(){
        return this.endereco;
    }

    public int getIdadeCliente(){
        return this.idade;
    }

    public char getSexo() {
        return this.sexo;
    }

}
