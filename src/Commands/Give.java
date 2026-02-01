package Commands;
import Characters.NPC;
import Characters.Player;
import Items.Item;

import java.util.ArrayList;

public class Give implements Commands{
    private Player player;
    public Give(Player player) {
        this.player = player;
    }
    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 3);
        String itemToGiveName = parts[1];
        String npcToGiveName = parts[2];
        ArrayList<Item> items = player.getInventory().getItemsFromInventory();
        Item itemToGive = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemToGiveName)) {
                itemToGive = item;
                break;
            }
        }
        if (itemToGive == null) {
            return "Item " + itemToGiveName + " not found in inventory";
        }
        for (NPC npc : player.getCurrentRoom().getNpcsInRoom()) {
            if (npc.getName().equalsIgnoreCase(npcToGiveName)) {
                items.remove(itemToGive);
                return "You have given " + itemToGive.getName() + " to " + npc.getName() + ".";
            }
        }
        return "NPC " + npcToGiveName + " not found in the room.";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
