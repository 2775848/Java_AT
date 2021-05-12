package homework.task9;

public class Baggage {
    public String airline;
    public String flightClass;
    public int maxWeight;

    public Baggage(String airline, String flightClass, int maxWeight) {
        this.airline = airline;
        this.flightClass = flightClass;
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "airline='" + airline + '\'' +
                ", flightClass='" + flightClass + '\'' +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
