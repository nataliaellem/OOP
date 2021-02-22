import java.util.Objects;

public class ClientePessoaFisica extends Cliente {

    private String cpf;
    private int idade;
    private char sexo;


    // Métodos

    public boolean autenticar(String chave) {
        if (this.cpf.equals(chave)){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        String pessoaFisicaStr = "Nome: " + super.getNome() + "\n" +
                                 "Endereco: " + super.getEndereco() + "\n" +
                                 "Data: " + super.getData() + "\n" +
                                 "CPF: " + this.cpf + "\n" +
                                 "Sexo: " + this.sexo + "\n" +
                                 "Idade: " + this.idade;
        return pessoaFisicaStr;
    }

    //Reimplementando o método equals


    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof ClientePessoaFisica){
            ClientePessoaFisica pessoafisica = (ClientePessoaFisica) objeto;
            return this.cpf.equals(pessoafisica.cpf);
        } else {
            return false;
        }
    }

    // Getters
    public String getCpf() {
        return this.cpf;
    }

    public char getSexo() {
        return this.sexo;
    }

    public int getIdade() {
        return this.idade;
    }


    //Setters

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(char sexo) {
        if (sexo == 'm' || sexo == 'f')
            this.sexo = sexo;
        else {
            System.out.println("Parâmetro inválido.");
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
