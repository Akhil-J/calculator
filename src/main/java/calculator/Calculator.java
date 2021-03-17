
package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calcobject = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        do {
            System.out.println("Calculator-DevOps mini project, Choose an option to perform the operation");
            System.out.print("Press 1 to find factorial \nPress 2 to find Square root \nPress 3 to find power \nPress 4 to find natural logarithm \n" +
                    "Press 5 to exit \nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // do factorial
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("Factorial of "+num1+" is : " + calcobject.factoral(num1));
                    System.out.println("\n");

                    break;
                case 2:
                    // find square root
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("Square root of "+num1+" is : " + calcobject.sqroot(num1));
                    System.out.println("\n");


                    break;
                case 3:
                    // find power
                    System.out.print("Enter the 1st number : ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter the 2nd number : ");
                    num2 = scanner.nextDouble();
                    System.out.println(num1+ " raised to power "+num2+" is : " + calcobject.power(num1, num2));
                    System.out.println("\n");
                    break;
                case 4:
                    // find natural log
                    System.out.print("Enter a number : ");
                    num1 = scanner.nextDouble();
                    System.out.println("Natural log of "+num1+" is : " + calcobject.naturalLog(num1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }


    public double factoral(double number1) {
        logger.info("[FACTORIAL] - " + number1);
        double result = fact(number1);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }



    public double sqroot(double number1) {
        logger.info("[SQ ROOT] - " + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }


    public double power(double number1, double number2) {
        logger.info("[POWER - " + number1 + " RAISED TO] " + number2);
        double result = Math.pow(number1,number2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double number1) {
        logger.info("[NATURAL LOG] - " + number1);
        double result = 0;
        try {

            if (number1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(number1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
    public double fact(double num) {
        double factoresult = 1;
        for(int i = 1; i <= num; ++i)
        { factoresult *= i;   }
        return  factoresult;
    }
}
