import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


class UITest {

    WebDriver driver;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @org.junit.jupiter.api.Test
    void testGaussLoads() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/gauss");

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) ->
                d.findElement(By.id("a1")).isDisplayed() && d.findElement(By.id("a2")).isDisplayed() && d.findElement(By.id("a3")).isDisplayed() &&
                        d.findElement(By.id("a4")).isDisplayed() && d.findElement(By.id("a5")).isDisplayed() && d.findElement(By.id("a6")).isDisplayed() &&
                        d.findElement(By.id("a7")).isDisplayed() && d.findElement(By.id("a8")).isDisplayed() && d.findElement(By.id("a9")).isDisplayed() &&
                        d.findElement(By.id("b1")).isDisplayed() && d.findElement(By.id("b2")).isDisplayed() && d.findElement(By.id("b3")).isDisplayed() &&
                        d.findElement(By.id("calculate")).isDisplayed());

        Thread.sleep(3000);

        driver.quit();
    }


    @org.junit.jupiter.api.Test
    void testGaussLoads2() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/gauss");

        String[][] a = {{"", "", ""},
                {"", "", ""},
                {"", "", ""}};
        String[] y   =  {"", "", ""};

        driver.findElement(By.id("a1")).sendKeys(a[0][0]);
        Thread.sleep(200);
        driver.findElement(By.id("a2")).sendKeys(a[0][1]);
        Thread.sleep(200);
        driver.findElement(By.id("a3")).sendKeys(a[0][2]);
        Thread.sleep(200);
        driver.findElement(By.id("a4")).sendKeys(a[1][0]);
        Thread.sleep(200);
        driver.findElement(By.id("a5")).sendKeys(a[1][1]);
        Thread.sleep(200);
        driver.findElement(By.id("a6")).sendKeys(a[1][2]);
        Thread.sleep(200);
        driver.findElement(By.id("a7")).sendKeys(a[2][0]);
        Thread.sleep(200);
        driver.findElement(By.id("a8")).sendKeys(a[2][1]);
        Thread.sleep(200);
        driver.findElement(By.id("a9")).sendKeys(a[2][2]);
        Thread.sleep(200);
        driver.findElement(By.id("b1")).sendKeys(y[0]);
        Thread.sleep(200);
        driver.findElement(By.id("b2")).sendKeys(y[1]);
        Thread.sleep(200);
        driver.findElement(By.id("b3")).sendKeys(y[2]);

        Thread.sleep(1000);

        driver.findElement(By.id("calculate")).click();

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource().contains("Unable to get solution"));


        Thread.sleep(3000);

        driver.quit();
    }


    @org.junit.jupiter.api.Test
    void testGaussSolves() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/gauss");

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> !d.findElement(By.id("x1")).isDisplayed()
                && !d.findElement(By.id("x2")).isDisplayed() && !d.findElement(By.id("x3")).isDisplayed());

        String[][] a = {{"2", "4", "1"},
                {"5", "2", "1"},
                {"2", "3", "4"}};
        String[] y   =  {"36", "47", "37"};
        String[] x   =  {"7", "5", "2"};

        driver.findElement(By.id("a1")).sendKeys(a[0][0]);
        Thread.sleep(200);
        driver.findElement(By.id("a2")).sendKeys(a[0][1]);
        Thread.sleep(200);
        driver.findElement(By.id("a3")).sendKeys(a[0][2]);
        Thread.sleep(200);
        driver.findElement(By.id("a4")).sendKeys(a[1][0]);
        Thread.sleep(200);
        driver.findElement(By.id("a5")).sendKeys(a[1][1]);
        Thread.sleep(200);
        driver.findElement(By.id("a6")).sendKeys(a[1][2]);
        Thread.sleep(200);
        driver.findElement(By.id("a7")).sendKeys(a[2][0]);
        Thread.sleep(200);
        driver.findElement(By.id("a8")).sendKeys(a[2][1]);
        Thread.sleep(200);
        driver.findElement(By.id("a9")).sendKeys(a[2][2]);
        Thread.sleep(200);
        driver.findElement(By.id("b1")).sendKeys(y[0]);
        Thread.sleep(200);
        driver.findElement(By.id("b2")).sendKeys(y[1]);
        Thread.sleep(200);
        driver.findElement(By.id("b3")).sendKeys(y[2]);

        Thread.sleep(1000);

        driver.findElement(By.id("calculate")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("x1")).isDisplayed()
                && d.findElement(By.id("x2")).isDisplayed() && d.findElement(By.id("x3")).isDisplayed());


        Thread.sleep(1000);

        driver.findElement(By.id("cancel")).click();

        Thread.sleep(1000);

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> !d.findElement(By.id("x1")).isDisplayed()
                && !d.findElement(By.id("x2")).isDisplayed() && !d.findElement(By.id("x3")).isDisplayed());

        Thread.sleep(3000);

        driver.quit();
    }
}
