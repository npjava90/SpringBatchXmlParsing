package org.batch.writer;

/*import org.apache.commons.beanutils.PropertyUtils;*/

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.batch.model.Student;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StudentGeneration_Writer  implements ItemWriter<Student>,StepExecutionListener{


	private JdbcTemplate jdbcTemplate;
	int batchRunId;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		String sqlUpdate="UPDATE batchstrn SET STATUSCODE='S' WHERE BATCHRUNID=?";
		jdbcTemplate.update(sqlUpdate,batchRunId);
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(List<? extends Student> studentList) throws Exception {
		// TODO Auto-generated method stub
		
		List<Student> listStudent = new  ArrayList<Student>();
		
		for(Student dto:studentList)
		{
		
			Student studentObj = new Student();
			
			studentObj.setId(dto.getId());
			studentObj.setName(dto.getName());
			studentObj.setCollege(dto.getCollege());
			studentObj.setStatus(dto.getStatus());
			
			listStudent.add(studentObj);
			
		}
	
		createXml(listStudent);
	}
	
	public int getBatchRunId() {
		return batchRunId;
	}

	public void setBatchRunId(int batchRunId) {
		this.batchRunId = batchRunId;
	}
//new
	public static void  createXml(List<? extends Student> studentList)
	{
	/*	
		private String id ;
		private String name;
		private String college;
		private String status;
		*/
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("college");
			doc.appendChild(rootElement);

			// staff elements
			
			for (Student student : studentList) {
				Element staff = doc.createElement("Student");
				rootElement.appendChild(staff);

				// set attribute to staff element
				Attr attr = doc.createAttribute("id");
				attr.setValue(student.getId());
				staff.setAttributeNode(attr);





				Element firstname = doc.createElement("name");
				firstname.appendChild(doc.createTextNode(student.getName()));
				staff.appendChild(firstname);


				Element lastname = doc.createElement("college");
				lastname.appendChild(doc.createTextNode(student.getCollege()));
				staff.appendChild(lastname);


				Element nickname = doc.createElement("status");
				nickname.appendChild(doc.createTextNode(student.getStatus()));
				staff.appendChild(nickname);


				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("D:\\file.xml"));

				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);

				transformer.transform(source, result);

				System.out.println("File saved!");

			  } 
			
		}	
			catch (Exception pce) {
			pce.printStackTrace();
		  }
		
	}
	
}
