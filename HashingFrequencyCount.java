import java.util.*;
import java.util.Map.Entry;

import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = "Hello this is my world and this is hello";
    HashMap<String, Integer> hm = new HashMap<>();

    String words[]=str.toLowerCase().split(" ");

    for(String word : words)
    {
      if(hm.containsKey(word))
      {
        hm.put(word,hm.get(word)+1);
      }
      else
      {
        hm.put(word,1);
      }

    }
    
    
    System.out.println(hm);
    
    //sort by key
    
    HashMap<String, Integer> sortmap1 =new HashMap<>();
    
    sortmap1=hm.entrySet()    // get entries from hahmap
            .stream()         //convert map into stream
            .sorted(Map.Entry.comparingByKey())  // collect in LinkedHashMap
            .collect(Collectors.toMap(   // Using Collectors, collect the entries 
                                         // and convert it into LinkedHashMap 
            Map.Entry::getKey, 
            Map.Entry::getValue, 
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

  System.out.println(sortmap1);
  
  
  System.out.println();
  
  //sort by value
  HashMap<String, Integer> sortmap2 =new HashMap<>();
  sortmap2=hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
  .collect(Collectors.toMap(
    Map.Entry::getKey, 
    Map.Entry::getValue, 
    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  
  System.out.println(sortmap2);;
  /*
  BASIC TERMS
  1. stream()        : Streams are sequences of elements which can be easily obtained from a Collection.
                       To get the key and values of Map via Stream.
                       
  2. entrySet()      : USed to create a new set and store the map elements into them.
  
  3. LinkedHashMap() : maintains the insertion order or can say predictable iteration order.
  
  4. TreeMap()       : sort the entries in ascending order of keys.
  
  5. HashMap()       : doesn’t maintain any order.
  
  */
    
    	List<Map.Entry<String, Integer>> list=
		new LinkedList<Map.Entry<String,Integer>>(hm.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
		    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
		    {
		        return a.getValue().compareTo(b.getValue());
		    }
		});
		HashMap<String,Integer> map=new LinkedHashMap<>();
		for(Map.Entry<String, Integer> x: list)
		    map.put(x.getKey(),x.getValue());
		    
		    
	System.out.println("ByValue "+map);
	// ByValue {world=1, my=1, you=1, are=2, hello=2, how=4}
	
	TreeMap<String, Integer> tm=new TreeMap<String, Integer>();
	
	tm=hm.entrySet().stream().collect(Collectors.toMap
	(Map.Entry::getKey,
	    Map.Entry::getValue,
	    (a,b)->a, TreeMap::new));
	
	System.out.println("ByKey "+tm);
	//  ByKey {are=2, hello=2, how=4, my=1, world=1, you=1}
	
    
  }
}
