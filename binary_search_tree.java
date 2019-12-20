/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class BST
{
    public int data;
    BST left;
    BST right;
        
}

class GFG 
{
    
    static BST GetNewNode(int data)
    {
        BST node = new BST();
        node.data=data;
        node.left=node.right=null;
        
        return node;
    }
    /*
    Instead of writing GetNewNode we also write
    code in BST class ie make a parameterised constructor
        class BST
        {
            //old code;
            ----------
            
            BST(int item)
            {
                data=item;
                left=right=null;
            }
        }
    OR in Insert method replace GetNewNode line by this
    return (new BST(data)); 
    
    ie.
        Node insert(Node node, int data) 
        { 
            if (node == null)  
                return (new Node(data)); 
             else 
                if (data <= node.data)  
                    node.left = insert(node.left, data); 
                 else  
                    node.right = insert(node.right, data); 
                
                return node; 
        } 
    
    */
    
    static BST Insert(BST root, int data)
    {
        if(root==null)
            root=GetNewNode(data);
        else if(data<=root.data)
                    root.left=Insert(root.left,data);
             else
                    root.right=Insert(root.right,data);
                    
        return root;
    }
   static BST FindMini(BST root)
    {
        //BST current=root;
        while(root.left!=null)
            root=root.left;
            
        return root;
    }
    static BST Delete(BST root, int data)
    {
        if(root==null)
            return root;
        else    if(data<root.data)
                    root.left=Delete(root.left,data);
                else    if(data>root.data)
                            root.right=Delete(root.right,data);
                        else    if(root.left==null && root.right==null)
                                {
                                    root=null;
                                }
                                else    if(root.left==null)
                                        {
                                            BST temp=root;
                                            root=root.left;
                                        }
                                        else
                                        {
                                            BST temp=FindMini(root.right);
                                            root.data=temp.data;
                                            root.right=Delete(r oot.right,temp.data);
                                        }
        return root;
    }
    
    static void Inorder(BST root)
    {
        if(root==null)
            return;
            
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    static void Preorder(BST root)
    {
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        Preorder(root.left);
        Preorder(root.right);
    }
    static void Postorder(BST root)
    {
        if(root==null)
            return;
            
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data+" ");
    } 
    
    static void Levelorder(BST root)
    {
        if(root==null)
            return;
        Queue<BST > q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            BST current=q.peek();
            q.remove();
            System.out.print(current.data+" ");
            if(current.left!=null)
                q.add(current.left);
            if(current.right!=null)
                q.add(current.right);
        }
    }
    static boolean Search(BST root, int data)
    {
        if(root==null)
            return false;
        else if(root.data==data)
                    return true;
             else if(data<=root.data)
                        return Search(root.left,data);
                  else 
                        return Search(root.right,data);
    }
    
    static int FindMax(BST root)
    {
        while(root.right!=null)
            root=root.right;
            
        return root.data;
    }
    static int FindMin(BST root)
    {
        while(root.left!=null)
            root=root.left;
            
        return root.data;
    }
	public static int Height(BST root)
	{
		if(root==null)
			return 0;
		else
		{
			int l=Height(root.left);
			int r=Height(root.right);
			if(l>r)
				return l+1;
			else 
				return r+1;
		}
	}
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
		BST root=null;
		for(;;)
		{   
		    int n;
		    n=sc.nextInt();
		    if(n<0)
		        break;
		    else 
		        root=Insert(root,n);
		}
			
		System.out.print("\nInorder   : "); Inorder(root);
		System.out.print("\nPreorder  : ");Preorder(root);
		System.out.print("\nPostorder : ");Postorder(root);
		System.out.print("\nLevelorder : ");Levelorder(root);
        
		int x=sc.nextInt();
		System.out.println("\n\nAfter Deleting "+x);
		if(Search(root,x))
		    System.out.println("Deleted Successfully !");
		   else System.out.println("Not Deleted !");
		   
		root=Delete(root,x);
	
    	System.out.print("\nInorder   : "); Inorder(root);
		System.out.print("\nPreorder  : ");Preorder(root);
		System.out.print("\nPostorder : ");Postorder(root);
		System.out.print("\nLevelorder : ");Levelorder(root);
		
	    System.out.print("\n\nMax Element : "+FindMax(root));
		System.out.print("\nMin Element : "+FindMin(root));
		System.out.print("\nHeight : "+Height(root));
		
		
	}
}
