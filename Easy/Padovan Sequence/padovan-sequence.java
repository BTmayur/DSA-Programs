//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        long [] arr= new long[n+1];
        long m = 1000000007;
        
        if(n<3){
            
            return 1;
        }
        else{
            arr[0] =1;
        arr[1]=1;
        arr[2]=1;
        
        for(int i=3; i<=n;i++){
            arr[i] = (arr[i-2]+arr[i-3])%m;
        }
        
        int ans = (int)arr[n];
        return ans;
        }
        
    }
    
}