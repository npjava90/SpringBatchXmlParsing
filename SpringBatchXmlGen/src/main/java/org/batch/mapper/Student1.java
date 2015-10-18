package org.batch.mapper;

import java.util.HashMap;

public final class Student1 {

	private final String id ;
	private final String name;
	
	private HashMap<String,String> testmap;
	
 	public Student1(String id,String name,HashMap<String, String> hashmap) {
		this.id=id;
		this.name=name;
		
		hashmap.put(id,name);
		this.testmap = getTestHashMap(hashmap); 
		
	}	
 	
 	private HashMap<String, String> getTestHashMap(HashMap<String, String> hashmap)
 	{
 		return (HashMap<String, String>) hashmap.clone();
 	}
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public static void main(String[] args) {
		
		HashMap<String,String> hashmap =new HashMap<String, String>();
		
		hashmap.put("1","nisarg");
		hashmap.put("1","nisarg");
		
		hashmap.put("1","nisarg");
		
		hashmap.put("1","nisarg");
		
	Student1 s1= new Student1("1","nisarg",hashmap);
		
	System.out.println("....  "+s1.getId()+s1.getName());
	
	tryModification(s1.getId(), s1.getName());
		
	System.out.println(".... after modification "+s1.getId()+s1.getName());	
		
	}
	 private static void tryModification(String immutableField1, String immutableField2	)
	    {
	        immutableField1 = "1";
	        immutableField2 = "test changed";
	       
	    }
}
