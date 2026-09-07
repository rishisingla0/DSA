class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long exponent = n;

        if (exponent < 0) {
            return 1 / power(x, -exponent);
        }

        return power(x, exponent);
    }

    private double power(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}