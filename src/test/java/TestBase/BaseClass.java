package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.BasePage;

public class BaseClass<TakesScreenshot> {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"smoke","regression","sanity"})
	@Parameters({ "OS", "Browser" })
	public void browserSetup(String os, String br) throws IOException {
		FileReader file= new FileReader("C:\\Users\\sneho\\QaAutomationDemo\\OpenCart\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());

		switch (br) {
		case "Chrome":
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			;
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions option= new EdgeOptions();
			option.addArguments("--inrivate");
			driver = new EdgeDriver(option);
			break;
			
			default:
				System.out.println("Invalid Browser");
				return;
		}

		driver.get(p.getProperty("appURL"));
		// driver.get("https://openai.com/blog/chatgpt");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

	public String randomString() {
		String getStringvalue = RandomStringUtils.randomAlphabetic(5);
		return getStringvalue;

	}

	public String randomnumber() {
		String getNumvalue = RandomStringUtils.randomNumeric(9);
		return getNumvalue;

	}

	public String randomAlphanumeric() {
		String val = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(4);
		return (val + "@" + num);

	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		@SuppressWarnings("unchecked")
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = ((RemoteWebDriver) takesScreenshot).getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

	@AfterClass(groups= {"smoke","regression","sanity"})
	public void teardown() {
		driver.close();
	}
}
