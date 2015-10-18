package org.batch.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Testing {

	public static void main(String[] args) {
		
	/*	HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("a","a");
		map.put("b","b");
		
		Iterator<Entry<String, String>> listIterator  =  map.entrySet().iterator(); 
		
		for (Iterator iterator = ((Set<Entry<String, String>>) listIterator).iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			
		}*/
		
		/*Set<String> set = new HashSet<String>();
		set.add("nisarg");
		
		ListIterator<String> listIterator  =  (ListIterator<String>) set.iterator();*/
 			
		//---------- WE CAN USE ListIterator on List Only ...!!!
		
		List<Student>  list = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setId("1");
		s1.setName("Nisarg");
		
		Student s2 = new Student();
		s2.setId("1");
		s2.setName("Pathak");
		
		list.add(s1);
		list.add(s2);
				
	
	
		
		
	System.out.println("size is : ---"+list.size());
	
	ListIterator<Student> listIterator = list.listIterator();
	
	while(listIterator.hasNext())
	{
		
		Student s = listIterator.next();
		System.out.println("VAL.... "+s.getId());
	}
	}
	
	public static void getData()
	{
		
	}
}
	