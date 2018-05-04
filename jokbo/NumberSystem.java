package jokbo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberSystem {
    public static int [] rooms = new int [100];
    public static int currSum = 0;

    public static void main(String[] args) {
        // 2015-3
        Scanner stu = new Scanner("in 65\nout 20\nin 100\nout 77");
        while (stu.hasNextLine()) {
            student(stu.nextLine());
        }
        // 2015-2
        String s = "I like apple but I like banana too.";
        sortFreq(s);

        // 2015-1
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = in.nextInt();
        getNum(n, b);
        in.close();
    }

    private static void student(String s) {
        String[] inputs = s.trim().split("\\s+");
        int diff = Integer.parseInt(inputs[1]);

        if (s.startsWith("in")) {
            currSum += diff;
        }
        else if (s.startsWith("out")) {
            currSum -= diff;
        }

        int roomCnt = (int) Math.ceil(currSum / 50.0);

        if (currSum % 50 >= 25) {
            for (int i = 0; i < currSum / 50; i++)
                rooms[i] = 50;
            rooms[roomCnt - 1] = currSum % 50;
        }
        else {
            int avg = (int) Math.ceil( (double) currSum / roomCnt);
            for (int i = 0; i < currSum / 50; i++)
                rooms[i] = avg;
            if (currSum % avg == 0)
                rooms[roomCnt - 1] = avg;
            else
                rooms[roomCnt - 1] = currSum % avg;
        }

        // print result
        for (int i = 0; i < roomCnt; i ++)
            System.out.print(rooms[i] + " ");
        System.out.println();
    }

    private static void sortFreq(String s) {
        s = s.replaceAll("\\.", " ").trim();
        String [] words = s.split("\\s+");
        ArrayList<Freq> f = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int index = find(f, words[i]);
            if ( index >= 0 )
                f.get(index).count++;
            else
                f.add(new Freq(words[i]));
        }

        sort(f);

        for (int i = 0; i < f.size(); i++) {
            System.out.println(f.get(i).word + ": " + f.get(i).count);
        }
    }

    private static void sort(ArrayList<Freq> f) {
        int n = f.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (f.get(j).compareTo(f.get(j+1)) <= 0) {
                    Freq tmp = f.get(j);
                    f.set(j, f.get(j+1));
                    f.set(j+1, tmp);
                }
    }

    private static int find(ArrayList<Freq> f, String word) {
        for (int i = 0; i < f.size(); i++) {
            if ( f.get(i).word.equals(word) )
                return i;
        }
        return -1;
    }



    private static void getNum(int n, int b) {
        String s = "";
        while (n > 0) {
            if (n%b > 9) {
                s += getChar(n%b);
            }
            else
                s += n%b;
            n /= b;
        }
        for (int i = s.length() - 1; i >= 0; i--)
            System.out.print( s.substring(i, i+1) );
    }

    private static char getChar(int i) {
        char c = 'A';
        for (int j = 0; j < (i-10) && c < 'Z'; j++) {
            c++;
        }
        return c;
    }

}

class Freq {
    String word;
    int count;

    public Freq(String word) {
        this.word = word;
        this.count = 1;
    }

    public int compareTo(Freq o) {
        if (count > o.count)
            return 1;
        else if (count < o.count)
            return -1;
        else
            return -1 * word.compareTo(o.word);
    }
}
