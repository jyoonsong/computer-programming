package lab7;

public class Binomial {
    public static void main(String[] args) {

        // optional task 1 : map method
        System.out.println( map("125*x^3+34*x^2-17*x^1+25", 1) );

        // optional task 2 : findcomb method
        System.out.println( findcomb(5, 3, 7) );
    }

    public static String findcomb(int n, int k, int index) {
        String result = "";
        int pos = index;
        int num = 1;
        for (int i = 0; i < k; i++) {
            while (pos >= n_choose_k(n - num, k - i - 1) && num < n) {
                pos -= n_choose_k(n - num, k - i - 1);
                num++;
            }
            result += num;
            num++;
        }
        return result;
    }

    public static long n_choose_k(int n, int k) {
        if (k > n-k)
            k = n-k;
        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--)
            b = b * m / i;
        return b;
    }

    public static int map(String func, int x) {
        int result = 0;

        func = func.replaceAll("-", "+-");
        String [] tmp = func.split("\\+");
        Term [] terms = new Term[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            if ( tmp[i].contains("*x^") ) {
                String [] nums = tmp[i].split("\\*x\\^");
                terms[i] = new Term( Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
            }
            else
                terms[i] = new Term( Integer.parseInt(tmp[i]) );
        }

        for (int i = 0; i < terms.length; i++)
            result += terms[i].calcTerm(x);

        return result;
    }
}

class Term {
    int coef;
    int exp;

    public Term(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public Term(int coef) {
        this(coef, 0);
    }

    public int calcTerm(int x) {
        return coef * (int) Math.pow(x, exp);
    }
}
