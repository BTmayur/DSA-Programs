//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> ans =new ArrayList<Integer>(); 
        int a=-1,b=-1,i=0;
         while(i<=n/2){
            a=isprime(i);
            i++;
            while(a==-1&&i<=n/2){
                a=isprime(i);
                i++;
            }
            b=isprime(n-a);
            if(a<=b&& a+b==n){
                ans.add(a);
                ans.add(b);
                break;
            }
        }
        if(ans.size()==0){
            ans.add(-1);
            ans.add(-1);
        }
        return ans;
    }
    static int isprime(int n){
        int cnt = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){ 
            if(n % i == 0){ 
                cnt = cnt + 1;
                if(n / i != i){
                    cnt = cnt + 1;
                }
            }
        }
        if(cnt == 2){
            return n;
        }
        else{ 
            return -1;
        }
    }
}