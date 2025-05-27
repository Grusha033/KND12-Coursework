package view.console.components;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInput
{
    private static final String inputPrompt = "-> ";

    public static int readInteger(Scanner scanner, String prompt, int maxBounds) {
        int result = 0;

        while (true) {
            System.out.println(prompt);
            System.out.print(inputPrompt);

            try {
                result = scanner.nextInt();
                scanner.nextLine();

                if (result < 0 || result > maxBounds) {
                    System.out.println("Error: Please enter a number between 0 and " + maxBounds + ".");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }

        return result;
    }

    public static String getString(Scanner scanner, String prompt)
    {
        String result = null;

        while (true)
        {
            System.out.println(prompt);
            System.out.print(inputPrompt);

            result = scanner.nextLine();

            if (result.trim().isEmpty())
            {
                System.out.println("Error: Input cannot be empty. Please enter some text.");
            }
            else
            {
                break;
            }
        }

        return result;
    }
}
