package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{
		String path=".//testData//Opencart_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlUtil=new ExcelUtility(path);//creating an object for XLUtility
		
		int total_rows=xlUtil.getRowCount("Sheet1");
		int total_cols=xlUtil.getCellCount("Sheet1",1);
				
		String[][] loginData =new String[total_rows][total_cols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=total_rows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<total_cols;j++)  //0    i is rows j is col
			{
				loginData[i-1][j]= xlUtil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return loginData;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
