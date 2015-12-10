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

	public RatNum(String s){
		this(parse(s));
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
     * Finds the lcd of two numbers n and m.
     *
     * @param m non-zero int
     * @param n non-zero int
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
        RatNum bajs = new RatNum(1, 2);
        RatNum bajs2 = new RatNum(2, 1);
        System.out.println(bajs.toString());
        System.out.println(bajs.add(bajs2));
        System.out.println(bajs.sub(bajs2));
        System.out.println(bajs.mul(bajs2));
        System.out.println(bajs.div(bajs2));
        System.out.println(bajs.equals(bajs2));
        System.out.println(bajs.equals(bajs));
        System.out.println(bajs.lessThan(bajs2));
        System.out.println(bajs2.lessThan(bajs));
    }

    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return denom;
    }

    public RatNum add(RatNum other) {
        return new RatNum(num * other.denom + denom * other.num, denom * other.denom);
    }

    public RatNum sub(RatNum other) {
        return new RatNum(num * other.denom - denom * other.num, denom * other.denom);
    }

    public RatNum mul(RatNum other) {
        return new RatNum(this.num * other.num, this.denom * other.denom);
    }

    public RatNum div(RatNum other) {
        return new RatNum(this.num * other.denom, this.denom * other.num);
    }

    public boolean equals(RatNum other) {
        return (num == other.num && denom == other.denom);
    }

    public boolean lessThan(RatNum other) {
        return toDouble() < other.toDouble();
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

	public static RatNum parse(String s){
		int a;
		int b;
				
		try {
			a = Integer.parseInt(s);
			b = 1;
			return new RatNum(a,b);
		}
		catch (Exception e1){
			try{
				String[] numList = s.split("/");
				if(numList.length == 2)
					return new RatNum(Integer.parseInt(numList[1]), Integer.parseInt(numList[1]));
				else
					throw new IllegalArgumentException("String does not have correct format!\nToo many '/'s!");
			}
			catch (Exception e2){
				throw new IllegalArgumentException("String does not have correct format!\nNot a fractional number!");
			}
		}
	}

    public Object clone() {
        return new RatNum(this);
    }

    public double toDouble() {
        return ((double) num) / denom;
    }

    public String toString() {
        if (num <= denom)
            return (num + "/" + denom);
        else
            return (num / denom + " " + num % denom + "/" + denom);
    }
}