package tests;

import pages.HomePage;
import pages.FlightsPage;
import pages.PassengerPage;
import pages.ConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingFlowTest extends BaseTest {
    
    @Test(priority = 1, description = "Complete flight booking flow")
    public void testCompleteBookingFlow() throws InterruptedException {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  🧪 TEST CASE #5: Complete Flight Booking Flow           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        
        // Step 1: Search flights
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  📍 STEP 1: SEARCHING FOR FLIGHTS                        │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        System.out.println("   → Opening departure city dropdown...");
        Thread.sleep(500);
        System.out.println("   → Selecting 'New York' as departure city");
        Thread.sleep(500);
        System.out.println("   → Opening destination city dropdown...");
        Thread.sleep(500);
        System.out.println("   → Selecting 'London' as destination city");
        Thread.sleep(500);
        
        HomePage homePage = new HomePage(driver);
        FlightsPage flightsPage = homePage.searchFlights("New York", "London");
        
        System.out.println("   → Clicking 'Find Flights' button");
        Thread.sleep(1000);
        System.out.println("   ✅ Found " + flightsPage.getFlightCount() + " flights available");
        
        // Step 2: Select a flight
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  ✈️  STEP 2: SELECTING A FLIGHT                          │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        System.out.println("   → Analyzing flight options...");
        Thread.sleep(500);
        System.out.println("   → Flight: " + flightsPage.getFirstFlightDetails());
        System.out.println("   → Price: " + flightsPage.getFirstFlightPrice());
        System.out.println("   → Clicking 'Choose This Flight' button");
        
        flightsPage.selectFirstFlight();
        Thread.sleep(1000);
        System.out.println("   ✅ Flight selected successfully");
        
        // Step 3: Fill passenger details
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  👤 STEP 3: ENTERING PASSENGER DETAILS                   │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        PassengerPage passengerPage = new PassengerPage(driver);
        
        System.out.println("   → Entering Name: Rahim Khan");
        Thread.sleep(300);
        System.out.println("   → Entering Address: 123 Dhanmondi");
        Thread.sleep(300);
        System.out.println("   → Entering City: Dhaka");
        Thread.sleep(300);
        System.out.println("   → Entering State: Dhaka");
        Thread.sleep(300);
        System.out.println("   → Entering Zip Code: 1205");
        Thread.sleep(300);
        
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  💳 STEP 4: ENTERING PAYMENT DETAILS                     │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        System.out.println("   → Selecting Card Type: Visa");
        Thread.sleep(300);
        System.out.println("   → Entering Card Number: 4111111111111111");
        Thread.sleep(300);
        System.out.println("   → Entering Expiry Month: 12");
        Thread.sleep(300);
        System.out.println("   → Entering Expiry Year: 2025");
        Thread.sleep(300);
        System.out.println("   → Entering Name on Card: Rahim Khan");
        Thread.sleep(500);
        
        System.out.println("   → Clicking 'Purchase Flight' button");
        
        ConfirmationPage confirmationPage = passengerPage.completeBooking(
            "Rahim Khan", "123 Dhanmondi", "Dhaka", "Dhaka", "1205",
            "Visa", "4111111111111111", "12", "2025", "Rahim Khan"
        );
        
        Thread.sleep(2000);
        
        // Step 4: Verify confirmation
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  ✅ STEP 5: VERIFYING BOOKING CONFIRMATION               │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        System.out.println("   → Checking confirmation page...");
        Thread.sleep(1000);
        
        Assert.assertTrue(confirmationPage.isBookingConfirmed());
        
        System.out.println("   → Confirmation Message: " + confirmationPage.getConfirmationMessage());
        System.out.println("   → Booking ID: " + confirmationPage.getConfirmationId());
        
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  🎉 TEST PASSED! Booking completed successfully!         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
    }
}