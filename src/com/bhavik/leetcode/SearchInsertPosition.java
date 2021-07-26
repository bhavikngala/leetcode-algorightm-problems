package com.bhavik.leetcode;

import com.bhavik.leetcode.commons.Utils;

/**
 * https://leetcode.com/problems/search-insert-position/submissions/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {

    String DEBUG_1 = "Left: %d || Right: %d || Middle: %d";
    String DEBUG_2 = "Termination. Left: %d || Right: %d";

    public int searchInsert(int[] nums, int target) {
        System.out.println("----------------------------------------");
        System.out.println("nums: " + Utils.intArrayToString(nums) + " target: " + target);
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
        if ( right == left || right - left == 1) {
            System.out.println(String.format(DEBUG_2, left, right));
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else if (nums[left] > target) {
                return left;
            } else if (nums[right] > target) {
                return right;
            } else if (nums[right] < target) {
                return right + 1;
            } else {
                return 0;
            }
        }

        int middle = left + (right - left + 1)/2;

        System.out.println(String.format(DEBUG_1, left, right, middle));

        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return searchInsert(nums, target, left, middle - 1);
        } else {
            return searchInsert(nums, target, middle + 1, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();

        String outputString = "Expected index: %d || actual index: %d";
        System.out.println(String.format(outputString, 2, sip.searchInsert(new int[]{1, 3, 5, 6}, 5)));
        System.out.println(String.format(outputString, 1, sip.searchInsert(new int[]{1, 3, 5, 6}, 2)));
        System.out.println(String.format(outputString, 4, sip.searchInsert(new int[]{1, 3, 5, 6}, 7)));
        System.out.println(String.format(outputString, 0, sip.searchInsert(new int[]{1, 3, 5, 6}, 0)));
        System.out.println(String.format(outputString, 2, sip.searchInsert(new int[]{1, 3, 5}, 4)));
        System.out.println(String.format(outputString, 6, sip.searchInsert(new int[]{1, 2, 4, 6, 8, 9, 10}, 10)));
    }
}
