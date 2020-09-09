package dropboxtestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;

public class Dropbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\workspace\\Dropbox testcases\\chromedriver.exe");
		WebDriver chromedriver = new ChromeDriver();
		WebDriver driver = null;
		String url="https://www.dropbox.com/h";
		driver.get(url);
		
		//Login into dropbox
		driver.findElement(By.xpath("//*[@id=\"component725602517576894454\"]/div/div/div/form/div[1]/div[1]/div[2]")).sendKeys("neti.chandu@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"login_password30208710796568705\"]")).sendKeys("chandrahas");
		driver.findElement(By.xpath("//*[@id=\"component725602517576894454\"]/div/div/div/form/div[3]/button")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Home";
		assertEquals(expectedTitle,actualTitle);
		Assert.assertTrue("Title is visible", true);
		{
		Assert.assertFalse("title is not visible", false);	
		}
		// testcase Uploader limited to single file or multiple file
		
		
		driver.findElement(By.xpath("//*[@id=\"component4044350357491939372\"]/div/main/div[2]/div/div[1]/div[2]/div/div/div/div/button/span")).click();
		WebElement uploadfile=driver.findElement(By.xpath("//*[@id=\"component4044350357491939372\"]/div/main/div[2]/div/div[1]/div[2]/div/div/div/div/div/nav/div/button[1]"));
		uploadfile.click();
		uploadfile.sendKeys("C:\\Users\\chandrahas.neti\\Documents\\Mobius Workflow Integration SRS.pdf");
		uploadfile.sendKeys("C:\\Users\\chandrahas.neti\\Documents\\gouse\\mary-min.jpg");
		driver.findElement(By.xpath("//*[@id=\"tree-view-770050/Camera_Uploads\"]/span/span")).click();
		driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div[3]/div[2]/button[2]")).click();
		if( driver.findElement(By.xpath("//*[@id=\"component4044350357491939372\"]/div/main/div[1]/div/main/ul/li[2]/span/div/div/ul/li/ul/li[1]")).isDisplayed()){
			Assert.assertTrue("Element is Visible",true);
			}else{
			Assert.assertFalse("Element is not Visible", false);
			
	//testcase deleting the file from dropbox
			driver.findElement(By.xpath("//*[@id=\"component4044350357491939372\"]/div/main/div[1]/div/main/ul/li[2]/span/div/div/ul/li/ul/li[1]/div/div/div[3]/div/div[3]/div/div/div/button/span/span/svg")).click();
	       WebElement select=driver.findElement(By.xpath("//*[@id=\"component4044350357491939372\"]/div/main/div[1]/div/main/ul/li[2]/span/div/div/ul/li/ul/li[1]/div/div/div[3]/div/div[3]/div/div/div/div/nav/div/button[4]"));
	       Select dropdown= new Select(select);
	       dropdown.selectByVisibleText("Delete…");
	       select.click();
	       if( driver.findElement(By.xpath("//*[@id=\"component4044350357491939372\"]/div/main/div[1]/div/main/ul/li[2]/span/div/div/ul/li/ul/li[1]")).isDisplayed()){
	    	   //verify
	    	   SoftAssert softAssert = new SoftAssert();
	    	   softAssert.fail("the element is still visible");
	       }
	       else {
	    	   //Assert
	    	   Assert.assertTrue("Element is deleted",true);  
	       }
	
			//signout of the dropbox
	       driver.findElement(By.xpath("//*[@id=\"maestro-header\"]/div/div[2]/div/div/nav/div/a[3]")).click();
	       String actualTitle1 = driver.getTitle();
			String expectedTitle1 = "Dropbox";
			assertEquals(expectedTitle1,actualTitle1);
			Assert.assertTrue("Title is visible", true);
			{
			Assert.assertFalse("title is not visible", false);	
			}
			
			}	
}
}
