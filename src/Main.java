import java.util.Scanner;

/**
 * Intro2CS, Ex1.java - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Main {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1.java class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals("quit")) {
                    try {
                        int number1 = Ex1.number2Int(num1);
                        int number2 = Ex1.number2Int(num2);
                        boolean areEqual = Ex1.equals(num1, num2);


                        if (areEqual) {
                            System.out.println("the 2 numbers are equal ");
                        } else {
                            System.out.println("the 2 numbers are not equal ");
                        }
                        System.out.println("How many numbers do you want to put?");
                        int n = sc.nextInt();
                        sc.nextLine();
                        if (n <= 0) {
                            System.out.println("Please enter a positive number of elements.");
                            continue;
                        }
                        String[] arr = new String[n];

                        for (int i = 0; i < n; i++) {
                            System.out.println("Enter number #" + (i + 1) + " in the format <number>b<base>: ");
                            arr[i] = sc.nextLine();
                        }

                        String maxValue = String.valueOf(Ex1.maxIndex(arr));
                        System.out.println("the max value is " + maxValue);
                        // print somme of 2 num
                        System.out.println("the decimal is " + number1);
                        System.out.println("The sum of " + number1 + " and " + number2 + " is: " + (number1 + number2));
                        // look if the number is valid

                    } catch (NumberFormatException e) {
                        System.out.println("One or both of the inputs are not valid numbers.");


                    }

                }
            }
        }
    }
}