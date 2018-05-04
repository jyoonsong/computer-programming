package lab5;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayEquality {

    public static void main(String [] ar) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type the number of Arrays : ");
        int n = sc.nextInt();

        System.out.print("Type size of Arrays : ");
        int [][] arrs = new int [n][];

        // create arrays
        for (int i=0; i<n; i++)
            arrs[i] = new int [ sc.nextInt() ];

        // add items to arrays
        for (int i=0; i<n; i++) {
            System.out.printf("Type elements of %dth Array : ", i+1);
            for (int j=0; j<arrs[i].length; j++)
                arrs[i][j] = sc.nextInt();
        }

        System.out.println( countPair( arrs ) );

        sc.close();
//         int [][] arrs = { {2,2,3}, {2,3,2}, {3,2,3}, {2,2,3}, {3,2,2} };
//         System.out.println( countPair( arrs ) );
    }

    public static int countPair( int[][] arrs ) {
        int count = 0;
        // compare ith array with kth arrays (k>i)
        for(int i = 0; i < arrs.length - 1; i++){
            // rotate ith array til it becomes original
            for (int j = 0; j < arrs[i].length; j++) {
                rotateArr(arrs[i]);
                // compare rotated array with kth array
                for (int k = i+1; k < arrs.length; k++)
                    if (Arrays.equals(arrs[i], arrs[k]))
                        count++;
            }
        }
        return count;
    }

    public static void rotateArr( int [] arr ) {
        int tmp = arr[0];
        for (int i = arr.length - 1; i > 0; i--)
            arr[(i+1) % arr.length] = arr[i];
        arr[1] = tmp;
    }
}
