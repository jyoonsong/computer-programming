package lab7;
import java.util.Scanner;

public class Complex {

    public int real;
    public int img;

    public Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get first complex number
        System.out.print("Input the real part of first number : ");
        int real1 = sc.nextInt();
        System.out.print("Input the imaginary of first number : ");
        int img1 = sc.nextInt();
        Complex c1 = new Complex(real1, img1);

        // get second complex number
        System.out.print("Input the real part of second number : ");
        int real2 = sc.nextInt();
        System.out.print("Input the imaginary of second number : ");
        int img2 = sc.nextInt();
        Complex c2 = new Complex(real2, img2);

        sc.close();

        // sum
        System.out.println("Sum : " + c1.add(c2).toString());
        // diff
        System.out.println("Difference : " + c1.diff(c2).toString());

    }

    public String toString() {
        String r = real + "";
        String i = img + "i";
        if (real == 0 && img == 0) // 0 0
            return "0";
        else if (img == 0) // x 0
            return r;
        else if (real == 0) { // 0 x
            return i;
        }
        if (img < 0)
            return real + "" + img + "i";
        return real + "+" + img + "i";
    }

    // Get two complex values and return their sum.
    public Complex add(Complex b) {
        return new Complex(this.real + b.real, this.img + b.img);
    }

    // Get two complex values (x and y), and return their difference (x – y).
    public Complex diff(Complex b) {
        return new Complex(this.real - b.real, this.img - b.img);
    }

}
