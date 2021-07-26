package com.bhavik.leetcode;

/**
 * Link: https://leetcode.com/problems/find-center-of-star-graph/
 *
 * Topic: Graph; Difficulty: Easy
 *
 * Time complexity  = k
 * Space complexity = k
 */
public class FindCenterofStarGraph {

    public int findCenter(int[][] edges) {

        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        if (firstEdge[0] == secondEdge[0]) {
            return firstEdge[0];
        } else if (firstEdge[0] == secondEdge[1]) {
            return firstEdge[0];
        } else {
            return firstEdge[1];
        }
    }
}
