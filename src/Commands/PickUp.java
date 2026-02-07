package Commands;
import Characters.Player;
import Items.Item;
import Main.GameData;

public class PickUp implements Commands{
    private Player player;
    private GameData world;
    public PickUp(Player player, GameData world) {
        this.player = player;
        this.world = world;
    }
    /**
     * Executes the pick up command, allowing the player to pick up an item from the current room if possible.
     * @param commands command in the format "pick [item name]".
     * @return message about the action result.
     */
    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        String itemName = parts[1].trim();
        Item itemToPick = null;
        for (Item item: world.items){
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToPick = item;
                break;
            }
        }
        if (itemToPick == null) {
            return "Item not found.";
        }
        if(!player.getCurrentRoom().getItemsInRoom().contains(itemToPick.getId())){
            return "Item is not in the current room.";
        }
        Item pickedItem = player.PickUpItem(itemToPick);
        if (pickedItem != null){
            return "You have picked up: " + pickedItem.getName();
        }
        if (player.getInventory().getItemsFromInventory().size()>= player.getInventory().getCapacity()){
            return "Your inventory is full.";
        } else {
            return "This item isnt available yet.";
        }
    }
;
    @Override
    public boolean exit() {
        return false;
    }

}
