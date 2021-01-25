import java.util.Scanner;

public class Condicional5 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int num1;
        int num2;
        System.out.print("Digite um número: ");
        num1 = input.nextInt();
        System.out.print("Digite outro número: ");
        num2 = input.nextInt();
        if (num1 > num2){
            System.out.print("O maior número é "+num1);
        }
        else if (num2 > num1){
            System.out.print("O maior número é "+num2);
        } 
        else if (num1 == num2){
            System.out.println("Os números são iguais.\n");
        }
    }
}