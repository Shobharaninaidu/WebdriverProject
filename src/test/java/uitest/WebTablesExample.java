package uitest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// Find total number of rows in the table
		List<WebElement> Rows = driver.findElements(By.xpath("//table [@class=\"ws-table-all\"]/tbody/tr"));
		System.out.println("Total num of rows are " + Rows.size());

		// Find total number of columns in the table
		List<WebElement> Columns = driver.findElements(By.xpath("//table [@class=\"ws-table-all\"]/tbody/tr/th"));
		System.out.println("Total num of colums are " + Columns.size());

		String CompamnyName = "Island Trading";

		// Solution -1

		for (int i = 2; i <= Rows.size(); i++) {

			WebElement Company = driver
					.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" + i + "]/td[1]"));

			if (Company.getText().equals(CompamnyName)) {

				WebElement Contact = driver
						.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" + i + "]/td[2]"));
				WebElement Country = driver
						.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" + i + "]/td[3]"));

				System.out.println(Contact.getText());
				System.out.println(Country.getText());
			}

		}

	}

}
