import java.util.*; 
class Hash { 
	public static void main(String[] arg) 
	{ 
		Hashtable<Integer, String> h = 
					new Hashtable<Integer, String>(); 

		h.put(1, "onw"); 
		h.put(2, "two"); 
		h.put(31, "isBest"); 
        
        
        System.out.println(h.get(16));  // null
        Hashtable<Integer, String> h1 = 
					new Hashtable<Integer, String>(); 
		
        Object o=h.clone();
		//h.clear();
		System.out.println(h+"\n"+o); // {31=isBest, 2=two, 1=onw}
                                      // {31=isBest, 2=two, 1=onw}
		                              
		System.out.println("Is the value 'Geeks' present? " +  
                            h.contains("one")); // false
                            
        if (h.containsKey(31)) 
            System.out.println("Key found in table"); // Key found in table 
        
        if (h.containsValue("isBest")) 
            System.out.println("value found in table"); //Value found in table
		
		Enumeration e = h.elements(); 
        System.out.print("display values: "); 
        while (e.hasMoreElements()) { 
            System.out.print(e.nextElement()+" "); // isBest two onw
        } 
        
        Enumeration e1 = h.keys(); 
        System.out.print("\ndisplay key: ");  
  
        while (e1.hasMoreElements()) { 
            System.out.print(e1.nextElement()+" ");  // 31 2 1
        } 
        
        System.out.println("\nhash code is: " + h.hashCode()); // -1180409096
        
        if (h.isEmpty()) 
            System.out.println("yes hash table is empty"); 
        else System.out.println("No hash table is empty"); // no print
        
        Set sKey = h.keySet(); 
        System.out.println("key set: " + sKey); // [31, 2, 1]
        
        Set s = h.entrySet();
        System.out.println("collection values: " + h.values());
                        // [isBest, two, onw]
 
        System.out.println("Size: " + h.size()); // 3
	} 
} 
