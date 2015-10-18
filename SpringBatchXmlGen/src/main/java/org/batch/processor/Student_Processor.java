package org.batch.processor;

import org.batch.model.Student;
import org.springframework.batch.item.ItemProcessor;

public class Student_Processor implements ItemProcessor<Student, Student> {

	private int batchRunId;
	@Override
	public Student process(Student stdent) throws Exception {
		// TODO Auto-generated method stub		
		return stdent;
	}
	public int getBatchRunId() {
		return batchRunId;
	}
	public void setBatchRunId(int batchRunId) {
		this.batchRunId = batchRunId;
	}
}
