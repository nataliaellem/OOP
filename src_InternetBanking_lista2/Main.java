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

        user1.imprimir();
    }


}
