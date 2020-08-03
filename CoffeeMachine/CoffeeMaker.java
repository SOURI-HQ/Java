package machine;
import java.util.Scanner;

public class CoffeeMaker {
    public enum machineState {
        ACTION_CHOICE,
        COFFEE_VARIANT,
        FILLING,
        TAKING,
        REMAINING,
        EXITING
    }
    // Available resources
    static int quantityOfWater = 400;
    static int quantityOfMilk = 540;
    static int quantityOfCoffeeBeans = 120;
    static int amountOfCups = 9;
    static int money = 550;

    static machineState state = machineState.ACTION_CHOICE; // coffee machine's startup state
    static boolean active = true;
    // inputProcessing method handles user's input in-between transitioning machine's states
    static void inputProcessing(String input) {
        switch(state) {
            case COFFEE_VARIANT:
                int[] statusChangesBuy = buyCoffee(quantityOfWater, quantityOfMilk, quantityOfCoffeeBeans, amountOfCups, money);
                quantityOfWater = statusChangesBuy[0];
                quantityOfMilk = statusChangesBuy[1];
                quantityOfCoffeeBeans = statusChangesBuy[2];
                amountOfCups = statusChangesBuy[3];
                money = statusChangesBuy[4];
                state = machineState.ACTION_CHOICE;
                break;
            case FILLING:
                int[] statusChangesFill = fillMachine();
                quantityOfWater += statusChangesFill[0];
                quantityOfMilk += statusChangesFill[1];
                quantityOfCoffeeBeans += statusChangesFill[2];
                amountOfCups += statusChangesFill[3];
                state = machineState.ACTION_CHOICE;
                break;
            case TAKING:
                takeMoney(money);
                money = 0;
                state = machineState.ACTION_CHOICE;
                break;
            case REMAINING:
                machineResourceStatus(quantityOfWater, quantityOfMilk, quantityOfCoffeeBeans, amountOfCups, money);
                state = machineState.ACTION_CHOICE;
                break;
            case EXITING:
                active = false;
                break;
        }
    }
    // chooseAction method handles user's input during ACTION_CHOICE machine's status
    static void chooseAction(String input) {
        switch(input) {
            case "buy":
                state = machineState.COFFEE_VARIANT;
                break;
            case "fill":
                state = machineState.FILLING;
                break;
            case "take":
                state = machineState.TAKING;
                break;
            case "remaining":
                state = machineState.REMAINING;
                break;
            case "exit":
                state = machineState.EXITING;
                break;
            default:
                System.out.println("Wrong input. Try again.");
        }
        inputProcessing(input);
    }

    static void machineResourceStatus(int water, int milk, int coffee, int cups, int money) {
        System.out.println("\nThe coffee machine has:\n" + water + " ml of water\n" + milk + " ml of milk\n"
                + coffee + " g of coffee beans\n" + cups + " of disposable cups\n" + money + " $ of money");
    }

    static int[] buyCoffee(int water, int milk, int coffee, int cups, int money) {
        Scanner scannerCoffee = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scannerCoffee.next()) {
            case "1":
                if (water >= 250 && coffee >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    int[] statusChanges = {water - 250, milk, coffee - 16, cups - 1, money + 4};
                    return statusChanges;
                }
                else {
                    System.out.println("Sorry, not enough resources!");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    int[] statusChanges = {water - 350, milk - 75, coffee - 20, cups - 1, money + 7};
                    return statusChanges;
                }
                else {
                    System.out.println("Sorry, not enough resources!");
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && coffee >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    int[] statusChanges = {water - 200, milk - 100, coffee - 12, cups - 1, money + 6};
                    return statusChanges;
                }
                else {
                    System.out.println("Sorry, not enough resources!");
                }
            case "back":
                break;
        }
        return new int[]{water, milk, coffee, cups, money};
    }

    static int[] fillMachine() {
        Scanner scannerFill = new Scanner(System.in);
        int[] statusChanges = new int[4];
        System.out.println("Write how many ml of water do you want to add:");
        statusChanges[0] = scannerFill.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        statusChanges[1] = scannerFill.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        statusChanges[2] = scannerFill.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        statusChanges[3] = scannerFill.nextInt();
        return statusChanges;
    }

    static void takeMoney(int money) {
        System.out.println("I gave you $" + money);
    }
}
