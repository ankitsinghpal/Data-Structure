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
                                            root.right=Delete(root.right,temp.data);
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
		root=Insert(root,10);
		root=Insert(root,15);
		root=Insert(root,6);
		root=Insert(root,18);
		root=Insert(root,9);
		root=Insert(root,4);
		
			
		Inorder(root);			// 4 6 9 10 15 18 
		System.out.println();
		
		Preorder(root);			// 10 6 4 9 15 18
		System.out.println();
		
		Postorder(root);		// 4 9 6 18 15 10
		System.out.println();
		
		Levelorder(root);		// 10 6 15 4 9 18
		System.out.println();
		
        System.out.println(Height(root));	// 3
        
		int x=6;
		if(Search(root,x))
		    System.out.println(x+" Search Successfully !");
		   else System.out.println(x+ " Not Present !");
		
		
		System.out.println("\nAfter Deleting "+x);   
		root=Delete(root,x);
	
        Inorder(root);			// 4 9 10 15 18
		System.out.println();	
		
		Preorder(root);			// 10 9 4 15 18
		System.out.println();
		
		Postorder(root);		// 4 9 18 15 10
		System.out.println();
		
		Levelorder(root);		// 10 9 15 4 18
		System.out.println();
		
        System.out.println(Height(root));       // 3
		
	    System.out.print("\n\n"+FindMax(root)); // 18
		System.out.print("\n"+FindMin(root));   // 4
		
	}
}
