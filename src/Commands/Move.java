package Commands;
import Characters.NPC;
import Characters.Player;
import Items.Item;
import Locations.Room;
import java.util.ArrayList;
import java.util.Scanner;

public class Move implements Commands{
    private Player player;
    private Scanner scanner = new Scanner(System.in);
    private boolean hasTriggeredAdamsMomDialog = false;

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
            } else {
                player.setCurrentRoom(RoomMove);

                if (!hasTriggeredAdamsMomDialog) {
                    hasTriggeredAdamsMomDialog = true;
                    return triggerAdamsMomDialog();
                }
                return "";
            }
        }
        player.setCurrentRoom(RoomMove);
        return "";
    }

    /**
     * Triggers automatic dialog with Adams mom when player enters home with all items.
     * @return dialogue with Adams mom.
     */
    private String triggerAdamsMomDialog() {
        NPC adamsMom = null;
        for (NPC npc : player.getCurrentRoom().getNpcsInRoom()) {
            if ("npc_adamsmother".equals(npc.getId())) {
                adamsMom = npc;
                break;
            }
        }

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println(adamsMom.getName() + ": Adam! Did you finish your homework yet?");
            System.out.println("1) Im working on it right now, mom!");
            System.out.println("2) No, and I dont plan to.");
            System.out.println("3) Leave");
            System.out.print(">>> ");
            String response = scanner.nextLine().trim();
            switch (response) {
                case "1":
                    return "GOOD! Make sure you hand it in on time. I dont want to hear any complaints from the principal again!";
                case "2":
                    return "WHAT?! Get to work right now, young man! Or youre grounded for a month!";
                case "3":
                    return "DONT YOU DARE WALK AWAY FROM ME! GO DO YOUR HOMEWORK OR ELSE!";
                default:
                    System.out.println("This choice doesnt exist.");
            }
        }
    }
    @Override
    public boolean exit() {
        return false;
    }
}
