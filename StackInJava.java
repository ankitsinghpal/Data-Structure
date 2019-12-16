/*package whatever //do not write package name here */

import java.util.*;

class StackInJava {
    
    
	public static void main (String[] args) {
		Stack<Integer> s=new Stack<Integer>();
		
		for(int i=1;i<=5;i++)
		    s.push(i*100);
		    
		System.out.println(s); //[100, 200, 300, 400, 500]
		
		System.out.println(s.peek()); //500   
		s.pop();
		System.out.println(s.peek());  //400
		
		System.out.println(s.size()); //4 = size-1 ie. indexing start from 0
		
		
		System.out.println(s.empty()); //false
		
		System.out.println(s.isEmpty()); //false
		
		System.out.println(s.search(500)); // -1
		
		//s.removeAllElements();
		//s.clear();
		//s.removeElementAt(2);
		//System.out.println(s.remove(0));
		System.out.println(s.size());
		
		System.out.println(s.contains(200));
		
		s.set(0,800);
		System.out.println(s.get(0));
		
		
		System.out.println(s.firstElement());  //800
		System.out.println(s.lastElement()); //400
		
		System.out.println(s.indexOf(300));
		System.out.println(s.lastIndexOf(300));
		
		Object arr[]=s.toArray();
		System.out.println(arr[0]); //800
		
		Object a=s.clone();
		System.out.println(a); //[800, 200, 300, 400]
		
		
		
	}

    
}

