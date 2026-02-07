package Commands;
import Characters.Player;
import Items.Item;
import Locations.Room;
import java.util.ArrayList;

public class Move implements Commands{
    private Player player;

    public Move(Player player) {
        this.player = player;
    }
    /**
     * Executes the move command, moving the player to a neighboring room if possible.
     * Checks if the room is locked and if the player has the required items to enter.
     * @param commands command in the format "move [room name]".
     * @return message about the action result.
     */
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
