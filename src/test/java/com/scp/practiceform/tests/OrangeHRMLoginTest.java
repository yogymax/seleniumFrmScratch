		package com.scp.practiceform.tests;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.orange.hrm.login.OrangeHRMLoginPO;
import com.scp.practice.form.AppUtil;
import com.scp.practice.form.AppUtil.BrowserTypes;
		
		public class OrangeHRMLoginTest {

			

		@DataProvider	
		public Object [][] getDataFromSheet() throws IOException{
				Object [][] testData = new Object[6][3];
				XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Yogesh\\Documents\\demo.xlsx");
				XSSFSheet sheet = workbook.getSheet("Sheet2");//workbook.getSheetAt(2);
				Iterator<Row> rows = sheet.rowIterator();
				int rowCount=0;
				int cellCount=0;
				boolean flag =true;
				while(rows.hasNext()){
						Row row = rows.next();
						
						if(flag){
							flag=false;
							continue;
						}
						Iterator<Cell> cells = row.cellIterator();
								while(cells.hasNext()){
									Cell cell = cells.next();
									if(cell.getCellType()==Cell.CELL_TYPE_STRING){
										//System.out.print("\t "+cell.getStringCellValue());
										testData[rowCount][cellCount]=cell.getStringCellValue();
										cellCount++;
									}
								}
								System.out.println("\n");
								rowCount++;
								cellCount=0;
				}
		
					return testData;
			}
			
			@Test(dataProvider="getDataFromSheet")
			public void loginTestScenarios(String unm,String pwd,String emsg){
				System.out.println("Unm --" +unm);
				System.out.println("Pwd --" +pwd);
				System.out.println("Emsg --" +emsg);
				
				if(unm.equals("NA"))
					unm="";
				if(pwd.equals("NA"))
					pwd="";
				
				WebDriver driver = AppUtil.initializeBrowser(BrowserTypes.Firefox, AppUtil.ORANAGEHRM_LOGIN_PAGE);
				OrangeHRMLoginPO orangeHRMPO = PageFactory.initElements(driver,OrangeHRMLoginPO.class);
				orangeHRMPO.enterUsername(unm);
				orangeHRMPO.enterPassword(pwd);
				orangeHRMPO.clickOnLoginButton();
				String actualMsg = orangeHRMPO.getErrorMessage();
				if(emsg.equals("Success")){
					Assert.assertNull(actualMsg);
				}else{
					Assert.assertEquals(emsg, actualMsg);
				}
				
			}
			
			@AfterMethod
			public void afterTest(){
				AppUtil.closeBrowser();
			}
			
			
		}
