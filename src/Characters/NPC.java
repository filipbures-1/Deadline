package Characters;

import Items.Item;
import Locations.Room;

public class NPC {
    private String name;
    private String description;
    private Room Room;

    public String Dialog(){
        return null;
    }
    public String GiftItem(Item item, Player player){
        return null;
    }

    public NPC(String name, String description, Room room) {
        this.name = name;
        this.description = description;
        Room = room;
    }
}
