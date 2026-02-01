package Commands;
import Items.Inventory;
import Characters.Player;
import Items.Item;

import java.util.ArrayList;

public class Drop implements Commands{
    private Player player;
    public Drop(Player player) {
        this.player = player;
    }


    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        ArrayList<Item> items = player.getInventory().getItemsFromInventory();
        String itemToDropName = parts[1];
        Item itemToDrop = null;
        for (Item item: items){
            if (item.getName().equalsIgnoreCase(itemToDropName)){
                itemToDrop = item;
                break;
            }
        }
        if (itemToDrop == null){
            return "Item " + itemToDropName + " not found in inventory";
        }
        if (!itemToDrop.isDropable()){
            return "Item " + itemToDrop.getName() + " cannot be dropped.";
        }
        player.getCurrentRoom().addItemToRoom(itemToDrop.getId());
        items.remove(itemToDrop);
        return "You have dropped: " + itemToDropName;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
