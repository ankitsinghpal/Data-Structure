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
    
    sortmap1=hm.entrySet().stream().sorted(Map.Entry.comparingByKey())
    .collect(Collectors.toMap(
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
  
    
  }
}
