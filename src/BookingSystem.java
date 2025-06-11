import java.util.*;

public class BookingSystem {
    Map<String, Coach> coaches = new HashMap<>();
    int idCounter = 1;
    Scanner sc = new Scanner(System.in);

    public BookingSystem() {
        coaches.put("AC", new Coach("AC"));
        coaches.put("NONAC", new Coach("NonAC"));
        coaches.put("SEATER", new Coach("Seater"));
    }

    public void book() {
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Choose Coach (AC / NONAC / SEATER): ");
        String coach = sc.next().toUpperCase();

        Coach selected = coaches.get(coach);
        if (selected == null) {
            System.out.println("Invalid coach type.");
            return;
        }

        Passenger p = new Passenger(idCounter++, name, selected.type, selected.confirmed.size() + 1, false);
        if (selected.bookPassenger(p)) {
            System.out.println("Booking successful. " + (p.isWaiting ? "Added to waiting list." : "Seat No: " + p.seatNumber));
        } else {
            System.out.println("Booking failed. No seats or waiting list available.");
        }
    }

    public void cancel() {
        System.out.print("Enter Passenger ID to cancel: ");
        int id = sc.nextInt();

        for (Coach coach : coaches.values()) {
            if (coach.cancelPassenger(id)) {
                System.out.println("Cancellation successful.");
                return;
            }
        }
        System.out.println("Passenger ID not found.");
    }

    public void availability() {
        for (Coach c : coaches.values()) {
            c.showAvailability();
        }
    }

    public void showChart() {
        for (Coach c : coaches.values()) {
            c.showChart();
            System.out.println("------------");
        }
    }
}