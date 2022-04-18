import java.util.ArrayList;

public interface InvoiceGeneratorIF {
    public double calculateFare(double distance, int time, String type);
    public double calculateFare(Ride[] rides, String type);
    public InvoiceSummery calculateFareReturnObject(ArrayList<Ride> rides, String type);
}
