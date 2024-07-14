//{ Driver Code Starts


// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            new Solution().segregate0and1(arr);
            for (int i = 0; i < array.size(); i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void segregate0and1(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            // Increment left index while we see 0 at left
            while (arr[left] == 0 && left < right) {
                left++;
            }
            
            // Decrement right index while we see 1 at right
            while (arr[right] == 1 && left < right) {
                right--;
            }
            
            // If left is smaller than right then there is a 1 at left
            // and a 0 at right. Exchange arr[left] and arr[right]
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
    
    // Test the function with example inputs
    public static void main(String[] args) {
        int[] arr1 = {0, 0, 1, 1, 0};
        segregate0and1(arr1);
        System.out.println(Arrays.toString(arr1)); // Output: [0, 0, 0, 1, 1]

        int[] arr2 = {1, 1, 1, 1};
        segregate0and1(arr2);
        System.out.println(Arrays.toString(arr2)); // Output: [1, 1, 1, 1]
    }
}