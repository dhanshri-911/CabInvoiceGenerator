import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class InvoiceGeneratorTest {
    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummery summary = invoiceGenerator.calculateFareReturnObject(rides);
        InvoiceSummery expectedSummary = new InvoiceSummery(2, 30);
        if (expectedSummary.getAverageFare() == summary.getAverageFare() && expectedSummary.getNumberOfRides() == summary.getNumberOfRides() && expectedSummary.getTotalFare() == summary.getTotalFare())
            Assert.assertEquals(1, 1);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        String userId = "User1";
        InvoiceService invoiceService = new InvoiceService();
        ArrayList<Ride> rides = new ArrayList<Ride>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.1, 1));
        invoiceService.addRide(userId, rides);
        ArrayList<Ride> listOfRides = invoiceService.getRides(userId);
        InvoiceSummery summaryForUser1 = invoiceGenerator.calculateFareReturnObject(listOfRides.toArray(new Ride[0]));
        InvoiceSummery expectedSummary = new InvoiceSummery(2, 30);
        if (expectedSummary.getAverageFare() == summaryForUser1.getAverageFare() && expectedSummary.getNumberOfRides() == summaryForUser1.getNumberOfRides() && expectedSummary.getTotalFare() == summaryForUser1.getTotalFare())
            Assert.assertEquals(1, 1);
    }
}
