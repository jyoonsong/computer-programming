package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindSmallestContainer {
    public int count;
    public Point [] points;

    public FindSmallestContainer() {
        points = new Point[100];
        count = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FindSmallestContainer app = new FindSmallestContainer();
        app.setPoints("points.txt");
        System.out.println( app.getNumberOfPoints() );
        app.getRadius();
    }

    public void setPoints(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner in = new Scanner(f);
        while (in.hasNextLine()) {
            points[count] = new Point( in.nextDouble(), in.nextDouble() );
//            in.nextLine();
            count++;
        }
    }

    public int getNumberOfPoints() {
        return count;
    }

    public void getRadius() {
        double minRadius = -1;
        // set point i as center
        for (int i = 0; i < count; i++) {
            // save maximum distance which is minimum radius for point i
            double maxDistance = 0;
            for (int j = 0; j < count; j++) {
                if ( i !=j ) {
                    // if distance is bigger set it as maximum
                    double d = distanceOf(points[i], points[j]);
                    if (d > maxDistance) {
                        maxDistance = d;
                    }
                }
            }
            // if maxDistance is smaller set it as minRadius
            if (minRadius > maxDistance || minRadius == -1) minRadius = maxDistance;

        }
        // print
        System.out.println(minRadius);
    }

    private double distanceOf(Point a, Point b) {
        return Math.sqrt( Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) );
    }
}

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
