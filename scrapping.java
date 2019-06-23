package webScraping;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetPageSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class scrapping {

	public static void main(String[] args) throws IOException {

		System.out.println("Execution Started");
		//	Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
		
		HashMap<String,List<String>> Fourvalue = new HashMap<String,List<String>>();// To store all value 
		List<String> ProductNames = new ArrayList<String>();
		List<String> ProductValue = new ArrayList<String>();
		int i;
		
		FileOutputStream out = new FileOutputStream(new File("demo.xlsx"));
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Data");
		

		// Url navigation
		driver.navigate().to("https://www.amazon.com/s?k=samsung+galaxy+s10e+case&crid=CMU84NCU67PM&sprefix=sams%2Caps%2C1000&ref=nb_sb_noss_1");


		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/a/span")));
		// To collect all product name
		
		List<WebElement> pName =  driver.findElements(By.xpath("//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/a/span"));
		List<WebElement> pPrice =  driver.findElements(By.xpath("//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/a/span//following::a[3]"));
		
		
		for (WebElement author : pName){
			String authorName = author.getText().trim();
			ProductNames.add(authorName);
			
		}
		
		for (WebElement price : pPrice){
			String pricevalue = price.getText().trim();
			String alteredvalue  = pricevalue.replaceAll("\\r\\n|\\r|\\n", ".");
			ProductValue.add(alteredvalue);
			
		}
		
//		Fourvalue.put("name",ProductNames);
//		Fourvalue.put("value",ProductValue);
		System.out.println(ProductNames);
		System.out.println(ProductValue);
		  int rownum=0;
          int cellnum = 0;
          Iterator<String> iterator = ProductNames.iterator(); 
		 while (iterator.hasNext()) {
			 
             Iterator<String> tempIterator= ProductNames.iterator();
            
             Row row = sheet.createRow(rownum++);
             cellnum = 0;
             while (tempIterator.hasNext()) {
               
            	 String temp = (String) tempIterator.next();
                     Cell cell = row.createCell(cellnum++);
                             cell.setCellValue(temp);
			 
		 }
             workbook.write(out);
             out.close();
             workbook.close();
		System.out.print("Elnxecution Done");
		
		
		
		
			
		/*for (WebElement author : pName){
			String authorName = author.getText();
			values.add(authorName);
		}
		for (WebElement author1 : pPrice){
			String authorName1 = author1.getText();
			values.add(authorName1);
		}

		Fourvalue.put(i, values);
		System.out.println(Fourvalue.get(i;));*/
		
		/*Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("books.csv"), "utf-8"));
		writer.write(fileText);
		writer.close();
		driver.close();


		i++;
			//			System.out.println("Product name : " +authorName);
			//			String Url = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", allTitles.get(i++));
			//		final Pattern pattern = Pattern.compile("title=(.+?)>");
			//			final Matcher matcher = pattern.matcher(Url);
			//			matcher.find();
			//			String title = matcher.group(1);
			//			fileText = fileText+authorName+","+title+"\n";
		 *
		 */
	}

	}
}



















/*	//Declaration 
		HashMap<Integer,String> ProductName = new HashMap<Integer,String>();// To store product name
		HashMap<Integer,String> ProductPrice = new HashMap<Integer,String>();// To store product price
		HashMap<Integer,Object[]> Fourvalue = new HashMap<Integer,Object[]>();// To store all value 
 */

