package lab8;
public class Table {
    public static void main(String[] args) {
        // 1 2 4 7 11
        // 3 5 8 12 16
        // 6 9 13 17 20
        // 10 14 18 21 23
        // 15 19 22 24 25
        // 문제
        int [][] table = new int[5][5];

        // 00 01 02 03 04
        // 10 11 12 13 14
        // 20 21 22 23 24
        // 30 31 32 33 34
        // 40 41 42 43 44

        int cnt = 1;
        for (int i=0; i<9; i++) {
            for (int j=0; j<=i; j++) {
                if (j<5 && i-j<5) {
                    table[j][i - j] = cnt;
                    cnt++;
                }
            }
        }

        for (int i=0; i < table.length; i++) {
            for (int j=0; j < table.length; j++)
                System.out.print(table[i][j] + "\t");
            System.out.println();
        }
    }
}
