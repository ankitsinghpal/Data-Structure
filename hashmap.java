import java.util.*; 
class Hash { 
	public static void main(String[] arg) 
	{ 
		Hashtable<Integer, String> h = 
					new Hashtable<Integer, String>(); 

		h.put(1, "onw"); 
		h.put(2, "two"); 
		h.put(31, "isBest"); 
        
        
        System.out.println(h.get(16));
        Hashtable<Integer, String> h1 = 
					new Hashtable<Integer, String>(); 
		
        Object o=h.clone();
		//h.clear();
		System.out.println(h+"\n"+o); 
		
		System.out.println("Is the value 'Geeks' present? " +  
                            h.contains("one"));
                            
        if (h.containsKey(31)) 
            System.out.println("Key found in table");
        
        if (h.containsValue("isBest")) 
            System.out.println("value found in table"); 
		
		Enumeration e = h.elements(); 
        System.out.print("display values: "); 
        while (e.hasMoreElements()) { 
            System.out.print(e.nextElement()+" "); 
        } 
        
        Enumeration e1 = h.keys(); 
        System.out.print("\ndisplay key: "); 
  
        while (e1.hasMoreElements()) { 
            System.out.print(e1.nextElement()+" "); 
        } 
        
        System.out.println("\nhash code is: " + h.hashCode()); 
        
        if (h.isEmpty()) 
            System.out.println("yes hash table is empty"); 
        else System.out.println("No hash table is empty");
        
        Set sKey = h.keySet(); 
        System.out.println("key set: " + sKey);
        
        Set s = h.entrySet();
        System.out.println("collection values: " + h.values()); 
 
        System.out.println("Size: " + h.size());
	} 
} 
