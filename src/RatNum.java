/**
 * A program that
 *
 * @author Mårten Skogh
 * @author Adam Tonderski
 * @author Group121
 * @version 1.0
 */
public class RatNum {

    private int num;
    private int denom;

    public RatNum(int num, int denom) throws IllegalArgumentException {
        if (denom == 0)
            throw (new NumberFormatException("Denominator equal to 0!"));
        if (num == 0) {
            this.num = 0;
            this.denom = 1;
            return;
        }
        this.num = num;
        this.denom = denom;
        shorten();
    }

    public RatNum(RatNum r) {
        num = r.getNumerator();
        denom = r.getDenominator();
    }

    public RatNum(int a) throws IllegalArgumentException {
        this(a, 1);
    }

    public RatNum() throws IllegalArgumentException {
        this(0, 1);
    }

    /**
     Finds the lcd of two numbers n and m.
     @param m non-zero int
     @param n non-zero int
     */
    public static int sgd(int m, int n) throws IllegalArgumentException {
        if (m == 0 || n == 0)
            throw (new IllegalArgumentException("Number equal to 0!"));
        int r = Math.abs(m) % Math.abs(n);
        if (r == 0)
            return n;
        return (sgd(n, r));
    }

    public static void main(String[] args) {
        RatNum bajs = new RatNum(1, 8);
        System.out.println(bajs.toString());
    }

    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return denom;
    }

    private void shorten() {
        int g = sgd(num, denom);

        if (Math.signum(num) == Math.signum(denom)) {
            this.num = Math.abs(num / g);
            this.denom = Math.abs(denom / g);
        } else {
            this.num = -Math.abs(num / g);
            this.denom = Math.abs(denom / g);
        }
    }

    public String toString() {
        return (num + "/" + denom);
    }
}