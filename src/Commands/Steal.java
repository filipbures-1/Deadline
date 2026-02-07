package Commands;
import Characters.Player;
import Items.Item;
import Main.GameData;
import Locations.Room;

public class Steal implements Commands {
    private final Player player;
    private final GameData world;

    public Steal(Player player, GameData world) {
        this.player = player;
        this.world = world;
    }

    /**
     * Executes the steal command, allowing the player to steal an item if they are in Theodore's homeroom.
     * Item becomes pickable after stealing.
     * @param commands command in the format "steal [item name]".
     * @return message about the action result.
     */
    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        String itemToSteal = parts[1];
        Room current = player.getCurrentRoom();
        if (!"Theodores homeroom".equalsIgnoreCase(current.getName())) {
            return "You cant steal here, go to Theodores classroom.";
        }
        Item found = null;
        for (Item item : world.items) {
            String name = item.getName();
            String id = item.getId();
            if ((name.equalsIgnoreCase(itemToSteal)) || (id.equalsIgnoreCase(itemToSteal))) {
                found = item;
                break;
            }
        }

        if (found == null){
            return "This item isnt here: " + itemToSteal;
        }
        found.setPickable(true);
        return "You stole Theodores drawing compass, you can now pick it up.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
