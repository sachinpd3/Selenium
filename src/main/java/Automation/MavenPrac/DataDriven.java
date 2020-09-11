package Automation.MavenPrac;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class DataDriven
{
public ArrayList<String> DataDriver() throws IOException
	{
	 ArrayList<String> arr = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\SACHIN\\Desktop\\Test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int SheetCount = workbook.getNumberOfSheets();
		int k=0;
		int column =0;
       for (int i = 0; i < SheetCount; i++)
		{
		 if (workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			 {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows= sheet.rowIterator();
			    Row firstrow=rows.next();
			    Iterator<Cell> cell=firstrow.cellIterator();
			    while(cell.hasNext())
			    {
			    Cell val =cell.next();
			    if ( val.getStringCellValue().equalsIgnoreCase("TC_ID"))
			       {
			      column=k;
				  while(rows.hasNext())
			      {
				Row StartIteration=	 rows.next();
			    if( StartIteration.getCell(column).getStringCellValue().equalsIgnoreCase("Login"));
			        {
                  Iterator<Cell> cellrequired =  StartIteration.cellIterator();
				  System.out.println("TC name is "+cellrequired.next().getStringCellValue());
				  while (cellrequired.hasNext())
				  {
				//System.out.println("Data is "+cellrequired.next().getStringCellValue());
				         
					Cell cv =  cellrequired.next();
					  
					  if (cv.getCellType()==CellType.STRING)
                     {
						  arr.add(cv.getStringCellValue());
						  
                     }
					  else
					  {
						  
						arr.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
						  
					  }
				
				
				}
				  
			   }
			  }
		      k=k+1; 
			  }
			 }
			}
		}
	return arr;
	}
}
