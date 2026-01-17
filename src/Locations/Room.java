
package Locations;

import Characters.NPC;
import Items.Item;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private NPC npc;
    private ArrayList<Item> items;
    private boolean isAvailable;
    private Room UpRoom;
    private Room DownRoom;
    private Room RightRoom;
    private Room LeftRoom;

    public String ShowRoomDescription(String description){
        return null;
    }

    public Room(String name, String description, NPC npc, boolean isAvailable, Room upRoom, Room downRoom, Room rightRoom, Room leftRoom) {
        this.name = name;
        this.description = description;
        this.npc = npc;
        this.items = new ArrayList<>();
        this.isAvailable = isAvailable;
        UpRoom = upRoom;
        DownRoom = downRoom;
        RightRoom = rightRoom;
        LeftRoom = leftRoom;
    }
}
