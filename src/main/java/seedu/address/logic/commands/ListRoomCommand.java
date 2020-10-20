package seedu.address.logic.commands;

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.room.Room;

public class ListRoomCommand extends Command {

    public static final String COMMAND_WORD = "listRoom";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all rooms.\n";
    public static final String MESSAGE_SUCCESS = "Successfully retrieved all rooms";

    /**
     * Creates a ListRoomCommand.
     */
    public ListRoomCommand() {}

    @Override
    public CommandResult execute(Model model) throws CommandException {
        ObservableList<Room> roomList = model.getRoomBook().getRoomList();
        ObservableList<Integer> retList = FXCollections.observableArrayList(roomList.stream()
                .map(Room::getRoomID).collect(Collectors.toList()));

        return new CommandResult(MESSAGE_SUCCESS + "\n" + model.displayRooms(retList));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        return other instanceof ListRoomCommand;
    }
}
