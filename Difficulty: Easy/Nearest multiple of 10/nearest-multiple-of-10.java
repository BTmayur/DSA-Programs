//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public String roundToNearest(String str) {
        
        int n = str.length();
        int last = str.charAt(n - 1) - '0';
        
        char[] digits = str.toCharArray();
  
        if (last <= 5) {
            // Just round down by making the last digit '0'
            // you don't need to change the second last digit either.
            digits[n - 1] = '0';
        }
        else{
            
            // now make the last digit zero as expected
            // but for the cases like "..78" -> "..80" so we need to
            // take care of this situation and this is not just limited
            // to second last. what about "..998" -> 1000 or 
            // "34598"  -> "34600"
            
            // that's why we need a for loop in reverse order.
            digits[n - 1] = '0';
            boolean carry = true;
            
             for (int i = n - 2; i >= 0; --i) {
                if (digits[i] == '9')
                    digits[i] = '0';
                else {
                    digits[i] = (char) (digits[i] + 1);
                    carry = false; // No more carry needed
                    break;
                }
            }
            // If carry is still true, it means we had something like
            // 999, so prepend '1'
            if (carry)
                return "1" + new String(digits);
        }
        return new String(digits);
    }
}

//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends