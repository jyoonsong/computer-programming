package lab8;
public class CheckShapes {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c.getArea());
//        Object o = new Circle(3);
        Shape o = new Circle(4);
        double m = o.getArea();
        System.out.println(o);
        Object a = new int [30];
    }
}

class Circle implements Shape {

    double radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public String toString() {
        return "Circle";
    }
}

class Triangle implements Shape {

    // 3 sides
    int a;
    int b;
    int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt( p * (p-a) * (p-b) * (p-c) );
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }


}

class Rectangle implements Shape {
    int height;
    int base;

    public Rectangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double getArea() {
        return height * base;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + base);
    }
}