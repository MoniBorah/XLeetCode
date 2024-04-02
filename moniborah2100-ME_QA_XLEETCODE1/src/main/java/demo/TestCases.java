package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    @SuppressWarnings("deprecation")
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String homePageURL = driver.getCurrentUrl();
        if(homePageURL.contains("leetcode")) {
            System.out.println("TestCase01 : Homepage URL successfully verified");
        } 
        else{
            System.out.println("TestCase01 : Homepage URL not verified");
        }
        
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");
        WebElement viewQuestion = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        viewQuestion.click();
        Thread.sleep(2000);
        String homePageURL = driver.getCurrentUrl();
        if(homePageURL.contains("problemset")) {
            System.out.println("TestCase02 : URL contains problemset"); 
        }
        else {
            System.out.println("TestCase02 : URL contains problemset");
        }

        WebElement list = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]"));
        List<WebElement> problemSet = list.findElements(By.xpath("//div[@class='odd:bg-layer-1 even:bg-overlay-1 dark:odd:bg-dark-layer-bg dark:even:bg-dark-fill-4']"));
        // int i = 1;
        // while(i < problemSet.size()) {
        //     String problemSetList = problemSet.get(i).getText();
        //     System.out.println(problemSetList);
        //     i++;
        //     if( i > 6) {
        //         break;
        //     }
            
        // }

        for(int i = 1; i <= problemSet.size(); i++) {
            System.out.println(problemSet.get(i).getText());
         if(i > 4) {
            break;
         }
        }
        System.out.println("TestCase02: Passed");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");

        WebElement viewQuestion = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        viewQuestion.click();
        Thread.sleep(2000);

        WebElement twoSum = driver.findElement(By.xpath("//a[text()='Two Sum']"));
        twoSum.click();
        Thread.sleep(2000);
        String currentURL = driver.getCurrentUrl();
        if(currentURL.contains("two-sum")) {
            System.out.println("TestCase03 : URL contains two-sum");
        }
        else {
            System.out.println("TestCase03 : URL does not contains two-sum");
        }

        System.out.println("TestCase03: Passed");
    }    
   
    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");

        WebElement viewQuestion = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        viewQuestion.click();
        Thread.sleep(2000);

        WebElement twoSum = driver.findElement(By.xpath("//a[text()='Two Sum']"));
        twoSum.click();
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/button"));
        button.click();
        Thread.sleep(2000);
        WebElement skip = driver.findElement(By.xpath("//div[@class='__floater__body']//button[@title='Skip']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(skip).click().perform();
        Thread.sleep(5000);


        WebElement submission = driver.findElement(By.xpath("//*[@id='submissions_tab']/div[2]/div[2]"));
        submission.click();
        WebElement submissionClick = driver.findElement(By.xpath("//a[@href='/accounts/login/?next=%2Fproblems%2Ftwo-sum%2Fsubmissions%2F']"));              ////*[@id='79b4f5c9-7bea-3500-1be6-586ca221b150']/div/div/a
        String text = submissionClick.getText();
        if(text.contains("Register or Sign In")) {
            System.out.println("TestCase04 : Submission link contains the required text");   
        }
        else {
            System.out.println("TestCase04 : Submission link contains the required text"); 
        }

        System.out.println("TestCase04: Passed");
    }


}
