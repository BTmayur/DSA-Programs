//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        int start = 0, end = n-2;
        int index = start;
        if(arr2.length==0){
            return 0;
        }
        if(arr1[start]!=arr2[start]){
            return start;
        }
        while(start<=end){
            int mid = (start+end)/2;
            if(arr1[mid]==arr2[mid]){
                start = mid+1;
            }
            else if(arr1[mid]!=arr2[mid]){
                end = mid-1;
                index = mid;
            }
        }
        if(index == 0){
            return n-1;
        }
        else{
            return index;
        }
    }
}