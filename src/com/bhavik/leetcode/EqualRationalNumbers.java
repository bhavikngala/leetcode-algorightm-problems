package com.bhavik.leetcode;

/**
 * Link: https://leetcode.com/problems/equal-rational-numbers
 *
 * Topic: Strings; Difficulty: Hard
 *
 * Time complexity  = O(n)
 * Space complexity = O(n)
 *
 * Passes: Input: s = "0.(52)", t = "0.5(25)"
 * Passes: Input: s = "0.1666(6)", t = "0.166(66)"
 * Fails : Input: s = "0.9(9)", t = "1."; s = 0.9999 = 1. so the function should return true.
 *
 */
public class EqualRationalNumbers {

    private boolean DEBUG_FLAG = false;

    public boolean isRationalEqual(String s, String t) {
        int m = Math.max(s.length(), t.length()); // length of the longest String; Used for loop termination;
        iprint(String.valueOf(m), "m");

        iprint(s, "~~~~~~~~~~~~~~~ s ~~~~~~~~~~~~~~~");
        String s1 = getNewRepresentationForNumber(s, m);
        iprint(s1, "s1");
        iprint(t, "~~~~~~~~~~~~~~~ t ~~~~~~~~~~~~~~~");
        String t1 = getNewRepresentationForNumber(t, m);

        iprint(t1, "t1");

        return s1.equals(t1);
    }

    private String getNewRepresentationForNumber(String s, int m) {
        StringBuilder s1 = new StringBuilder();

        int parenStart = 0; // index for parenthesis
        int parenEnd   = 0; // index for parenthesis

        int looper = Math.min(m, s.length());

        // Add all the digits to StringBuilder s1
        for (int i = 0; i < looper; i++) {
            if (s.charAt(i) == '(') {
                parenStart = i;
                continue;
            }

            if (s.charAt(i) == ')') {
                parenEnd = i;
                break;
            }

            s1 = s1.append(s.charAt(i));
        }

        if (parenStart == 0 && parenEnd == 0) {
            return s1.toString();
        }

        iprint(String.valueOf(parenStart), "parenStart");
        iprint(String.valueOf(parenEnd), "parenEnd");
        iprint(s1.toString(), "First Loop");

        // Fill extra digits with repeating digits
        int currentRepeatingLength = 1;
        for (int i = parenEnd - 1; i < m; i++) {
            s1 = s1.append(s.charAt(parenStart + currentRepeatingLength));
            currentRepeatingLength = currentRepeatingLength + 1;

            if (currentRepeatingLength == parenEnd - parenStart) {
                currentRepeatingLength = 1;
            }
        }

        return s1.toString();
    }

    public static void main(String[] args) {
        EqualRationalNumbers e = new EqualRationalNumbers();

        e.isRationalEqual("0.(52)", "0.5(25)");
        e.isRationalEqual("0.166(6)", "0.1(6)");
        e.isRationalEqual("0.9(9)", "1.");
    }

    private void iprint(String s, String msg) {
        if (DEBUG_FLAG) {
            System.out.println(String.format("%s: %s", msg, s));
        }
    }
}
