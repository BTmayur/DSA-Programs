//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String s) {
        // code here
        String arr[] = s.split(" ");
        long max = -1;
        for(String st : arr){
            if(st.charAt(0)-'0' >= 0 && st.charAt(0)-'0' <= 9){
                if(!st.contains("9")){
                    long convert = Long.parseLong(st);
                    if(convert > max)max = convert;
                }
            }
        }
        return max;
    }
}