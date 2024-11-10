package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {


	// DataProvide1
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\OpenCart_loginData.xlsx";
		
		Excelutility xlutil = new Excelutility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];

		for (int i=1; i<=totalrows; i++) {
			for (int j=0; j<totalcols; j++)
				
			{
				logindata[i-1][j] = xlutil.getCellData("sheet1", i, j);
			}
		}

		return logindata;
	}
}
//DataProvide2

//DataProvide3

//DataProvide4