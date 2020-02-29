/* Java program to reverse 
String using Stack */
	
import java.util.*; 

//stack 
class Stack 
{ 
	int size; 
	int top; 
	char[] a; 

	//function to check if stack is empty 
	boolean isEmpty() 
	{ 
		return (top < 0); 
	} 
	
	Stack(int n) 
	{ 
		top = -1; 
		size = n; 
		a = new char[size]; 
	} 

	//function to push element in Stack 
	boolean push(char x) 
	{ 
		if (top == size-1) 
		{ 
		System.out.println("Stack Overflow"); 
		return false; 
		} 
		else
		{ 
		    top++;
			a[top] = x; 
			return true; 
		} 
	} 

	//function to pop element from stack 
	char pop() 
	{ 
		if (top < 0) 
		{ 
		System.out.println("Stack Underflow"); 
		return 0; 
		} 
		else
		{ 
			return a[top--]; 
		} 
	}
	char peek()
	{
	    return a[top];
	}
} 


class Main 
{ 
	public static void main(String args[]) 
	{ 
	    int n=9;
		Stack s=new Stack(n);
		StringBuilder sb=new StringBuilder("laP tiknA");
		
		for (int i = 0; i < n; i++)
		    s.push(sb.charAt(i));
		
		s.push('1'); // Stack Overflow as top > 9
		
		for (int i = 0; i < n; i++)
		{
		    char c=s.peek();
		    s.pop();
		    sb.setCharAt(i,c);
		}
		s.pop(); // Stack Under flow as top < 0
		
		System.out.println(sb); // Ankit Pal
	} 
} 
