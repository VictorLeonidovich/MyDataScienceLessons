package obtainingandcleaning.lesson13p37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
	//private final static String PATH = "https://cogenglab.csd.uwo.ca/rushdi.htm";
	private final static String PATH = "https://news.tut.by/society/591251.html";


	public static void main(String[] args) {
		TestSelenium test = new TestSelenium();
		String webData = test.extractDataWithSelenium(PATH);
		System.out.println(webData);
	}

	private String extractDataWithSelenium(String path) {
		System.out.println(1);
		System.setProperty("webdriver.chrome.driver", "supportingFiles/obtainingandcleaning/lesson13/chromedriver.exe");
		System.out.println(2);
		WebDriver driver = new ChromeDriver();
		System.out.println(3);
		driver.get(path);
		System.out.println(4);
		String webText = driver.findElement(By.xpath("//*[@id='article_body']")).getText(); //"//*[@id='content']"
		return webText;

	}

}
