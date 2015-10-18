package org.batch.tasklet;

import java.util.Comparator;

import org.batch.model.Student;

public class StudentComparator  implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		
		//int i =o1.getName() - o2.getName();
		//String sname = 
		return o1.getName().compareTo(o2.getName());
		
	}

}
