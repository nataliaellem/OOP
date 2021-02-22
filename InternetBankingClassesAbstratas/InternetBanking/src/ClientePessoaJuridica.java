public class ClientePessoaJuridica extends Cliente {
    private String cnpj;
    private int numFuncionarios;
    String setor;

    //Métodos

    public boolean autenticar(String chave) {
        if (this.cnpj.equals(chave)) {
            return true;
        } else {
            return false;
        }
    }

    //Reimplementando o método toString da superclasse Object
    public String toString(){
        String pessoaJuridicaStr = "Nome: " + super.getNome() + "\n" +
                                   "Endereço: " + super.getEndereco() + "\n" +
                                   "Data: " + super.getData() + "\n" +
                                   "CNPJ: " + this.cnpj + "\n" +
                                   "Número de funcionários: " + this.numFuncionarios + "\n" +
                                   "Setor: " + this.setor;
        return pessoaJuridicaStr;
    }

    //Reimplementando o método equals()

    public boolean equals(Object objeto) {
        if (objeto instanceof ClientePessoaJuridica){
            ClientePessoaJuridica pessoajuridica = (ClientePessoaJuridica) objeto;
            if (this.cnpj.equals(pessoajuridica.cnpj)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }


    // Getters
    public String getCnpj() {
        return this.cnpj;
    }

    public String getSetor() {
        return this.setor;
    }

    public int getNumFuncionarios() {
        return this.numFuncionarios;
    }


    //Setters

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setSetor(String setor) {
            this.setor = setor;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }
}


