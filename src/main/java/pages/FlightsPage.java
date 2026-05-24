package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FlightsPage extends BasePage {
    
    @FindBy(css = "table tbody tr")
    private List<WebElement> flightRows;
    
    @FindBy(css = "input[type='submit']")
    private List<WebElement> chooseFlightButtons;
    
    @FindBy(css = "h3")
    private WebElement pageHeader;
    
    public FlightsPage(WebDriver driver) {
        super(driver);
    }
    
    public int getFlightCount() {
        return flightRows.size();
    }
    
    public String getFirstFlightDetails() {
        if (flightRows.size() > 0) {
            List<WebElement> cells = flightRows.get(0).findElements(By.tagName("td"));
            if (cells.size() >= 4) {
                return cells.get(0).getText() + " - " + cells.get(1).getText();
            }
        }
        return "No flights found";
    }
    
    public String getFirstFlightPrice() {
        if (flightRows.size() > 0) {
            List<WebElement> cells = flightRows.get(0).findElements(By.tagName("td"));
            if (cells.size() >= 5) {
                return cells.get(4).getText();
            }
        }
        return "Price not found";
    }
    
    public void selectFirstFlight() {
        if (chooseFlightButtons.size() > 0) {
            clickElement(chooseFlightButtons.get(0));
        }
    }
    
    public void selectFlightByIndex(int index) {
        if (chooseFlightButtons.size() > index) {
            clickElement(chooseFlightButtons.get(index));
        }
    }
}