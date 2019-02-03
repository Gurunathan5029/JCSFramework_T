package SupportLibraryClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class GetData {	
	
	
	public String ExcelCellPicker(String sheet, String Header) 
	{
		File file = new File("C:\\Users\\gunasegx\\Desktop\\cucumberframework\\DataTable\\Data Table.xls");
		Workbook WR1;
		
		try {
			FileInputStream fi = new FileInputStream(file);
			WR1 = Workbook.getWorkbook(fi);
			Sheet Sh1 = WR1.getSheet(sheet);
			for(int j=0;j<=25;j++)
			{
				String Cellvalue = Sh1.getCell(j, 0).getContents().toString();
				System.out.println(Cellvalue);
				System.out.println(Header);				
				if(Cellvalue.equals(Header))
				{
					System.out.println(Sh1.getCell(j, 1).getContents());
					String Cellvaluereturn = Sh1.getCell(j, 1).getContents();
					//return Sh1.getCell(j, 1).getContents();
					return Cellvaluereturn;
				}
				else
				{
					System.out.println(Sh1.getCell(j, 1).getContents()+ "else");
				}
				
			}
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
			return null;
		
	}

}