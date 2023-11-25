package uitest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement loginlnk = driver.findElement(By.linkText("Log in"));
		loginlnk.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@12345");

		WebElement RememberMe = driver.findElement(By.id("remember-me"));
		RememberMe.click();

		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();

		String ErrorMsg = driver.findElement(By.className("error_msg")).getText();
		System.out.println(ErrorMsg);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of links are " + links.size());

	}

}
