package hotelbooking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Booking {
    private String guestName;
    private int roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int stayDuration;
    private final String bookingID;
    private static int totalBookings = 0;
    private double totalPrice;

    // Constructor
    public Booking(String guestName, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        if (checkOutDate.isBefore(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingID = UUID.randomUUID().toString();
        totalBookings++;
        calculateStayDuration();
        calculatePrice();
    }

    // Calculate stay duration in nights
    private void calculateStayDuration() {
        this.stayDuration = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    // Calculate total price with discount logic
    private void calculatePrice() {
        double pricePerNight = 100.0;
        totalPrice = stayDuration * pricePerNight;
        if (stayDuration > 7) {
            totalPrice *= 0.9; // 10% discount for stays longer than 7 nights
        }
    }

    // Confirm booking
    public void confirmBooking() {
        System.out.println("Booking Confirmed!");
        System.out.println("Guest: " + guestName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Stay Duration: " + stayDuration + " nights");
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Booking ID: " + bookingID);
    }

    // Modify check-in and check-out dates
    public void modifyDates(LocalDate newCheckIn, LocalDate newCheckOut) {
        if (newCheckOut.isBefore(newCheckIn)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        this.checkInDate = newCheckIn;
        this.checkOutDate = newCheckOut;
        calculateStayDuration();
        calculatePrice();
        System.out.println("Booking dates updated successfully.");
    }

    public static int getTotalBookings() {
        return totalBookings;
    }

    public String getBookingID() {
        return bookingID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getStayDuration() {
        return stayDuration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
