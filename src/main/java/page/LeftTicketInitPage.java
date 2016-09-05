package page;

import org.openqa.selenium.*;

/**
 * Created by stoneshi on 16/9/5.
 */
public class LeftTicketInitPage extends BasePage{

    public WebElement input_departure;
    public WebElement input_destination;
    public WebElement input_departureDate;
    public WebElement btn_departureDate;
    public WebElement btn_ord;
    public WebElement btn_stu;
    public WebElement btn_query;
    public WebElement tb_result;


    public LeftTicketInitPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void initElement(){
        input_departure = getWebElement(ControlDefinitions.input_departure);
        input_destination = getWebElement(ControlDefinitions.input_destination);
        input_departureDate = getWebElement(ControlDefinitions.input_departureDate);
        btn_departureDate = getWebElement(ControlDefinitions.btn_departureDate);
        btn_ord = getWebElement(ControlDefinitions.btn_ord);
        btn_stu = getWebElement(ControlDefinitions.btn_stu);
        btn_query = getWebElement(ControlDefinitions.btn_query);
    }

    @Override
    public boolean IsPagePresent(){
        return getWebElement(ControlDefinitions.btn_query) != null;
    }

    public static class ControlDefinitions{
        public static By input_departure = By.xpath(".//*[@id='fromStationText']");
        public static By input_destination = By.xpath(".//*[@id='toStationText']");
        public static By input_departureDate = By.xpath(".//*[@id='train_date']");
        public static By btn_departureDate = By.xpath("html/body/div[29]/div[2]/div[2]/div[1]/div");
        public static By btn_ord = By.xpath(".//*[@id='sf1']");
        public static By btn_stu = By.xpath(".//*[@id='sf2']");
        public static By btn_query = By.xpath(".//*[@id='query_ticket']");
        public static By tb_result = By.xpath(".//*[@id='t-list']");
    }

    public void addInfo() throws Exception{
        input_departure.click();
        input_departure.sendKeys("上海");
        Thread.sleep(1000);
        input_departure.sendKeys(Keys.ENTER);
        input_destination.click();
        input_destination.sendKeys("北京");
        Thread.sleep(1000);
        input_destination.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        input_departureDate.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", getWebElement(ControlDefinitions.btn_departureDate));
        Thread.sleep(1000);
    }

    public void query() throws Exception{
        btn_query.click();
        Thread.sleep(5000);
        tb_result = getWebElement(ControlDefinitions.tb_result);
    }
}
