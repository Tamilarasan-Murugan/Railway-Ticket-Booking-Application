import java.util.*;

public class Coach {
    String type;
    int totalSeats = 60;
    int waitingLimit = 10;
    List<Passenger> confirmed;
    List<Passenger> waiting;

    public Coach(String type) {
        this.type = type;
        confirmed = new ArrayList<>();
        waiting = new ArrayList<>();
    }

    public boolean bookPassenger(Passenger p) {
        if (confirmed.size() < totalSeats) {
            confirmed.add(p);
            return true;
        } else if (waiting.size() < waitingLimit) {
            waiting.add(p);
            p.isWaiting = true;
            return true;
        }
        return false;
    }

    public boolean cancelPassenger(int id) {
        for (int i = 0; i < confirmed.size(); i++) {
            if (confirmed.get(i).id == id) {
                confirmed.remove(i);
                if (!waiting.isEmpty()) {
                    Passenger moved = waiting.remove(0);
                    moved.isWaiting = false;
                    moved.seatNumber = confirmed.size() + 1;
                    confirmed.add(moved);
                }
                return true;
            }
        }

        return waiting.removeIf(p -> p.id == id);
    }

    public void showChart() {
        System.out.println("Coach Type: " + type);
        for (Passenger p : confirmed) System.out.println(p);
        for (Passenger p : waiting) System.out.println(p);
    }

    public void showAvailability() {
        System.out.println(type + ": Seats Available - " + (totalSeats - confirmed.size()) +
                ", Waiting Available - " + (waitingLimit - waiting.size()));
    }
}