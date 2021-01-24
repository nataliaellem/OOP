import java.util.Scanner;

public class Condicional4 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int num;
        System.out.print("Digite a nota: ");
        num = input.nextInt();
        if (num >= 0 && num < 40){
            System.out.print("Conceito F\n");
        }
        else if (num >= 40 && num < 60){
            System.out.print("Conceito E\n");
        }
        else if (num >= 60 && num < 70){
            System.out.print("Conceito D\n");
        } 
        else if (num >= 70 && num < 80){
            System.out.print("Conceito C\n");
        }
        else if (num >= 80 && num < 90){
            System.out.print("Conceito B\n");
        }
        else if (num >= 90 && num <= 100){
            System.out.print("Conceito A\n");
        }
    }
}