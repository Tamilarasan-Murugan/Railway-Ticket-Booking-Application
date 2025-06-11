public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Railway Ticket Booking System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Check Availability");
            System.out.println("4. Show Chart");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> system.book();
                case 2 -> system.cancel();
                case 3 -> system.availability();
                case 4 -> system.showChart();
                case 5 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}