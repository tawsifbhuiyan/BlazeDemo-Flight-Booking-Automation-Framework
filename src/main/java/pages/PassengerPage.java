package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassengerPage extends BasePage {
    
    @FindBy(id = "inputName")
    private WebElement nameField;
    
    @FindBy(id = "address")
    private WebElement addressField;
    
    @FindBy(id = "city")
    private WebElement cityField;
    
    @FindBy(id = "state")
    private WebElement stateField;
    
    @FindBy(id = "zipCode")
    private WebElement zipCodeField;
    
    @FindBy(id = "cardType")
    private WebElement cardType;
    
    @FindBy(id = "creditCardNumber")
    private WebElement cardNumberField;
    
    @FindBy(id = "creditCardMonth")
    private WebElement cardMonthField;
    
    @FindBy(id = "creditCardYear")
    private WebElement cardYearField;
    
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCardField;
    
    @FindBy(css = "input[type='submit']")
    private WebElement purchaseFlightButton;
    
    public PassengerPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterPassengerDetails(String name, String address, String city, String state, String zip) {
        sendKeys(nameField, name);
        sendKeys(addressField, address);
        sendKeys(cityField, city);
        sendKeys(stateField, state);
        sendKeys(zipCodeField, zip);
    }
    
    public void enterPaymentDetails(String cardTypeValue, String cardNumber, String month, String year, String nameOnCard) {
        selectFromDropdown(cardType, cardTypeValue);
        sendKeys(cardNumberField, cardNumber);
        sendKeys(cardMonthField, month);
        sendKeys(cardYearField, year);
        sendKeys(nameOnCardField, nameOnCard);
    }
    
    public void clickPurchase() {
        clickElement(purchaseFlightButton);
    }
    
    public ConfirmationPage completeBooking(String name, String address, String city, String state, String zip,
                                            String cardType, String cardNumber, String month, String year, String nameOnCard) {
        enterPassengerDetails(name, address, city, state, zip);
        enterPaymentDetails(cardType, cardNumber, month, year, nameOnCard);
        clickPurchase();
        return new ConfirmationPage(driver);
    }
}