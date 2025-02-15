package hotelbooking;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Lura Resort", Arrays.asList(101, 102, 103, 104, 105));

        Guest guest1 = new Guest("Tresi Senja", "1234567890", "tresi@example.com");

        hotel.checkAvailability();
        hotel.createBooking(guest1, 101, LocalDate.of(2025, 2, 20), LocalDate.of(2025, 2, 25));

        guest1.viewBookingHistory();
        hotel.listAllBookings();
    }
}
