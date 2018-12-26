package lamda;

import java.util.HashMap;
import java.util.Map;

public class HashMapDem {
public static void main(String[] args) {
	Map<Integer, String> map=new HashMap<Integer,String>();
	map.put(1, "hello");
	map.put(2, "bye");
	
	map.forEach((k,v)->{
		
		System.out.println(k+" "+map.get(k));
	});
}
}
