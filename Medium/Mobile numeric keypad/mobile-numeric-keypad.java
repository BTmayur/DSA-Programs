//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
       if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 10; // Each digit from 0 to 9
        }

        // Possible moves from each digit
        int[][] moves = {
            {0, 8},    // 0
            {1, 2, 4}, // 1
            {2, 1, 3, 5}, // 2
            {3, 2, 6}, // 3
            {4, 1, 5, 7}, // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9}, // 6
            {7, 4, 8}, // 7
            {8, 5, 7, 9, 0}, // 8
            {9, 6, 8}  // 9
        };

        // Initialize DP table
        long[][] dp = new long[10][n + 1];

        // Base case: for sequences of length 1
        for (int i = 0; i <= 9; i++) {
            dp[i][1] = 1;
        }

        // Fill the DP table
        for (int j = 2; j <= n; j++) {
            for (int i = 0; i <= 9; i++) {
                dp[i][j] = 0;
                for (int move : moves[i]) {
                    dp[i][j] += dp[move][j - 1];
                }
            }
        }

        // Sum up the results for sequences of length n
        long totalSequences = 0;
        for (int i = 0; i <= 9; i++) {
            totalSequences += dp[i][n];
        }

        return totalSequences;
    }

    }