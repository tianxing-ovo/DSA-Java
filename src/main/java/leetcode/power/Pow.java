package leetcode.power;

/**
 * 50.Pow(x, n)
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
    }

    /**
     * 1 0 1 0
     * 8 4 2 1
     */
    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 1 / quickPow(x, -(n + 1)) * x;
        }
        return n > 0 ? quickPow(x, n) : 1 / quickPow(x, -n);
    }

    public static double quickPow(double x, int n) {
        double d = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                d *= x;
            }
            x *= x;
            n >>= 1;
        }
        return d;
    }
}
