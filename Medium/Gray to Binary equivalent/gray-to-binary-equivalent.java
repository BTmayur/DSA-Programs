//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static int grayToBinary(int n) {
        int ans = 0;
        for(int i = 30 ; i >= 0 ; i--){
            if((n&(1<<i))==0){
                if((ans&(1<<(i+1)))!=0){
                    ans+= 1<<i;
                }
            }else{
                if((ans&(1<<(i+1)))==0){
                    ans+= 1<<i;
                }
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends