package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ConfirmationPage extends BasePage {
    
    @FindBy(css = "h1")
    private WebElement confirmationHeader;
    
    @FindBy(css = "table tbody tr td")
    private List<WebElement> confirmationDetails;
    
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
    
    public String getConfirmationMessage() {
        return getText(confirmationHeader);
    }
    
    public boolean isBookingConfirmed() {
        return confirmationHeader.getText().contains("Thank you");
    }
    
    public String getConfirmationId() {
        String text = driver.getPageSource();
        if (text.contains("Id")) {
            return "Confirmed";
        }
        return "Not found";
    }
}