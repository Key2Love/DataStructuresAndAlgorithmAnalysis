/**
 * 欧几里得算法
 * 求两个数的最大公因数
 */
class EuclidAlgorithm{
    public static int gcd(int a, int b){
        while (b != 0){
            int rem = a % b;
            a = b;
            b = rem;

        }
        return a;
    }
    public static void main(String[] args) {
        System.out.print(gcd(20, 4));
    }

}