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

public class Truck_Insurance {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://sampleapp.tricentis.com/101/");

        driver.findElement(By.partialLinkText("Truck")).click();

        WebElement truck=driver.findElement(By.xpath("//*[@id=\"make\"]"));
        Select company=new Select(truck);
        company.selectByValue("Mercedes Benz");

        driver.findElement(By.id("engineperformance")).sendKeys("300");
        driver.findElement(By.id("dateofmanufacture")).sendKeys("11/17/2022");

        WebElement seat=driver.findElement(By.id("numberofseats"));
        Select seats=new Select(seat);
        seats.selectByValue("2");

        WebElement fl= driver.findElement(By.id("fuel"));
        Select fuel=new Select(fl);
        fuel.selectByValue("Diesel");

        driver.findElement(By.id("payload")).sendKeys("500");
        driver.findElement(By.id("totalweight")).sendKeys("200");
        driver.findElement(By.id("listprice")).sendKeys("40000");
        driver.findElement(By.id("annualmileage")).sendKeys("250");
        driver.findElement(By.id("nextenterinsurantdata")).click();

        driver.findElement(By.id("firstname")).sendKeys("Diks");
        driver.findElement(By.id("lastname")).sendKeys("Rahangdale");
        driver.findElement(By.id("birthdate")).sendKeys("11/17/2002");

        List<WebElement> gender=driver.findElements(By.xpath("//*[@id='insurance-form']/div/section[2]/div[4]/p/label"));
        gender.get(0).click();

        driver.findElement(By.id("streetaddress")).sendKeys("Kothrud,Pune");
        WebElement coun= driver.findElement(By.id("country"));
        Select country=new Select(coun);
        country.selectByValue("India");

        driver.findElement(By.id("zipcode")).sendKeys("411038");
        driver.findElement(By.id("city")).sendKeys("Pune");

        WebElement occu=driver.findElement(By.id("occupation"));
        Select occup=new Select(occu);
        occup.selectByValue("Selfemployed");

        List<WebElement> hob=driver.findElements(By.xpath("//*[@id='insurance-form']/div/section[2]/div[10]/p/label"));
        hob.get(3).click();
        hob.get(4).click();

        driver.findElement(By.id("nextenterproductdata")).click();


        driver.findElement(By.id("startdate")).sendKeys("05/03/2025");
       WebElement ins= driver.findElement(By.id("insurancesum"));
       Select insurance=new Select(ins);
       insurance.selectByValue("5000000");


       WebElement dam=driver.findElement(By.id("damageinsurance"));
       Select damage=new Select(dam);
       damage.selectByValue("Full Coverage");

      List<WebElement> opt=driver.findElements(By.xpath("//*[@id='insurance-form']/div/section[3]/div[4]/p/label"));
       opt.get(0).click();

       driver.findElement(By.id("nextselectpriceoption")).click();

       String actprice="1,508.00";
       String claim="Submit";
       String disc="5";
       String cover="Limited";

       String price=driver.findElement(By.id("selectplatinum_price")).getText();

       String expclaim=driver.findElement(By.xpath("//*[@id='priceTable']/tbody/tr[2]/td[4]")).getText();

       String discount=driver.findElement(By.xpath("//*[@id='priceTable']/tbody/tr[3]/td[4]")).getText();

       String actcover=driver.findElement(By.xpath("//*[@id='priceTable']/tbody/tr[4]/td[4]")).getText();


        if ((actprice.equals(price)) && (claim.equals(expclaim)) && (disc.equals(discount)) && (cover.equals(actcover)))
        {
            driver.findElement(By.xpath("//*[@id='priceTable']/tfoot/tr/th[2]/label[3]/span")).click();
            driver.findElement(By.id("nextsendquote")).click();
            driver.findElement(By.id("email")).sendKeys("dikshitrahangdale123@gmail.com");
            driver.findElement(By.id("phone")).sendKeys("87679809788");
            driver.findElement(By.id("username")).sendKeys("Diks");
            String password="Diks@123";
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("confirmpassword")).sendKeys(password);
            driver.findElement(By.id("sendemail")).click();
            Thread.sleep(20000);
            File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(shot, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\Truck.JPEG"));
            driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
            driver.findElement(By.xpath("//*[@id='backmain']/span")).click();

        }
        else System.out.println("No Matching Value");

        driver.close();
    }
}

