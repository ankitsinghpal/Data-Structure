/*package whatever //do not write package name here */

import java.util.*;

class QueueInJava {
    
    
	public static void main (String[] args) {
	
	    Queue<Integer> q=new LinkedList<>();	
		for(int i=1;i<=5;i++)
		    q.add(i*100);
		 
		System.out.println(q); 
		
		System.out.println(q.peek());
		
		q.remove();
		System.out.println(q);
		
		System.out.println(q.contains(100));
		
		//q.clear();
		
		System.out.println(q.size());
	}

    
}

