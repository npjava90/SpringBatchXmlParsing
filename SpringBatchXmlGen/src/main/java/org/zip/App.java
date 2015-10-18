package org.zip;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//@Component
public class App {

	public static void main(String[] args) {

		App obj = new App();
		obj.run();
		

	}
//batchstrn
	private void run() {

		String[] springConfig = { "spring/batch/jobs/student_excelList.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("CR_OUT_GEN");

		Map<String, JobParameter> mapofParam = new  HashMap<String, JobParameter>();
		
		mapofParam.put("BATCHID", new JobParameter("3"));
		
		JobParameters jobparam= new JobParameters(mapofParam);
		
		try {

			JobExecution execution = jobLauncher.run(job, jobparam);
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("Done");

	}

}
