import java.util.Scanner;

public class Condicional1 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Digite um número: ");
        number = input.nextInt();
        if (number%2 == 0){
            System.out.println("É par!");
        }
        else {
            System.out.println("É impar!");
        }
    }
}