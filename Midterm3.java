import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Midterm3 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner( new File(args[0]) );
//        PrintStream out = new PrintStream( new File(args[1]) );

//        while (in.hasNextLine()) {
//            in.next();
//        }
        String s = " I like banana, but apple\n is good too. I hate fish.";
        countWords(s);
    }

    public static void countWords(String s) {
        s = s.replaceAll(",|\\.|\\n", " ").trim();
        String [] words = s.split("\\s+");
        int [] wordCounts = new int [words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            wordCounts[i] = words[i].length();
            sum += words[i].length();
        }
        double avg = (double) sum / words.length;
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > avg)
                num++;
        }

        System.out.println("Number of words = " + words.length);
        System.out.printf("Average length of a word = %.2f\n", avg);
        System.out.println("Number of words above the average length = " + num);
    }
}
