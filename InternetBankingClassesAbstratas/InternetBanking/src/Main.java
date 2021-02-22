public class Main {
    public static void main(String[] args){

        // Criando uma conta para testar as novas funcionalidades
        Conta conta1 = new ContaCorrente();
        conta1.setLimite(100);
        conta1.setNumeroDaConta("123");
        conta1.depositar(200);

        ClientePessoaFisica cliente1 = new ClientePessoaFisica();
        cliente1.setNome("Alan");
        cliente1.setCpf("987");
        cliente1.setIdade(22);
        cliente1.setSexo('m');
        cliente1.setData("01/01/2021");
        cliente1.setEndereco("Belo Horizonte");

        conta1.setDono(cliente1);

        // Imprimindo dados da conta e dados do cliente1

        System.out.println("===== Dados da conta 1 ====");
        System.out.println(conta1.toString());
        System.out.println("\n==== Dados do dono da conta 1 ====");
        System.out.println(conta1.getDono().toString());

    }
}
