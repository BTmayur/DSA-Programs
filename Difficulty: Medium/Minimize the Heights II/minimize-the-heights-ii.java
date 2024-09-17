//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n=arr.length;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        Arrays.sort(arr);
        int ans=arr[n-1]-arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>=k){
                max=Math.max(arr[i-1]+k,arr[n-1]-k);
                min=Math.min(arr[0]+k,arr[i]-k);
                ans=Math.min(ans,max-min);
            }
            else continue;
        }
        return ans;
        
    }
}


