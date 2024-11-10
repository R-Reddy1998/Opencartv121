package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static  WebDriver driver;
	public Logger logger; // log4j
	public Properties P;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" }) // (groups={"Sanity","Regression","Master"}) it is a
																// group the all the test cases
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// loading config.properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		P = new Properties();
		P.load(file);

		logger = LogManager.getLogger(this.getClass());

		// crossbrowser Testing
		switch (br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default:System.out.println("invalid browser name..");return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(P.getProperty("URL")); // reading url from config.properties file
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" }) // (groups={"Sanity","Regression","Master"}) it is a
																// grouping method all the test cases
	public void tearDown() {
		driver.quit();
	}

	public String randomeString() // this string is used for fname lname
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}

	public String randomNumber() // this string is used for mobile number
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomAlphaNumaric() // this string used for password it will generate the alphbates&number like
										// reddy@1234
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring + "@" + generatednumber);
	}

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		SourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
