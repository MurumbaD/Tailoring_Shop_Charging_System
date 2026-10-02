import java.util.Scanner;

public class InputHelper {

    private Scanner scanner;

    public InputHelper() {
        scanner = new Scanner(System.in);// here we hook into the keyboard input
    }
//getters where used ...

    public String getString(String message) { 
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be blank. Please try again.");
        }
    }

    public int getInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                int value = Integer.parseInt(scanner.nextLine().trim());

                if (value >= 0) {
                    return value;
                }

                System.out.println("Please enter a number that is not negative.");

/* this function catches the NumberFormatException not to make it 
crush by keeping calling it */

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public double getDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = Double.parseDouble(scanner.nextLine().trim());

                if (value >= 0) {
                    return value; // helps satisfy weather the program sholdnt crush when invalid values areprovided
                }

                System.out.println("Please enter a number that is not negative.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
/* specifies if the customer is loyal or not in boolean why */
    public boolean getYesNo(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("yes")
                    || input.equalsIgnoreCase("y")) {
                return true;  // is the customer loyal? yes 
            }

            if (input.equalsIgnoreCase("no")
                    || input.equalsIgnoreCase("n")) {
                return false;   // is the customer loyal? no
            }

            System.out.println("Please enter yes or no.");
        }
    }


/* ensures that the menu we created or built accepts on digits 1-7 */

    public int getMenuChoice() {
        while (true) {
            int choice = getInt("Enter your choice: ");

            if (choice >= 1 && choice <= 7) { // the and operator listed and great of less than 
                return choice;
            }

            System.out.println("Please choose an option from 1 to 7.");
        }
    }
}
