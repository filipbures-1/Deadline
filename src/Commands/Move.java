package Commands;

import Characters.Player;
import Locations.Room;

import java.util.ArrayList;

public class Move implements Commands{
    private Player player;
    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ");
        if (parts.length < 2) {
            return  "Select where you want to go";
        }
        Room currentRoom = player.getCurrentRoom();
        String RoomMoveName = parts[2];
        ArrayList<Room> neighbors = currentRoom.getNeighbors();
        if (!neighbors.contains(RoomMoveName)) {
            return "Select a neighboring room";
        }

        //player.setCurrentRoom(RoomMove);
        Room RoomMove = null;

        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
