package machine;
import java.util.Scanner;
public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (CoffeeMaker.active) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();
            CoffeeMaker.chooseAction(input);
        }
    }
}