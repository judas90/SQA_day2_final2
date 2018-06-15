import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class TestSelenium {
    WebDriver driver;
    

    /*

// IE

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
*/



    //  Test for GoogleChrome
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


    }



    @Test
    public void TestSelenium() {
        login("student", "luxoft");
        searchProject();
        reportIssue();
        blockEnterReportDetails();
        blockFillIN("Web", "Wind", "x64");
        blockFullDescription("Block", "описание дефекта", "Взять и починить.");
        ButtonSubmitReport();

    }

    public void blockFullDescription(String defectType, String defectDescription, String defectHowToFix) {
        driver.findElement(By.name("summary")).click();
        driver.findElement(By.name("summary")).clear();
        driver.findElement(By.name("summary")).sendKeys(defectType);
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("description")).sendKeys(defectDescription);
        driver.findElement(By.name("steps_to_reproduce")).click();
        driver.findElement(By.name("steps_to_reproduce")).clear();
        driver.findElement(By.name("steps_to_reproduce")).sendKeys(defectHowToFix);
    }

    public void ButtonSubmitReport() {
        driver.findElement(By.cssSelector("input.button")).click();
    }

    public void blockEnterReportDetails() {
        selectCategory("category_id");
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[3]/td[2]/select//option[1]")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[3]/td[2]/select//option[1]")).click();
        }
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[4]/td[2]/select//option[8]")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[4]/td[2]/select//option[8]")).click();
        }
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[5]/td[2]/select//option[6]")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[5]/td[2]/select//option[6]")).click();
        }
    }

    public void selectCategory(String idCategory) {


        Select select = new Select(driver.findElement(By.name(idCategory)));
        select.selectByVisibleText("[All Projects] General");


/*
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[2]/td[2]/select//option[2]")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[2]/td[2]/select//option[2]")).click();
        }
*/
    }

    public void reportIssue() {
        driver.findElement(By.linkText("Report Issue")).click();
    }

    public void searchProject() {
        if (!driver.findElement(By.xpath("//td[@class='login-info-right']/form/select//option[82]")).isSelected()) {
            driver.findElement(By.xpath("//td[@class='login-info-right']/form/select//option[82]")).click();
        }
    }

    public void blockFillIN(String platformName, String osName, String osVersionName) {
        driver.findElement(By.id("platform")).click();
        driver.findElement(By.id("platform")).clear();
        driver.findElement(By.id("platform")).sendKeys(platformName);
        driver.findElement(By.id("os")).click();
        driver.findElement(By.id("os")).clear();
        driver.findElement(By.id("os")).sendKeys(osName);
        driver.findElement(By.id("os_build")).click();
        driver.findElement(By.id("os_build")).clear();
        driver.findElement(By.id("os_build")).sendKeys(osVersionName);
        if (!driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[8]/td[2]/select//option[3]")).isSelected()) {
            driver.findElement(By.xpath("//div[3]/form/table/tbody/tr[8]/td[2]/select//option[3]")).click();
        }
    }

    public void Logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public void login(String username, String password) {
        driver.get("http://shipovalov.net/login_page.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.cssSelector("td.right")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//table[@class='width50']/tbody/tr[3]/td[2]")).click();
        driver.findElement(By.cssSelector("input.button")).click();
    }

    @AfterMethod
    public void tearDown() {
        Logout();
        driver.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
