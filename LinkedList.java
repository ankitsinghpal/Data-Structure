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
        //node.next=null;
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
    
    
    public boolean search(int key)
    {
        Node node=head;
        boolean check=false;
        
        if(node==null)
        {
            System.out.println("Empty LinkedList !");
        }
        
        
        while(node!=null && check==false)
        {
            /* compare each node if not present 
               then move to next node */
            if(node.data==key) 
                return true;
            else
                node=node.next;
        }
        
        return false;
    }
    
    public int searchPosition(int index)
    {
        Node node=head;
        boolean check=false;
        
        int pos=0;
        if(node==null)
        {
            System.out.println("Empty LinkedList !");
        }
        
        while(node!=null && check==false)
        {
            if(pos==index)
            {
                return node.data;
            }
            pos++;
            node=node.next;
            
        }
        return -1;
        
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
        if(index > length)
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
		
		while(sp!=null && fp!=null && fp.next.next!=null)
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
            head=head.next;
                
        }
    }
    
    void deleteNode(int position) 
    { 
        // If linked list is empty 
        if (head == null) 
            return; 
  
        Node node = head; 
  
        // If head needs to be removed 
        if (position == 0) 
        { 
            head = node.next;   // Change head 
            return; 
        } 
  
        // Find previous node of the node to be deleted 
        for (int i=0; node!=null && i<position-1; i++) 
            node = node.next; 
  
        // If position is more than number of ndoes 
        if (node == null || node.next == null) 
            return; 
  
        // Node node->next is the node to be deleted 
        // Store pointer to the next of node to be deleted 
        node.next  = node.next.next; 
  
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
        
        /*===========================================*/
        /*             INSERTION                     */
        /*===========================================*/
        l.insert(5);
        l.insert(10);
        l.insert(15);
        l.insert(20);
        l.insert(25);
        
        l.insertAtStart(30);
        l.show();           // 30 5 10 15 20 25 
        
        l.insertAt(1,35);
        l.show();           // 30 35 5 10 15 20 25 
        
        l.showMid();        // 10
        l.show();           // 30 35 5 10 15 20 25 
        l.showNthLast(3);   // 15
        
        l.showNth(5);       // 15
        
        /*===========================================*/
        /*             SEARCHING                     */
        /*===========================================*/
        // search with element
        System.out.println(l.search(200));   // false
        
        // search with index
        System.out.println(l.searchPosition(0));  // 30
        
        
        /*===========================================*/
        /*             DELETION                      */
        /*===========================================*/
        l.deleteFromStart(); //deletes the head
        l.show();   // 35 5 10 15 20 25 
        
        l.deleteNode(4); //index position = starts from 0 to n-1
        l.show();   // 35 5 10 15 25 
        
        
        /*===========================================*/
        /*                                           */
        /*===========================================*/
        l.head=l.reverse(l.head); // RECURSIVE REVERSE
        l.show();  // 25 15 10 5 35
        
        
        ///////////////////////////////////////////////
        
        LinkedList l1=new LinkedList();
        l1.insertAtStart(100);
        l1.insertAtStart(200);
        l1.insertAtStart(300);
        l1.insertAtStart(400);
        l1.insertAtStart(500);
        
        l1.head.next.next.next.next = l1.head; 
        l1.detectLoop();    // Loop Hai
        
    }
}
