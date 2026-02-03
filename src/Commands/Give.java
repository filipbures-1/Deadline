package Commands;
import Characters.NPC;
import Characters.Player;
import Items.Item;
import Main.GameData;

import java.util.ArrayList;

public class Give implements Commands {
    private Player player;
    public Give(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 3);
        String npcToGiveName = parts[1].trim();
        String itemToGiveName = parts[2].trim();
        ArrayList<Item> items = player.getInventory().getItemsFromInventory();
        if (items == null) return "Your inventory is empty.";

        Item itemToGive = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemToGiveName)) {
                itemToGive = item;
                break;
            }
        }
        if (itemToGive == null) {
            return "Item " + itemToGiveName + " is not in your inventory.";
        }

        if (player.getCurrentRoom().getNpcsInRoom() == null) {
            return "There are no NPCs in the room.";
        }

        for (NPC npc : player.getCurrentRoom().getNpcsInRoom()) {
            if (npc.getName().equalsIgnoreCase(npcToGiveName)) {
                if (npc.getName().equalsIgnoreCase("theodore")) {
                    if (itemToGive.getName().equalsIgnoreCase("old drawing compass")) {
                        player.getInventory().RemoveItem(itemToGive);
                        String deathmessage = "Theodore beat you up. You lost.";
                        System.out.println(deathmessage);
                        System.exit(0);
                        return deathmessage;
                    }

                    if (itemToGive.getName().equalsIgnoreCase("drawing compass")) {

                        player.getInventory().RemoveItem(itemToGive);

                        boolean cheatsheetFound = false;
                        GameData world = player.getWorld();

                        for (Item item : world.items) {
                            String name = item.getName();
                            if (name.equalsIgnoreCase("cheatsheet")) {
                                item.setPickable(true);
                                cheatsheetFound = true;
                                break;
                            }
                        }


                        if (cheatsheetFound) {
                            return "Theodore accepted the deal, you can now pick up the Cheatsheet.";
                        }
                    }
                    return "Theodore only wants his classmates drawing compass. You can try to decieve him with a different one.";
                }

                if (npc.getName().equalsIgnoreCase("principal")) {
                    if (itemToGive.getName().equalsIgnoreCase("completed homework")) {
                        player.getInventory().RemoveItem(itemToGive);
                        return "You handed over your work to the Principal. You win!";
                    } else {
                        return "Principal only wants Completed homework.";
                    }
                }

                return "This person doesnt want anything from you.";
            }
        }
        return "NPC " + npcToGiveName + " is not in this room.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
