package com.myapp.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import com.myapp.objectrepository.SignInPage;
import com.sjm.utilities.BaseSuiteSetUp;
import com.sjm.utilities.CoustomLibrary;
import com.sjm.utilities.ExlDataprovider;
import com.sjm.utilities.GenericLibraries;
import com.sjm.utilities.Waits;

import static com.sjm.utilities.GenericLibraries.*;
import static com.sjm.utilities.ExcelOperations.*;
public class SignInTest extends BaseSuiteSetUp {
	private SignInPage signInPage;
	private String sheetName="login";

	@BeforeMethod

	public void beforeTest() {

		signInPage=PageFactory.initElements(driver, SignInPage.class);


	}


	@Test (priority = 1)
	public void validLoginTest() throws Exception {

		assertion(signInPage.loginAsValidUser(getData(sheetName, 2, 0), getData(sheetName, 2, 1)));
	}

	@Test (priority =2)
	public void invalidLoginTest() {

		assertion(signInPage.loginAsInValidUser(getData(sheetName, 1, 0), getData(sheetName, 1, 1)));
	}  
	@Test (priority = 3)
	public void bookmyTicket() throws Exception {

		assertion(signInPage.bookmyticket(getData(sheetName, 3, 0), getData(sheetName, 3, 1)));
	} 
	@Test (priority = 4)
	public void bookmyTicketreturn() throws Exception {

		assertion(signInPage.bookmyticketrtn(getData(sheetName, 4, 0), getData(sheetName, 4, 1)));

	} 

/*	@Test (priority = 5,dataProvider = "places",dataProviderClass = ExlDataprovider.class) 

	public void excelDataprovider(String fromplace, String toplace) throws Exception {
		signInPage.bookmyticketrtn(fromplace, toplace);  


	}	*/
}	
