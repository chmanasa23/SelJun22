package com.webappsecurity.zero.testscripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.Home;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFunds;
import com.webappsecurity.zero.pages.TransferFundsConfirmation;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base {
	

	
	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		Home hm = new Home(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
	
	String[][] data = GenericMethods.getData("C:\\ExcelTestData\\New Spreadsheet 1.xlsx", "Sheet1");
		
	for(int i = 1; i<data.length;i++) {
		lp.applicationLogin(data[i][0], data[i][1]);
		driver.navigate().back();
		hm.clickTransferFunds();
		tf.doFundTransfer(data[i][2], data[i][3]);
		tfv.clickSubmit();
		String actualMsg = tfc.getConfirmationMsg();
		String expectedMsg = data[i][4];
		Assert.assertEquals(actualMsg, expectedMsg);
		tfc.logoutFromApp();
	}
	
	
	}
	
	
	
	

}
