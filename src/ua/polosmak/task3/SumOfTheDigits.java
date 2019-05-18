package ua.polosmak.task3;

import java.math.BigInteger;

/**
 * @author Roman Polosmak
 */

public class SumOfTheDigits {
    private static BigInteger res = BigInteger.ONE;

    /**
     * @param n input number for finding factorial
     * @return res
     */
    private static BigInteger factorial(int n) {
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    /**
     * @param s the string that receives the factorial value
     * @return sum of the digits
     */
    private static int calculateSumOfTheDigits(String s) {
        int sum = 0;
        s = res + "";
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.charAt(i) + "");

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("{Correct answer: "
                + calculateSumOfTheDigits(factorial(100).toString()) + "}");
    }
}