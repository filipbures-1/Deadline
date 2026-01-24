package Commands;

import Characters.Player;
import Items.Item;
import Locations.Room;

import java.util.ArrayList;
import java.util.List;

public class Move implements Commands{
    private Player player;
    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ");
        if (parts.length < 2) {
            return  "Select where you want to go";
        }
        Room currentRoom = player.getCurrentRoom();
        String RoomMoveName = parts[1];
        ArrayList<Room> neighbors = currentRoom.getNeighbors();
        if (!neighbors.contains(RoomMoveName)) {
            return "Select a neighboring room";
        }
//        Room RoomMove = null;
//        for (Room room :) {
//            if (room.getName().equals(RoomMoveName)) {
//                RoomMove = room;
//                break;
//            }
//        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
