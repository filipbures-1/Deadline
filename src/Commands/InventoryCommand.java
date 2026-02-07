package Commands;
import Characters.Player;
import Items.Item;
import java.util.ArrayList;

public class InventoryCommand implements Commands{
    private Player player;
    public InventoryCommand(Player player) {
        this.player = player;
    }
    /**
     * Executes the inventory command, listing all items in the players inventory.
     * @param commands command in the format "inventory".
     * @return message listing the items in the inventory.
     */
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
