class MeuPrograma {
    public static void main(String[] args){
        System.out.println("Minha primeira aplicação java!\nHello world!");
        int idade;
        idade=20;
        System.out.println("Idade: "+idade);
        boolean menorDeIdade = idade < 18;
        //CASTING: MOLDAR UM NÚMERO, POR EXEMPLO TRANSFORMAR 
        //UM DOUBLE EM UM INTEIRO
        double d = 3.14;
        int i = (int) d;
        //Colocar 'float x = 0.0' não compila, mas colocar:
        float x = 0.0f;
        //compila!
        //O único tipo primitivo que não pode ser atribuído 
        //a nenhum outro tipo é o tipo boolean
        if (menorDeIdade == true){
            System.out.println("É menor de idade.");
        } else if (!menorDeIdade){
            System.out.println("É maior de idade.");
        }
        //O comando 'break' serve para sair de um loop
        //enquanto 'continue' serve para pular para a
        //próxima iteração
    }
}