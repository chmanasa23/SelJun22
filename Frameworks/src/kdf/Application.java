package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("C:\\ExcelTestData\\New Spreadsheet 1.xlsx", "Sheet2");
		Methods mtd = new Methods();
		for(int i = 1; i<data.length;i++) {
			switch(data[i][3]) {
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case"enterinTextBox":
				mtd.enterinTextBox(data[i][5], data[i][6]);
				break;
			case"clickButton":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case"verifyMsg":
				String actualMsg = mtd.getMessage(data[i][4],data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
				break;
			case"closeApp":
				mtd.CloseApplication();
				break;
				}
		}
		
	}
}
