import java.util.Scanner;

public class Condicional2 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int num;
        System.out.print("Digite um número: ");
        num = input.nextInt();
        if (num%7 == 0){
            System.out.print("É divisível por 7\n");
        }
        else {
            System.out.print("Não é divisível por 7\n");
        }
    }
}