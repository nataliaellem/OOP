import java.util.Scanner;

public class Repeticao4 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Digite um número: ");
        number = input.nextInt();
        int fatorial = 1;
        for (int i = 1; i <= number; i++){
            fatorial = fatorial * i;
        }
        System.out.println("Fatorial = "+fatorial);
    }
}