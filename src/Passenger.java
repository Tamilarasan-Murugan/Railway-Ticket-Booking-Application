public class Passenger {
    int id;
    String name;
    String coachType;
    int seatNumber;
    boolean isWaiting;

    public Passenger(int id, String name, String coachType, int seatNumber, boolean isWaiting) {
        this.id = id;
        this.name = name;
        this.coachType = coachType;
        this.seatNumber = seatNumber;
        this.isWaiting = isWaiting;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Coach: " + coachType +
                ", Seat No: " + seatNumber + (isWaiting ? " (Waiting)" : "");
    }
}