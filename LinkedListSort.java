import java.util.*;

public class LinkedList 
{
    Node head;
    class Node 
    {
        int data;
        Node next;
    }
    
    public void sort()
    {
        Node node=head;
        
        if(head==null)
            return;
        else{
            while(node!=null)
            {
                Node n=node.next;
                while(n!=null)
                {
                    if(node.data>n.data) 
                    {
                        int temp = node.data;  
                        node.data = n.data;  
                        n.data = temp; 
                    }
                    n=n.next;
                }
                node=node.next;
            }
        }
        
    }
   
    public void insert(int data)
    {
        Node node=new Node();
        node.data=data;
        node.next=head;
        head=node;
        
    }
    	
    public void show()
    {
      Node node=head;
      while(node!=null)
      {
        System.out.print(node.data+" ");
        node=node.next;
      }
      System.out.println();
    }
    
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		LinkedList l=new LinkedList();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		    l.insert(sc.nextInt());
		l.show();
		
		l.sort();
		l.show();
	}
}
