public class Main {
    public static void main(String[] args){
        Cliente pessoa = new ClientePessoaFisica();
        Conta c = new ContaCorrente();

        c.setDono(pessoa);

        c.depositar(1000);
        c.depositar(2000);
        c.sacar(500);
        c.depositar(3000);
        c.sacar(10);
        c.sacar(15);
        c.sacar(10);

        c.imprimirExtrato(2);
        c.imprimirExtrato(1);
    }
}

