package lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionStream {
public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	list.add(10);
	list.add(20);
	list.add(40);
	list.add(44);
	list.add(55);
	list.add(67);
	list.add(89);
	
	List<Integer>l2=list.stream().filter(i->i%2==0).collect(Collectors.toList());
	System.out.println(l2);
	
	List<Integer> marks=new ArrayList<Integer>();
	marks.add(10);
	marks.add(20);
	marks.add(40);
	marks.add(44);
	marks.add(55);
	marks.add(67);
	marks.add(89);
	System.out.println(marks);
		List<Integer> l1 = marks.stream().map(i -> i + 5).collect(Collectors.toList());
	System.out.println(l1);
	
	System.out.println(marks.stream().filter(n->n==899).collect(Collectors.toList()));
	list.stream().mapToInt(num->num).filter(num->num%2==0).forEach(System.out::println);
}
}
