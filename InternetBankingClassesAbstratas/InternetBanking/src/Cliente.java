
public abstract class Cliente {
    private String nome;
    private String endereco;
    private String data;

    //Métodos

    public abstract boolean autenticar(String chave);


    // getters

    public String getEndereco(){
        return this.endereco;
    }

    public String getNome() { return this.nome; }

    public String getData() { return this.data; }



    //setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setData(String data) {
        this.data = data;
    }

}
