package uitest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement createAcct = driver.findElement(By.xpath("//a[text()=\"Create new account\"]"));
		createAcct.click();

		WebElement FirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
		FirstName.sendKeys("Ramya");

		WebElement LastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
		LastName.sendKeys("Vaishnavi");

		WebElement EmailId = driver.findElement(By.xpath("//input[@name=\"reg_email__\"]"));
		EmailId.sendKeys("Abc@xyz.com");

		WebElement Password = driver.findElement(By.xpath("//input[@name=\"reg_passwd__\"]"));
		Password.sendKeys("Abc1234");

		WebElement Day = driver.findElement(By.id("day"));
		Select ddDay = new Select(Day);
		ddDay.selectByValue("23");

		WebElement Month = driver.findElement(By.id("month"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Apr");

		WebElement Year = driver.findElement(By.id("year"));
		Select ddYear = new Select(Year);
		ddYear.selectByValue("2005");

		WebElement Gender = driver.findElement(By.xpath("//input[@type = \"radio\" and @value = \"1\"]"));
		Gender.click();

		List<WebElement> Months = driver.findElements(By.xpath("//select[@id=\"month\"]/option"));
		for (WebElement mon : Months) {
			System.out.println("Month is " + mon.getText());

		}
		List<WebElement> Yrs = driver.findElements(By.xpath("//select[@id=\"year\"]/option"));
		for (WebElement years : Yrs) {
			System.out.println("Year is " + years.getText());
		}

		WebElement DOBMsg = driver.findElement(By.id("birthday-help"));
		DOBMsg.click();
		WebElement Msg = driver.findElement(By.className("_9hzn"));
		System.out.println(Msg.getText());

		WebElement SubmitBtn = driver.findElement(By.xpath("//button[@name=\"websubmit\"]"));
		SubmitBtn.click();

		driver.close();
	}

}
