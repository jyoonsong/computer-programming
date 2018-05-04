package lab3;
public class SumDigits {

    public static void main (String [] args) {
        long num = 31415;
        System.out.println( sumDigits(num) );
    }

    // recursive
    public static int sumDigits(long num) {
        if (num < 10)
            return (int) num;
        else {
            long rest = num / 10;
            long last = num % 10;
            return (int) (sumDigits(rest) + last);
        }
    }

    // non-recursive
    public static int sumDigits2(long n) {
        n = Math.abs(n); // handle negatives
        long sum = 0;
        while (n > 0) {
            sum=sum+(n%10); // add last digit
            n = n / 10; // remove last digit
        }
        return (int) sum;
    }
}
