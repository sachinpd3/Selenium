package Automation.MavenPrac;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    
@Test
    	public void Hello() throws IOException
    	{
    	
    	DataDriven d = new DataDriven();
    	ArrayList<String>str = d.DataDriver();
    	
     System.out.println("Data is "+str.get(0));
     System.out.println("Data is "+str.get(1));
     System.out.println("Data is "+str.get(2));
     System.out.println("Data is "+str.get(3));
    	
    }
}
