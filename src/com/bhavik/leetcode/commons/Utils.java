package com.bhavik.leetcode.commons;

public class Utils {

    public static String intArrayToString(int[] array) {
        StringBuilder output = new StringBuilder("{");

        for (int i: array) {
            output.append(i);
            output.append(" ,");
        }
        output.append("}");

        return output.toString();
    }
}
