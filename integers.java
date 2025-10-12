class integers {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to positive long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            // Exponentially increase temp to subtract bigger chunks
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }

    // Main method to run the code
    public static void main(String[] args) {
        integers sol = new integers();

        int dividend1 = 10, divisor1 = 3;
        int dividend2 = 7, divisor2 = -3;

        System.out.println("10 / 3 = " + sol.divide(dividend1, divisor1));
        System.out.println("7 / -3 = " + sol.divide(dividend2, divisor2));
    }
}
