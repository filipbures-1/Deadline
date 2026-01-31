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

    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        String itemName = parts[1].trim();
        Item itemToPick = null;
        if(world == null || world.items == null){
            return "Game data is not initialized.";
        }
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
        } else {
            return "You cannot pick up this item.";
        }
    }
;
    @Override
    public boolean exit() {
        return false;
    }

}
