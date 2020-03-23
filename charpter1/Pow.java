package charpter1;

/**
 * Pow 求幂2
 */

class Pow {
    public static long pow(long x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return x * pow(x * x, (n - 1) / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(4, 3));
    }
}