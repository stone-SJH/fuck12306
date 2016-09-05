package test;

/**
 * Created by stoneshi on 16/9/5.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.LeftTicketInitPage;

public class getTicketInfoTest {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://kyfw.12306.cn/otn/leftTicket/init");
        try {
            LeftTicketInitPage leftTicketInitPage = new LeftTicketInitPage(driver);
            leftTicketInitPage.initPage();
            leftTicketInitPage.addInfo();
            leftTicketInitPage.query();
            String result = leftTicketInitPage.tb_result.getText();
            System.out.print(result);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}