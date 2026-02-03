package Commands;

import Characters.Player;
import Locations.Room;

public class Move implements Commands{
    private Player player;

    public Move(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        if (parts.length < 2) {
            return  "Select where you want to go";
        }
        Room currentRoom = player.getCurrentRoom();
        String RoomMoveName = parts[1];
        if (currentRoom == null){
            return "The player doesnt have a current room";
        }
        Room RoomMove = currentRoom.GetNeighborByName(RoomMoveName);
        if (RoomMove == null){
            return "Select a neighboring room";
        }
        player.setCurrentRoom(RoomMove);
        return "";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
