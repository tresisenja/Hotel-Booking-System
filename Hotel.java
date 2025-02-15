package hotelbooking;

import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private String hotelName;
    private List<Integer> availableRooms;
    private List<Booking> bookings;

    public Hotel(String hotelName, List<Integer> availableRooms) {
        this.hotelName = hotelName;
        this.availableRooms = new ArrayList<>(availableRooms);
        this.bookings = new ArrayList<>();
    }

    public void checkAvailability() {
        System.out.println("Available rooms: " + availableRooms);
    }

    public void createBooking(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (!availableRooms.contains(roomNumber)) {
            System.out.println("Room " + roomNumber + " is not available.");
            return;
        }
        Booking newBooking = new Booking(guest.getName(), roomNumber, checkIn, checkOut);
        bookings.add(newBooking);
        guest.addBooking(newBooking);
        availableRooms.remove((Integer) roomNumber);
        newBooking.confirmBooking();
    }

    public void cancelBooking(String bookingID) {
        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
            availableRooms.add(bookingToRemove.getRoomNumber());
            System.out.println("Booking " + bookingID + " has been canceled.");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    public void listAllBookings() {
        bookings.sort(Comparator.comparing(Booking::getCheckInDate));
        for (Booking booking : bookings) {
            System.out.println(booking.getGuestName() + " - Room " + booking.getRoomNumber() + " - Check-in: " + booking.getCheckInDate());
        }
    }
}

