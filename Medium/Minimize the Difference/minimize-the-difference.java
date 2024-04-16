//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // every index will contain the left max-min and right min-max element
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int[] lmin = new int[n];
        int[] rmin = new int[n];
        
        lmax[0] = arr[0];
        lmin[0] = arr[0];
        rmax[n-1] = arr[n-1];
        rmin[n-1] = arr[n-1];
        
        // forming arrays
        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i-1],arr[i]);
            lmin[i] = Math.min(lmin[i-1],arr[i]);
        }
        for(int i = n-2; i>= 0 ; i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        }
        
        
        // initialize by creating for first window
        int currMin = rmin[k];
        int currMax = rmax[k];
        int ans = Integer.MAX_VALUE-1;
        ans = Math.min(currMax-currMin, ans);
        for(int i = 1; i < n-k; i++){
            // repeat the process while moving the window towards right
            currMin = Math.min(lmin[i-1], rmin[i+k]);
            currMax = Math.max(lmax[i-1], rmax[i+k]);
            ans = Math.min(currMax - currMin, ans);
        }
        // the window will left the last index so check out the last index additinally
        currMin = lmin[n-k-1];
        currMax = lmax[n-k-1];
        ans = Math.min(currMax - currMin, ans);
        // return the final answer
        return ans;
    }
}
        