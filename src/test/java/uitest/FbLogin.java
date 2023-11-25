package uitest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement EmailAdd = driver.findElement(By.id("email"));
		EmailAdd.sendKeys("abc@xyz.com");

		WebElement Password = driver.findElement(By.id("pass"));
		Password.sendKeys("abc1234");

		WebElement LoginBtn = driver.findElement(By.name("login"));
		LoginBtn.click();

		WebElement Msg = driver.findElement(By.className("_9kpn"));
		System.out.println(Msg);

		WebElement close = driver.findElement(By.className("_9ai5"));
		close.click();
	}

}
