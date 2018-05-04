package lab4;
import java.util.Scanner;

public class MiniMath {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Type the problem (a: absolute value, l: logarithm with base 10, s: square root): ");
        String command = sc.next();

        System.out.print("Type the number: ");
        double num = sc.nextInt();

        if (command.equals("s")) {
            System.out.println("Answer is " + Math.sqrt(num));
        }
        else if (command.equals("a")) {
            System.out.println("Answer is " + Math.abs(num));
        }
        else if (command.equals("l")) {
            System.out.println("Answer is " + Math.log10(num));
        }
        else {
            System.out.println("Unknown Command");
        }

        sc.close();

    }

}