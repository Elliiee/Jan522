public class Q50 {
    //pow(x, n)
    private double fastPow(double x, long n){
        if (n == 0) return 1;

        double half = fastPow(x, n / 2);
        if (n % 2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n){
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N; // become positive
        }

        return fastPow(x, N);
    }
}
