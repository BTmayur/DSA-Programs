//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int minIncrements(int[] arr) {
        Arrays.sort(arr);
        HashSet set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            if(set.contains(arr[i])){
                max++;
                ans += max-arr[i];
                arr[i]=max;
            }
            set.add(arr[i]);
        }
        return ans;
    }
}