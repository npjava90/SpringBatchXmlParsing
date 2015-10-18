package org.batch.tasklet;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.batch.model.Student;


public class StudentSorting {

	public static void main(String[] args) {
		
		//By using name comparator (String comparison)
        TreeMap<Student,String> tm = new TreeMap<Student, String>(new StudentComparator());
        ;
        ;
        ;
        
        Student s1 = new Student();
        s1.setId("1");
        s1.setCollege("a");
        s1.setName("b");
        s1.setStatus("s");
        
        Student s2 = new Student();
        s2.setId("2");
        s2.setCollege("a");
        s2.setName("c");
        s2.setStatus("s");
        
        Student s3 = new Student();
        s3.setId("3");
        s3.setCollege("a");
        s3.setName("a");
        s3.setStatus("s");
        
        
        tm.put(s1, "RAM");
        tm.put(s2, "JOHN");
        tm.put(s3, "CRISH");
        
        for (Entry<Student, String> entry : tm.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        
        System.out.println("==================================="+tm.size());
       TreeSet<String> t = new  TreeSet<String>();
       
       t.add("a");
      //treeset wont allow null element
       //t.add(null);
       t.add("h");
       t.add("c");
       t.add("g");
       
       HashSet<String> hset = new HashSet<String>();
       hset.add("a");
       hset.add(null);
       hset.add(null);
       hset.add(null);
       hset.add(null);
       
       
      System.out.println("size - >"+t);
      System.out.println("hash set size - >"+hset.size());
		
      
	}
	
	
}
