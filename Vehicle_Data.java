package Insurance;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Vehicle_Data {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://sampleapp.tricentis.com/101/");

		driver.findElement(By.partialLinkText("Autom")).click();
		WebElement car = driver.findElement(By.cssSelector("select[id='make'][name='Make']"));
		Select company = new Select(car);
		company.selectByValue("Mercedes Benz");

		driver.findElement(By.id("engineperformance")).sendKeys("300");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("11/17/2022");

		WebElement seat = driver.findElement(By.id("numberofseats"));
		Select seats = new Select(seat);
		seats.selectByValue("2");

		WebElement fl = driver.findElement(By.cssSelector("select[id='fuel']"));
		Select fuel = new Select(fl);
		fuel.selectByValue("Petrol");

		driver.findElement(By.id("listprice")).sendKeys("70000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("MH-35-2002");
		driver.findElement(By.id("annualmileage")).sendKeys("300");
		driver.findElement(By.id("nextenterinsurantdata")).click();

		// Insurant Data

		driver.findElement(By.id("firstname")).sendKeys("Dikshit");
		driver.findElement(By.id("lastname")).sendKeys("Rahangdale");
		driver.findElement(By.id("birthdate")).sendKeys("11/17/2002");
		try {

			List<WebElement> gender = driver
					.findElements(By.xpath("//div[@class='idealsteps-wrap']/section[2]/div[4]/p/label"));
			gender.get(0).click();
		} catch (Exception e) {
			System.out.println("Gender Code Not Work");
		}

		driver.findElement(By.id("streetaddress")).sendKeys("Kothrud,Pune");
		WebElement count = driver.findElement(By.id("country"));
		Select country = new Select(count);
		country.selectByValue("India");

		driver.findElement(By.id("zipcode")).sendKeys("411038");
		driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Pune");

		WebElement occu = driver.findElement(By.id("occupation"));
		Select occup = new Select(occu);
		occup.selectByValue("Selfemployed");

		driver.findElement(By.xpath("//p[@class='group']/label[4]")).click();
		driver.findElement(By.id("nextenterproductdata")).click();

		// Product Data

		driver.findElement(By.id("startdate")).sendKeys("03/03/2025");

		WebElement insurance = driver.findElement(By.id("insurancesum"));
		Select insur = new Select(insurance);
		insur.selectByValue("7000000");

		WebElement rating = driver.findElement(By.id("meritrating"));
		Select rate = new Select(rating);
		rate.selectByValue("Bonus 8");

		WebElement damage = driver.findElement(By.id("damageinsurance"));
		Select dam = new Select(damage);
		dam.selectByValue("Full Coverage");

		List<WebElement> aa = driver
				.findElements(By.xpath("html/body/div/div/div/div/div/form/div/section[3]/div[5]/p/label"));
		aa.get(0).click();

		WebElement courtesy = driver.findElement(By.id("courtesycar"));
		Select court = new Select(courtesy);
		court.selectByValue("No");

		driver.findElement(By.id("nextselectpriceoption")).click();

		String exp = "2,646.00";
		String onliClaim = "Submit";
		String discount = "10";
		String cover = "Unlimited";

		String price = driver.findElement(By.id("selectultimate_price")).getText();
		String actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[5]")).getText();
		String actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[5]")).getText();
		String actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[5]")).getText();

       //   Compair all Actual and Expected
		if ((exp.equals(price)) && (onliClaim.equals(actClaim)) && (discount.equals(actDis))
				&& (cover.equals(actCover))) {

			List<WebElement> priceBtn = driver.findElements(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label"));
			priceBtn.get(3).click();
			driver.findElement(By.id("nextsendquote")).click();
			driver.findElement(By.cssSelector("input[id='email']")).sendKeys("dikshitrahangdale123@gmail.com");
			driver.findElement(By.id("phone")).sendKeys("8767809789");
			driver.findElement(By.id("username")).sendKeys("Dikshit");
			String pass = "Diks@2002";
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.id("confirmpassword")).sendKeys(pass);
			driver.findElement(By.id("Comments")).sendKeys("Mercedes Maybach S-680");
			driver.findElement(By.id("sendemail")).click();
			Thread.sleep(20000);
			File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(shot, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\Automobile.JPEG"));
			driver.findElement(By.cssSelector("button[class='confirm']")).click();
			driver.findElement(By.cssSelector("i[class='fa fa-home']")).click();
			
		} else
			System.out.println("Not Match");
        
		driver.close();
		
	}
}
