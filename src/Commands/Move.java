package Commands;

import Characters.Player;
import Items.Item;
import Locations.Room;

import java.util.ArrayList;
import java.util.List;

public class Move implements Commands{
    private Player player;

    public Move(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        Room currentRoom = player.getCurrentRoom();
        String RoomMoveName = parts[1];
        Room RoomMove = currentRoom.GetNeighborByName(RoomMoveName);
        if (RoomMove == null){
            return "Select a neighboring room";
        }
        if (RoomMove.isLocked()){
            ArrayList<String> itemsRequiered = RoomMove.getItemsrequiered();
            ArrayList<String> itemsMissing = new ArrayList<>();
            ArrayList<Item> inventoryItems = player.getInventory().getItemsFromInventory();
            for (String itemId : itemsRequiered){
                boolean found = false;
                for (Item item : inventoryItems){
                    if (item.getId().equals(itemId)){
                        found = true;
                        break;
                    }
                }
                if (!found){
                    String itemName = itemId;
                    for (Item item : player.getWorld().items){
                        if (itemId.equals(item.getId())) {
                            itemName = item.getName();
                            itemsMissing.add(itemName);
                            break;
                        }
                    }
                }

            }

            if (!itemsMissing.isEmpty()) {
                return "You cant go home yet you are still missing: " + itemsMissing + " to help you finish the homework.";
            }
        }
        player.setCurrentRoom(RoomMove);
        return "";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
