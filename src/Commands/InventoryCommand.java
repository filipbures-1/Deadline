package Commands;

import Characters.Player;
import Items.Inventory;
import Items.Item;

import java.util.ArrayList;

public class InventoryCommand implements Commands{
    private Player player;
    public InventoryCommand(Player player) {
        this.player = player;
    }
    @Override
    public String execute(String commands) {
        ArrayList<Item> items = player.getInventory().getItemsFromInventory();
        StringBuilder inventoryList = new StringBuilder("Your inventory contains: ");
        if (items.isEmpty()) {
            inventoryList.append("nothing");
        } else {
            for (Item item: items) {
                String name = item.getName();
                inventoryList.append(name).append(", ");
            }
        }
        return inventoryList.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
