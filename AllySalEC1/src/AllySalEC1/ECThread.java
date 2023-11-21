package AllySalEC1;

import java.util.Scanner;

public class ECThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

       
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

    
        Thread addThread = new Thread(() -> {
            int sum = 0;
            for (int i = 1; i <= num1; i++) {
                sum += i;
            }
            System.out.println("Sum of numbers from 1 to " + num1 + ": " + sum);
        });

        Thread factorialThread = new Thread(() -> {
            int factorial = 1;
            for (int i = 1; i <= num2; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + num2 + ": " + factorial);
        });

   
        addThread.start();
        factorialThread.start();

        try {
       
            addThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread additionThread = new Thread(() -> System.out.println("Addition: " + (num1 + num2)));
        Thread subtractionThread = new Thread(() -> System.out.println("Subtraction: " + (num1 - num2)));
        Thread multiplicationThread = new Thread(() -> System.out.println("Multiplication: " + (num1 * num2)));
        Thread divisionThread = new Thread(() -> System.out.println("Division: " + ((double) num1 / num2)));

      
        additionThread.start();
        subtractionThread.start();
        multiplicationThread.start();
        divisionThread.start();
    }
}
