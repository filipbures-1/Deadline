package Commands;
import Characters.Player;
import Items.Item;
import Locations.Room;

public class Use implements Commands {
    private final Player player;

    public Use(Player player) {
        this.player = player;
    }
    /**
     * Executes the use command, allowing the player to use specific items in certain rooms.
     * @param commands command in the format "use [item name]".
     * @return message about the action result.
     */
    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        String itemToUse = parts[1];
        Room currentRoom = player.getCurrentRoom();

        for (Item item : player.getInventory().getItemsFromInventory()) {
            if (item.getName().equalsIgnoreCase(itemToUse)) {
                if (item.getId().equals("item_phone") && currentRoom.getId().equals("loc_library")) {
                    for (Item worldItem : player.getWorld().items) {
                        if (worldItem.getId().equals("item_homeworkphoto")) {
                            worldItem.setPickable(true);
                            return "You took the picture of the homework. The homework photo is now pickable.";
                        }
                    }
                }
                if (item.getId().equals("item_energydrink") && currentRoom.getId().equals("loc_adamshouse")) {
                    boolean hasCheatsheet = false;
                    boolean hasHomeworkList = false;
                    boolean hasHomeworkPhoto = false;

                    for (Item itemInInventory : player.getInventory().getItemsFromInventory()) {
                        if ("item_cheatsheet".equals(itemInInventory.getId())) {
                            hasCheatsheet = true;
                        } else if ("item_homeworklist".equals(itemInInventory.getId())) {
                            hasHomeworkList = true;
                        } else if ("item_homeworkphoto".equals(itemInInventory.getId())) {
                            hasHomeworkPhoto = true;
                        }
                    }

                    if (hasCheatsheet && hasHomeworkList && hasHomeworkPhoto) {
                        player.getInventory().RemoveItem(item);
                        for (Item worldItem : player.getWorld().items) {
                            if ("item_completedhomework".equals(worldItem.getId())) {
                                worldItem.setPickable(true);
                                break;
                            }
                        }
                        return "You drank the energy drink and finished your homework with ease!" +
                                "\nYou can now pick up the Completed homework.";
                    } else {
                        return "You need the cheatsheet, homework list, and homework photo before using the energy drink.";
                    }
                }

                return "You have no use for this item.";
            }
        }
        return "This item is not in your inventory.";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
