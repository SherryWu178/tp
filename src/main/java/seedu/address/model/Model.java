package seedu.address.model;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.booking.Booking;
import seedu.address.model.person.Person;
import seedu.address.model.room.Room;
import seedu.address.model.roomservice.RoomService;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
    Predicate<Booking> PREDICATE_SHOW_ALL_BOOKINGS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' person book file path.
     */
    Path getPersonBookFilePath();

    /**
     * Sets the user prefs' person book file path.
     */
    void setPersonBookFilePath(Path addressBookFilePath);

    /**
     * Returns the user prefs' booking book file path.
     */
    Path getBookingBookFilePath();

    /**
     * Sets the user prefs' booking book file path.
     */
    void setBookingBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setPersonBook(ReadOnlyPersonBook personBook);

    /** Returns the PersonBook */
    ReadOnlyPersonBook getPersonBook();

    /**
     * Replaces booking book data with the data in {@code bookingBook}.
     */
    void setBookingBook(ReadOnlyBookingBook bookingBook);

    /** Returns the BookingBook */
    ReadOnlyBookingBook getBookingBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Returns true if a person with the id is in the address book.
     */
    boolean hasPersonWithId(Integer id);

    /**
     * Return person with matching id.
     */
    Person getPersonWithId(Integer id);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    // Room Book Methods
    void addRoom(Room r);

    void setRooms(List<Room> rooms);

    void resetData(ReadOnlyRoomBook newData);

    void resetData(ReadOnlyBookingBook newData);

    String displayRooms(ObservableList<Integer> rooms);

    String displaySingleRooms(ObservableList<Integer> rooms);

    String displayDoubleRooms(ObservableList<Integer> rooms);

    String displaySuiteRooms(ObservableList<Integer> rooms);

    boolean hasRoom(int roomId);

    Room getRoom(Integer roomId);

    ObservableList<Integer> getAvailableRooms(ObservableList<Integer> unavailableRooms);

    ReadOnlyRoomBook getRoomBook();

    // Booking Book Methods

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasBooking(Booking booking);

    /**
     * Returns true if a person with the id is in the address book.
     */
    boolean hasBookingWithId(Integer id);

    Booking getBookingWithId(Integer id);

    /**
     * Deletes the given booking.
     * The booking must exist in the booking book.
     */
    void deleteBooking(Booking target);

    /**
     * Deletes all booking associated with the personId.
     * The booking must exist in the booking book.
     */
    void deleteBookingByPersonId(Integer personId);

    void addBooking(Booking b);

    void setBookings(List<Booking> bookings);

    void setBooking(Booking target, Booking editedBooking);

    ObservableList<Integer> getUnavailableRooms(LocalDate startDate, LocalDate endDate);

    // boolean hasBooking(int roomId);

    Booking getBooking(int roomId);

    void setBookingInactive(int bookingId);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /** Returns an unmodifiable view of the filtered booking list */
    ObservableList<Booking> getFilteredBookingList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredBookingList(Predicate<Booking> predicate);


    /**
     * Room Service Book Methods
     */
    void addRoomService(RoomService rs);

    public ObservableList<RoomService> getRoomServicesForBooking(Integer bookingId);

    public void setRoomServiceBook(ReadOnlyRoomServiceBook roomServiceBook);

    public ReadOnlyRoomServiceBook getRoomServiceBook();
}
