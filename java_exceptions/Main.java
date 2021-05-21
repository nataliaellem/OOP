public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new ClientePessoaFisica();
        cliente1.setNome("Anne Shirley");
        cliente1.setData("01/01/2021");
        cliente1.setEndereco("Green Gables");
        Conta c = new ContaCorrente();

        c.setDono(cliente1);
        try {
            c.depositar(2000);
            c.setLimite(1000);
            c.depositar(-1000);
            c.sacar(500);
        } catch (ValorNegativoException e){
            System.out.println(e.getMessage() + "\n");
        } catch (SemLimiteException l){
            System.out.println(l.getMessage() + "\n");
        }
        

        // Criando outra conta

        Cliente cliente2 = new ClientePessoaFisica();
        cliente2.setNome("Gilbert Blythe");
        cliente2.setData("01/01/2021");
        cliente2.setEndereco("Avonlea");
        Conta c2 = new ContaCorrente();

        c2.setDono(cliente2);

        try {
            c2.depositar(500);
            c2.setLimite(200);
            c2.sacar(800);
        } catch (ValorNegativoException e){
            System.out.println(e.getMessage() + "\n");
        } catch (SemLimiteException s) {
            System.out.println(s.getMessage() + "\n");
        }


        try {
            c.transferir(c2, 1500);
        } catch (SemLimiteException e) {
            System.out.println(e.getMessage() + "\n");
        } catch (ValorNegativoException n) {
            System.out.println(n.getMessage() + "\n");
        }


        // Testando o método setLimite com a IllegalArgumentException

        Cliente cliente3 = new ClientePessoaFisica();
        cliente3.setNome("Marilla Cuthbert");

        Conta c3 = new ContaCorrente();
        c3.setDono(cliente3);


        // Tentando colocar um limite menor que da faixa definida de 100
        double valor = 50.00;
        try {
            c3.setLimite(valor);

        } catch (IllegalArgumentException e){
            System.out.println("Limite de " + valor + " fora da faixa estabelecida para esse tipo de conta.");
        }


    }
}

