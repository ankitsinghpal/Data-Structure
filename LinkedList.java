import java.util.*;
public class LinkedList {
  
    Node head;
    
    class Node
    {
      int data;
      Node next;
    }
    
    public void insert(int data)
    {
      Node node=new Node();
      node.data=data;
      node.next=null;
      
      if(head==null)
          head=node;
      else
      {
          Node n=head;
          while(n.next!=null)
          {
            n=n.next;
          }
          
          n.next=node;
      }  
    }
    
    public void insertAtStart(int data)
    {
        Node node= new Node();
        node.data=data;
        node.next=null;
        node.next=head;
        head=node;
    }
    
    public void insertAt(int index,int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(index==0)
		{
			insertAtStart(data);
		}
		else{
		Node n = head;
		for(int i=0;i<index-1;i++)
		{
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
		}
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
    
    public void showMid()
    {
        Node sp=head;
        Node fp=head;
        
        if(head!=null)
        {
            while(fp!=null && fp.next!=null)
            {
                fp=fp.next.next;
                sp=sp.next;
            }
            System.out.println(sp.data);
        }
    }
    
    public void showNthLast(int index) //nth From Last
    {
        Node node=head;
        int length=0;
        while(node!=null)
        {
            node=node.next;
            length++;
        }
        if(length<index)
            return;
        
        node=head;
        
        for(int i=0;i<length-index;i++)
            node=node.next;
            
        System.out.println(node.data);
    }
    
    
    public void showNth(int index) //nth 
    {
        Node node=head;
       
        for(int i=1;i<index;i++)
            node=node.next;
            
        System.out.println(node.data);
    }
    int detectLoop() 
	{ 
		Node sp=head;
		Node fp=head;
		
		for(;sp!=null && fp!=null && fp.next.next!=null;)
		{
		    sp=sp.next;
		    fp=fp.next.next;
		    if(sp==fp)
		    {
		        System.out.println("Loop Hai");
		        return 1;
		    }
		}
		return 0;
	} 
	
	void deleteFromStart()
    {
        if(head==null)
        {
            System.out.println("Empty Hai !");
            return;
        }
        else
        {
            if(head!=null)
                head=head.next;
            else
                head=null;
                
        }
    }
    
    void deleteNode(int position) 
    { 
        // If linked list is empty 
        if (head == null) 
            return; 
  
        // Store head node 
        Node temp = head; 
  
        // If head needs to be removed 
        if (position == 0) 
        { 
            head = temp.next;   // Change head 
            return; 
        } 
  
        // Find previous node of the node to be deleted 
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        // If position is more than number of ndoes 
        if (temp == null || temp.next == null) 
            return; 
  
        // Node temp->next is the node to be deleted 
        // Store pointer to the next of node to be deleted 
        Node next = temp.next.next; 
  
        temp.next = next;  // Unlink the deleted node from list 
    }
    
    Node reverse(Node head)
    {
        
        if(head==null || head.next==null)
            return head;
        
        Node node=reverse(head.next);
        head.next.next=head;
        
        head.next=null;
        return node;
        
    }
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.insert(5);
        l.insert(10);
        l.insert(15);
        l.insert(20);
        l.insert(25);
        
        l.insertAtStart(30);
        l.show();
        
        l.insertAt(1,35);
        l.show();
        
        l.showMid();
        l.show();
        l.showNthLast(3);
        
        l.showNth(5);
        
        LinkedList l1=new LinkedList();
        l1.insertAtStart(100);
        l1.insertAtStart(200);
        l1.insertAtStart(300);
        l1.insertAtStart(400);
        l1.insertAtStart(500);
        
        l1.head.next.next.next.next = l1.head; 
        l1.detectLoop();
        
        l.deleteFromStart(); //deletes the head
        l.show();
        
        l.deleteNode(4); //index position = starts from 0 to n-1
        l.show();
        
        l.head=l.reverse(l.head); // RECURSIVE REVERSE
        l.show();
    }
}
