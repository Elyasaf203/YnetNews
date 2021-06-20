package Tests;

import Pages.FirstArticlePage;
import Pages.YnetPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class MainTest {
    // Variables definition
    public static Document doc = null;
    public static WebDriver driver;


    protected static YnetPage ynetPage;
    protected static FirstArticlePage firstArticlePage;

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    @BeforeClass
    public void setup() {
        driver = initChromeDriver();
        driver.manage().window().maximize();
        driver.get(getData("URL"));
        ynetPage = new YnetPage(driver);
        firstArticlePage = new FirstArticlePage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    public void readXmlFile() {
        DocumentBuilder dBuilder;
        File fXmlFile = new File("./Configuration/Config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
    }

    public String getData(String value) {
        if (doc == null) {
            readXmlFile();
        }
        return doc.getElementsByTagName(value).item(0).getTextContent();
    }
}
