package utilities;

import java.io.IOException;


public class DataProviders {
	
	
	//DataProvider 1
	
	public String [][] getData() throws IOException
	{ 
		String path = ".//testData/Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);//Creating an object for XLUtility
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getRowCount("Sheet1");
		
		String logindata[][] = new String[totalrows][totalcols];//created for two dimension array which can store
		
		for(int i=1;i<=totalrows;i++)//1 //read the data from XL storing in two deminsional array
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);//1,0
			}
		}
		return logindata;// returning two deminsion array
		
		
	}
	
	//DataProvider 2
	
	//DataProvider 3

}
