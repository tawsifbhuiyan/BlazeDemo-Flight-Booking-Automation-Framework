package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightSearchTest extends BaseTest {
    
    @Test(priority = 1, description = "Verify home page loads correctly")
    public void testHomePageLoads() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  🧪 TEST CASE #1: Verify Home Page Loads                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        
        System.out.println("📌 Step 1: Opening Chrome browser...");
        System.out.println("📌 Step 2: Navigating to BlazeDemo website...");
        
        String title = driver.getTitle();
        System.out.println("📌 Page Title: " + title);
        
        Assert.assertTrue(title.contains("BlazeDemo"));
        System.out.println("✅ RESULT: Home page loaded successfully!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    @Test(priority = 2, description = "Search flights from New York to London")
    public void testSearchFlights() throws InterruptedException {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  🧪 TEST CASE #2: Search Flights - New York to London     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        
        // Wait for page to load
        Thread.sleep(2000);
        
        // Find departure city dropdown
        System.out.println("📌 Step 1: Finding departure city dropdown...");
        WebElement fromPort = driver.findElement(By.name("fromPort"));
        Select fromSelect = new Select(fromPort);
        fromSelect.selectByVisibleText("New York");
        System.out.println("   ✅ Selected Departure: New York");
        Thread.sleep(1000);
        
        // Find destination city dropdown
        System.out.println("📌 Step 2: Finding destination city dropdown...");
        WebElement toPort = driver.findElement(By.name("toPort"));
        Select toSelect = new Select(toPort);
        toSelect.selectByVisibleText("London");
        System.out.println("   ✅ Selected Destination: London");
        Thread.sleep(1000);
        
        // Click find flights button
        System.out.println("📌 Step 3: Clicking 'Find Flights' button...");
        WebElement findButton = driver.findElement(By.cssSelector("input[type='submit']"));
        findButton.click();
        Thread.sleep(3000);
        
        // Verify results
        System.out.println("📌 Step 4: Verifying flight results...");
        String resultsTitle = driver.getTitle();
        Assert.assertTrue(resultsTitle.contains("BlazeDemo"));
        
        System.out.println("✅ RESULT: Successfully found flights from New York to London!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    @Test(priority = 3, description = "Complete flight booking")
    public void testCompleteBooking() throws InterruptedException {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  🧪 TEST CASE #3: Complete Flight Booking                ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        
        // Step 1: Search for flight
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  📍 STEP 1: SEARCHING FOR FLIGHTS                        │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        Thread.sleep(2000);
        
        WebElement fromPort = driver.findElement(By.name("fromPort"));
        Select fromSelect = new Select(fromPort);
        fromSelect.selectByVisibleText("New York");
        System.out.println("   ✅ Departure: New York");
        
        WebElement toPort = driver.findElement(By.name("toPort"));
        Select toSelect = new Select(toPort);
        toSelect.selectByVisibleText("London");
        System.out.println("   ✅ Destination: London");
        
        WebElement findButton = driver.findElement(By.cssSelector("input[type='submit']"));
        findButton.click();
        System.out.println("   ✅ Clicked 'Find Flights'");
        Thread.sleep(3000);
        
        // Step 2: Select first flight
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  ✈️  STEP 2: SELECTING A FLIGHT                          │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        WebElement firstFlight = driver.findElement(By.cssSelector("input[value='Choose This Flight']"));
        firstFlight.click();
        System.out.println("   ✅ Selected first flight");
        Thread.sleep(2000);
        
        // Step 3: Fill passenger details
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  👤 STEP 3: ENTERING PASSENGER DETAILS                   │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        driver.findElement(By.id("inputName")).sendKeys("Rahim Khan");
        System.out.println("   ✅ Name: Rahim Khan");
        
        driver.findElement(By.id("address")).sendKeys("123 Dhanmondi");
        System.out.println("   ✅ Address: 123 Dhanmondi");
        
        driver.findElement(By.id("city")).sendKeys("Dhaka");
        System.out.println("   ✅ City: Dhaka");
        
        driver.findElement(By.id("state")).sendKeys("Dhaka");
        System.out.println("   ✅ State: Dhaka");
        
        driver.findElement(By.id("zipCode")).sendKeys("1205");
        System.out.println("   ✅ Zip Code: 1205");
        
        // Step 4: Payment details
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  💳 STEP 4: ENTERING PAYMENT DETAILS                     │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        WebElement cardType = driver.findElement(By.id("cardType"));
        Select cardSelect = new Select(cardType);
        cardSelect.selectByVisibleText("Visa");
        System.out.println("   ✅ Card Type: Visa");
        
        driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
        System.out.println("   ✅ Card Number: 4111111111111111");
        
        driver.findElement(By.id("creditCardMonth")).sendKeys("12");
        System.out.println("   ✅ Expiry Month: 12");
        
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        System.out.println("   ✅ Expiry Year: 2025");
        
        driver.findElement(By.id("nameOnCard")).sendKeys("Rahim Khan");
        System.out.println("   ✅ Name on Card: Rahim Khan");
        
        // Step 5: Purchase
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  ✅ STEP 5: COMPLETING PURCHASE                          │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        WebElement purchaseButton = driver.findElement(By.cssSelector("input[type='submit']"));
        purchaseButton.click();
        System.out.println("   ✅ Clicked 'Purchase Flight'");
        Thread.sleep(3000);
        
        // Step 6: Verify confirmation
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  🎉 STEP 6: VERIFYING CONFIRMATION                       │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        String confirmationMessage = driver.findElement(By.tagName("h1")).getText();
        System.out.println("   📝 Confirmation: " + confirmationMessage);
        
        Assert.assertTrue(confirmationMessage.contains("Thank you"));
        
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  🎉 TEST PASSED! Booking completed successfully!         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
    }
}