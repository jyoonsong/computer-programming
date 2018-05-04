package lab5;
import java.util.Scanner;

public class IndexWord {

    // task 1
    public static void main(String [] ar) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type a string : ");
        String str = sc.next();

        System.out.println( processStr(str) );

        sc.close();
    }

    public static String processStr(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++)
            result += str.charAt(i) + "" + (i+1);

        return result;
    }
}
