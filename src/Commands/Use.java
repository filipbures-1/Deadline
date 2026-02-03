
package Commands;

import Characters.Player;
import Items.Item;

public class Use implements Commands {
    private final Player player;

    public Use(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        String itemToUse = parts[1];
        for (Item item : player.getInventory().getItemsFromInventory()) {
            String name = item.getName();
            if ((name.equalsIgnoreCase(itemToUse))) {
                return "you used " + item.getName() + ".";
            }
        }
        return "This item is not in your inventory";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
