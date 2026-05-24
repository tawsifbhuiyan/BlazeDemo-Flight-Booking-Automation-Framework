package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(name = "fromPort")
    private WebElement fromCity;
    
    @FindBy(name = "toPort")
    private WebElement toCity;
    
    @FindBy(css = "input[type='submit']")
    private WebElement findFlightsButton;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void selectDepartureCity(String city) {
        selectFromDropdown(fromCity, city);
    }
    
    public void selectDestinationCity(String city) {
        selectFromDropdown(toCity, city);
    }
    
    public void clickFindFlights() {
        clickElement(findFlightsButton);
    }
    
    public FlightsPage searchFlights(String from, String to) {
        selectDepartureCity(from);
        selectDestinationCity(to);
        clickFindFlights();
        return new FlightsPage(driver);
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
}