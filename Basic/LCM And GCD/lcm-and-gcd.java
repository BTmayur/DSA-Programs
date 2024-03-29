//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends




class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        long gcd = findGCD(A, B);
        long lcm = findLCM(A, B, gcd);
        Long[] lng = {lcm, gcd};
        return lng;
    }
    static long findGCD(long m, long n){
        if(m == 0){
            return n;    
        }
        
        return findGCD(n % m, m);
    }
    static long findLCM(long m, long n, long gcd){
        return ((m * n) / gcd);
    }
}