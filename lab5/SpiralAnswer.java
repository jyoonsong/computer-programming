package lab5;
import java.util.Scanner;

public class SpiralAnswer {
    public static void main(String [] ar) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Type a number : ");
        int n = sc.nextInt();

        int [][] m = new int [n][n];

        int dx = 1;
        int dy = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < n*n; i++) {
            m[x][y] = i+1;

            if (x+dx < 0 || x+dx >= n || y+dy < 0 || y+dy >= n || m[x+dx][y+dy] != 0) {
                if (dx == 1) {
                    dx = 0;
                    dy = 1;
                } else if (dx == -1) {
                    dx = 0;
                    dy = -1;
                } else if (dy == 1) {
                    dx = -1;
                    dy = 0;
                } else {
                    dx = 1;
                    dy = 0;
                }

            }
            x += dx;
            y += dy;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j<n; j++)
                System.out.print(m[j][i] + "\t");
            System.out.println();
        }

        // 2. recursive
        // 3. 문, 컵 모양
    }
}
