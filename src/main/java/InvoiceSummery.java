public class InvoiceSummery {
    private  int numberOfRides;
    private  double totalFare;
    private   double averageFare;

    public  InvoiceSummery(int numberOfRides, double totalFare) {

        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numberOfRides;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }
}


