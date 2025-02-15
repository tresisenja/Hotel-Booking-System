package hotelbooking;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String name;
    private String contactNumber;
    private String email;
    private List<Booking> bookingHistory;

    public Guest(String name, String contactNumber, String email) {
        if (!contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid contact number. Must be 10 digits.");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }

    public void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings found for " + name);
            return;
        }
        System.out.println("Booking History for " + name + ":");
        for (Booking booking : bookingHistory) {
            System.out.println("Booking ID: " + booking.getBookingID() +
                    " | Room: " + booking.getRoomNumber() +
                    " | Check-in: " + booking.getCheckInDate() +
                    " | Check-out: " + booking.getCheckOutDate() +
                    " | Duration: " + booking.getStayDuration() + " nights");
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalBookings() {
        return bookingHistory.size();
    }
}
