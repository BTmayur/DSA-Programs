//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG {
    public static Node merge(Node a,Node b){
        
        Node dummy=new Node(10);
        Node ta=dummy;
        while(a!=null && b!=null){
            
            if(a.data<=b.data){
                ta.next=a;
                ta=ta.next;
                a=a.next;
            }
            else{
                ta.next=b;
                ta=ta.next;
                b=b.next;
                
            }
        }
        
        if(a==null){
            ta.next=b;
        }
        else{
            ta.next=a;
        }
        return dummy.next;
    }
    public static Node quickSort(Node node) {
        if(node==null || node.next==null)return node;
        
        Node slow=node;
        Node fast=node;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       
       Node a=node;
       Node b=slow.next;;
        slow.next=null;
        a=quickSort(a);
        b=quickSort(b);
        Node c= merge(a,b);
        return c;
         
        
     
        
        
    }
}