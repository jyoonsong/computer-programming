import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static int k = 2;

    public static void main(String[] args) throws FileNotFoundException {
        // 1
        int i;
        int [] a = new int [6];
        for (i=0; ++i<5;) a[i] = i*10; // 1-10, 2-20, 3-30, 4-40, 5
        for (--i; --i>0;) System.out.printf("%d - %d \n", i, a[i]); // 3-30, 2-20, 1-10, 0

        for (i=0; i++<5;) System.out.println(i);

        // 2
        k = 2;
        int b = f1(0) + f2(0);
        System.out.println();

        // 3
        int i3, j3;
        i3 = j3 = 10;
        printMax((i3++), (j3++));
        System.out.printf("i=%d, j+%d", i3, j3);
        System.out.println();

        // lab 5 - example
        String name = "e1v2e3n n4u5m6b7e8r i1n2d3e4x w5i6l7l b8e p2r3i4n5t6e7d"; String result = "";
        for(int i4=0; i4 < name.length(); i4=i4+2) {
            result=result+name.substring(i4,i4+1);
        } System.out.print(result);
        System.out.println();


        // array reversal
        int [] arr = {5, 7, 3, 9, 1};
        reverse(arr);
        int [] merged = merge(arr, stutter(arr));
        System.out.println(Arrays.toString(merged));

        // etc
        int x = 3;
//        Scanner in = new Scanner(System.in);
//        String cd = in.next();
//        String ab = "ab";
//        changeStr(ab);
//        in.close();
//        System.out.println((ab == cd) + " is " + ab);
        System.out.println( 5 * 7 < 3 + 5 * (7 - 1) || ++x != x++ );
        System.out.println(x);
        System.out.println(Math.floor(-3.3));

        PrintStream p = new PrintStream(new File("out.txt"));
        p.printf("%s", "hi there");
    }

    public static int[] merge(int[] a1, int[] a2) {
        int [] result = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++)
            result[i] = a1[i];
        for (int i = 0; i < a2.length; i++)
            result[a1.length + i] = a2[i];
        return result;
    }

    public static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) { // only half!!!
            // swap
            int tmp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = tmp;
        }
    }


    public static int[] stutter(int[] numbers) {
        int [] result = new int[2*numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[2*i] = numbers[i];
            result[2*i + 1] = numbers[i];
        }
        return result;
    }

    public static void changeStr(String ab) {
        ab += "c";
    }

    public static int f1(int k) {
        if (k<5)
            System.out.printf("%d ", f2(k+1));
        return k;
    }

    public static int f2(int k) {
        if (k<6)
            System.out.printf("%d ", f1(k+1));
        return k;
    }

    public static void printMax(int x, int y) {
        System.out.printf("the max of %d and %d is ", x, y);
        System.out.printf("%d\n", (x>y?x:y));
    }

}
