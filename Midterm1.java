import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Midterm1 {

    public static Point [] points;
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);
        File output = new File(args[1]);
        Scanner in = new Scanner(input);
        savePoints(in);
        in.close();

        PrintStream out = new PrintStream(output);
        getMinMax(out);
        out.close();


    }

    public static void savePoints(Scanner in) {
        points = new Point [ in.nextInt() ];
        int i = 0;
        while (in.hasNextLine()) {
            points[i] = new Point( in.nextInt(), in.nextInt() );
            i++;
        }
    }

    public static void getMinMax(PrintStream out) {
        double max = -1;
        double min = -1;

        ArrayList<Pair> maxPair = new ArrayList<>();
        ArrayList<Pair> minPair = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double curr = points[i].distance(points[j]);
                // update max
                if (curr > max || max == -1) {
                    max = curr;
                    maxPair.clear();
                    maxPair.add( new Pair(points[i], points[j]) );
                }
                else if (curr == max) {
                    maxPair.add( new Pair(points[i], points[j]) );
                }
                // update min
                if (curr < min || min == -1) {
                    min = curr;
                    maxPair.clear();
                    minPair.add( new Pair(points[i], points[j]) );
                }
                else if (curr == min) {
                    minPair.add( new Pair(points[i], points[j]) );
                }
            }
        }

        // print max
        out.println("The farthest pair" + printPlural(maxPair));
        for (int i = 0; i < maxPair.size(); i++)
            out.println(maxPair.get(i).toString());

        // print min
        out.println("The closest pair" + printPlural(minPair));
        for (int i = 0; i < minPair.size(); i++)
            out.println(minPair.get(i).toString());

    }

    private static String printPlural(ArrayList<Pair> p) {
        if (p.size() > 1)
            return "s are:";
        return " is:";
    }

}

class Pair {
    Point p1;
    Point p2;

    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toString() {
        return "(" + p1.toString() + "), (" + p2.toString() + ")";
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point o) {
        return Math.sqrt( Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) );
    }

    public String toString() {
        return x + ", " + y;
    }
}
