import java.util.Scanner;

public class Condicional3 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int num;
        System.out.print("Digite a nota: ");
        num = input.nextInt();
        if (num >= 60 && num <= 100){
            System.out.print("Passou de ano.\n");
        }
        else if (num<60 && num>=0){
            System.out.print("Não passou de ano.\n");
        }
    }
}