//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        Node p=head;
        int n=0;
        while(p!=null)
        {
            n++;
            p=p.next;
        }
        int arr[]=new int[n];
        int f=0;
        int b=n-1;
        Node pt=head;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[f]=pt.data;
                pt=pt.next;
                f++;
            }
            else
            {
                arr[b]=pt.data;
                pt=pt.next;
                b--;
            }
        }
        Arrays.sort(arr);
        Node h=head;
        for(int i=0;i<n;i++)
        {
            h.data=arr[i];
            h=h.next;
        }
        return head;
   }

}