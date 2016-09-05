package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;
import java.util.List;
/**
 * Created by stoneshi on 16/9/5.
 */
public abstract class BasePage {
    protected WebDriver driver = null;

    public BasePage(WebDriver Driver) {
        this.driver = Driver;
    }

    public void waitForPagePresent() {
        new WebDriverWait(driver, 30)
                .until(new Predicate<WebDriver>() {
                    public boolean apply(WebDriver arg0) {
                        return IsPagePresent();
                    }
                });
    }

    public abstract boolean IsPagePresent();

    public abstract void initElement();

    public List<WebElement> getWebElements(By by) {
        try {
            return driver.findElements(by);
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public WebElement getWebElement(By by) {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public void initPage(){
        waitForPagePresent();
        if (IsPagePresent()) {
            initElement();
        }
    }

}
