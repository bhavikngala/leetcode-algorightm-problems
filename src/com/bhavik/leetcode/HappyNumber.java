package com.bhavik.leetcode;

import java.util.HashSet;

public class HappyNumber {

    private static String DEBUG_1 = "n: %d || Sum of digits: %d";

    private static int LIMIT = 1000;

    public boolean isHappy(int n) {
        int counter = 0;
        return isHappy(n, new HashSet<>(), counter);
    }

    private boolean isHappy(int n, HashSet<Integer> previousNumbers, int counter) {
        if (n == 1) {
            return true;
        }

        if (counter > LIMIT) {
            return false;
        }

        int sumOfSquareOfDigits = getSumOfSquareOfDigits(n);
        previousNumbers.add(sumOfSquareOfDigits);

        System.out.println(String.format(DEBUG_1, n, sumOfSquareOfDigits));

        return isHappy(sumOfSquareOfDigits, previousNumbers, counter + 1);
    }

    private int getSumOfSquareOfDigits(int n) {
        int sumOfSquareOfDigits = 0;

        while(n > 0) {
            int digit = n%10;
            sumOfSquareOfDigits += digit*digit;
            n = n/10;
        }

        return sumOfSquareOfDigits;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        String outputString = "n: %d || expected: %s || actual: %s";
        System.out.println(String.format(outputString, 19, true, happyNumber.isHappy(19)));
    }
}
