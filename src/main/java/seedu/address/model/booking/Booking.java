package seedu.address.model.booking;

import static java.time.temporal.ChronoUnit.DAYS;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.Objects;


public class Booking {
    private static Integer nextAvailableId;

    // Identity fields
    private final Integer id;
    private final Integer roomId;
    private final Integer personId;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Boolean isActive;


    /**
     * Every field must be present and not null. Used for creating a new Booking with a unique id.
     */
    public Booking(Integer roomId, Integer personId, LocalDate startDate, LocalDate endDate, Boolean isActive) {
        requireAllNonNull(roomId, personId, startDate, endDate);
        this.roomId = roomId;
        this.personId = personId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.id = nextAvailableId;
        nextAvailableId += 1;
    }

    /**
     * Every field must be present and not null. Used for creating a Booking with an existing id.
     */
    public Booking(Integer roomId, Integer personId, LocalDate startDate, LocalDate endDate, Boolean isActive,
                   Integer id) {
        requireAllNonNull(roomId, personId, startDate, endDate, id);
        this.roomId = roomId;
        this.personId = personId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.id = id;
    }

    /**
     * Sets next available id to be used
     */
    public static void setNextAvailableId(Integer id) {
        Booking.nextAvailableId = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    /**
     * Returns the number of the nights of a booking.
     */
    public int getDuration() {
        long noOfDaysBetween = DAYS.between(startDate, endDate);
        int duration = (int) noOfDaysBetween;
        return duration;
    }

    /**
     * Returns true if two booking conflict with each other.
     *
     * @param otherBooking Another Booking object.
     * @return a boolean.
     */
    public boolean hasConflict(Booking otherBooking) {
        LocalDate start = getStartDate();
        LocalDate end = getEndDate();
        LocalDate otherBookingStart = otherBooking.getStartDate();
        LocalDate otherBookingEnd = otherBooking.getEndDate();

        return otherBookingStart.isBefore(end) && otherBookingEnd.isAfter(start);

    }


    /**
     * Returns true if both bookings have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Booking)) {
            return false;
        }

        Booking otherBooking = (Booking) other;
        return otherBooking.getId().equals(getId())
                && otherBooking.getRoomId().equals(getRoomId())
                && otherBooking.getPersonId().equals(getPersonId())
                && otherBooking.getStartDate().equals(getStartDate())
                && otherBooking.getEndDate().equals(getEndDate())
                && otherBooking.isActive();
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(roomId, personId, startDate, endDate, isActive);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Id: ")
                .append(getId())
                .append(" Room Id: ")
                .append(getRoomId())
                .append(" Person Id: ")
                .append(getPersonId())
                .append(" Start Date: ")
                .append(getStartDate())
                .append(" End Date: ")
                .append(getEndDate())
                .append(" Active: ")
                .append(isActive());
        return builder.toString();
    }

}