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
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        String str = "";
        for(int i=0;i<r;i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    str += "10";
                }else{
                    str += "01";
                }
                if(str.length()>s.length()){//if curr string length > orighinal string length then break;.
                    break;
                }
            }
            s = str;
            str = "";
        }
        return s.charAt(n);
    }
}