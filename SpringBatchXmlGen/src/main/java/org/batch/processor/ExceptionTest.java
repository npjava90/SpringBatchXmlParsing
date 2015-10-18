package org.batch.processor;

public class ExceptionTest {

	public static void main(String[] args) {
		
	int a=	tryException();
	
	System.out.println("VAL :"+a);
	}
	

public static int tryException()
{
try
{
	
	
	return 1; 
}
catch(Exception e)  {return 2;  }

finally{return 3;}


}
}		
	
