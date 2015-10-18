package org.batch.tasklet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Student_InitTasklet  implements Tasklet,StepExecutionListener {

	private JdbcTemplate jdbcTemplate;
	int batch_run_id;
	//private long batchId;
	private long batchId=1;

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
		stepExecution.getJobExecution().getExecutionContext()
		.put("BATCHRUNID", batch_run_id);

		System.out.println("afterStep::"+batch_run_id);
		
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
			throws Exception {
		// TODO Auto-generated method stub
		
		
			
			String sql="INSERT INTO batchstrn(BATCHRUNID,BATCHID,REQDATE,PROCSTARTDATE,STATUSCODE)"
					+ "VALUES (?, ?, ?, ?, 'P' )";
			
			jdbcTemplate.update(sql,batch_run_id,batchId,getCurrentTimeStamp(),getCurrentTimeStamp());
			
			System.out.println("afterStep::"+batch_run_id);
				
			return RepeatStatus.FINISHED;
			
	}
	public long getBatchId() {
		return batchId;
	}

	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
}
