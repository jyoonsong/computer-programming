package lab6;
import java.io.*;

public class ArrayOfFives {
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 5*(i+1);

        PrintStream output = new PrintStream (new File("out.txt"));

        for(int i = 0; i < arr.length; i ++)
        {
            output.println(arr[i]);
        }

        PrintStream output2 = new PrintStream (new File("out2.txt"));

        output2.print("[" + arr[0]);

        for(int i = 1; i < arr.length; i ++)
        {
            output2.print(", " + arr[i]);
        }

        output2.print("]");
    }
}
