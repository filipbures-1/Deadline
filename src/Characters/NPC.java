package Characters;

import Items.Item;
import Locations.Room;

public class NPC {
    private String id;
    private String name;
    private String homeRoomId;
    private String description;

    public String Dialog(){
        return null;
    }
    public String GiftItem(Item item, Player player){
        return null;
    }

    public NPC(String id, String name, String homeRoomId, String description) {
        this.id = id;
        this.name = name;
        this.homeRoomId = homeRoomId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeRoomId() {
        return homeRoomId;
    }

    public String getDescription() {
        return description;
    }
}
