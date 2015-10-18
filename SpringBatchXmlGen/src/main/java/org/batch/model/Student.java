package org.batch.model;

import java.io.Serializable;
import java.util.HashMap;

public class Student implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id ;
	private String name;
	private String college;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	
	
	/*public static void main(String[] args) {
		
		
		Student s1 = new Student("1","nisarg","semcom","D");
		Student s2 = new Student("2","Kinjal","semcom","D");
		Student s3 = new Student("3","amit","semcom","D");
		Student s4 = new Student("1","rohan","semcom","D");
		
		
		HashMap<Student, Student> h  = 
				new HashMap<Student, Student>();
		
			h.put(s1, s1);
			h.put(s2, s2);
			h.put(s3, s3);
			h.put(s4, s4);
			
			System.out.println("size :"+h.size());
			
		
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		System.out.println("RESULT :"+result);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
