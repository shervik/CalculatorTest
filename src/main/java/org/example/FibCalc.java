package org.example;

import static java.lang.Math.abs;

public class FibCalc {
    public long calc(int n) {
        if (n > 92) throw new IllegalArgumentException("Мы не считаем значения больше 92!");

        long[] arr = new long[abs(n) + 1];
        if (n == 0) return 0;
        if (n == 1) return 1;

        arr[0] = 0;
        arr[1] = 1;

        if (abs(n) > 1) {
            for (int i = 2; i <= abs(n); i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }

        if (n < 0) {
            if (n % 2 == 0) {
                return -arr[abs(n)];
            } else return arr[abs(n)];
        }

        return arr[n];


//        final double gold = ((1 + Math.sqrt(5)) / 2);
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return (long) ((Math.pow(gold, n) - Math.pow(-gold, -n)) / (2 * gold - 1));
    }
}
