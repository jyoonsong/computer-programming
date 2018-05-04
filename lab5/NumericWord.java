package lab5;
import java.util.Scanner;

public class NumericWord {

    // task 2
    public static void main(String [] ar) {

        numPerfect(1000);

        Scanner sc = new Scanner(System.in);

        System.out.print("Type a number : ");
        String str = sc.next();

        System.out.println( processStr( str ) );

        sc.close();
    }

    public static int processStr(String str) {
        int result = 0;
        int num = Integer.parseInt(str);

        while (num>0) {
            result += num%10;
            num/=10;
        }

        return result;
    }

    public static void numPerfect(int input){
        if(input <= 0){
            System.out.println("Input should be positive number!");
        }

        int result = 0;
        String perfect = "";

        for(int i = 1; i < input; i++){
            boolean isPerfect = false;
            int checkSum = 0;
            for(int j = 1; j <= i/2; j++){
                //if 'j' is positive divisor of 'i', add 'j' to checkSum
                if(i % j == 0){
                    checkSum = checkSum + j;  //checkSum += j;
                }
            }
            //if total sum of positive divisors is the same with 'i', 'i' is perfect number.
            if(checkSum == i) {
                isPerfect = true;
            }
            //The number of perfect number increases.
            if(isPerfect) {
                result += 1; //result++;
                perfect = perfect + checkSum + " ";
            }

        }

        System.out.println("count: " + result);
        System.out.println(perfect);
    }
}
