public class Main {
    public static void main(String[] args){

        Conta user1 = new Conta();
        user1.dono  = new Cliente();
        user1.numero_da_conta = 1;
        user1.saldo = 10000.0;
        user1.limite = 2000.0;

        user1.dono.nome = "Natália";
        user1.dono.sexo = 'f';
        user1.dono.endereco = "Belo Horizonte";
        user1.dono.CPF = "123";

        user1.depositar(5000);
        user1.sacar(400);
        user1.sacar(7000);

        user1.imprimir();
        System.out.println(user1.operacoes[0].tipo);
        System.out.println(user1.operacoes[0].valor);
        System.out.println(user1.operacoes[0].data);

        System.out.println(user1.operacoes[1].tipo);
        System.out.println(user1.operacoes[1].valor);
        System.out.println(user1.operacoes[1].data);

        System.out.println(user1.operacoes[2].tipo);
        System.out.println(user1.operacoes[2].valor);
        System.out.println(user1.operacoes[2].data);

        System.out.println(user1.posicao_disponivel);
        System.out.println("\n\nExtrato:\n");
        user1.extrato();

    }


}
