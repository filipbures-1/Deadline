package Locations;
import Characters.NPC;
import java.util.ArrayList;

public class Room {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> items;
    private ArrayList<Room> neighbors;
    private ArrayList<String> neighborIds;
    private ArrayList<String> itemsrequiered;
    private ArrayList<NPC> npcs;
    private boolean isLocked;

    public String getId() {
        return id;
    }

    public ArrayList<String> getNeighborIds() {
        return neighborIds;
    }

    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Gets the neighboring rooms of this room.
     * @return list of neighboring rooms.
     */
    public ArrayList<Room> getNeighbors() {
        if (neighbors == null) {
            neighbors = new ArrayList<>();
        }
        return neighbors;
    }
    /**
     * Adds a neighboring room to this room.
     * @param room the neighboring room to add.
     */
    public void AddNeighbors(Room room) {
        if (neighbors == null) {
            neighbors = new ArrayList<>();
        }
        neighbors.add(room);
    }

    /**
     * Gets the item IDs required to enter this room.
     * @return list of requiered item IDs.
     */
    public ArrayList<String> getItemsrequiered() {
        if (itemsrequiered == null){
            itemsrequiered = new ArrayList<>();
        }
        return itemsrequiered;
    }
    /**
     * Finds a neighboring room by its name.
     * @param moveRoomName the name of the neighboring room to find.
     * @return the neighboring room if found, null otherwise.
     */
    public Room GetNeighborByName(String moveRoomName){
        for (Room neighbor: neighbors){
            if (neighbor.getName().equals(moveRoomName)){
                return neighbor;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Room(String description, String name, String id) {
        this.description = description;
        this.name = name;
        this.id = id;
        neighbors = new ArrayList<>();
        neighborIds = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }
    /**
     * Gets the items currently in this room.
     * @return list of item IDs in the room.
     */
    public ArrayList<String> getItemsInRoom(){
        if(items == null) {
            items = new ArrayList<>();
        }
        return items;
    }
    /**
     * Removes an item from the room.
     * @param itemId the ID of the item to remove.
     * @return true if the item was removed, false otherwise.
     */
    public boolean removeItemFromRoom(String itemId){
        if (items == null){
            return false;
        }
        return items.remove(itemId);
    }

    /**
     * Adds an item to the room.
     * @param itemId the ID of the item to add.
     */
    public void addItemToRoom(String itemId){
        if(items == null){
            items = new ArrayList<>();
        }
        items.add(itemId);
    }
    /**
     * Gets the NPCs currently in this room.
     * @return list of NPCs in the room.
     */
    public ArrayList<NPC> getNpcsInRoom() {
        if (npcs == null){
            npcs = new ArrayList<>();
        }
        return npcs;
    }
    /**
     * Adds an NPC to the room.
     * @param npc the NPC to add.
     */
    public void AddNPCtoRoom(NPC npc){
        if (npcs == null){
            npcs = new ArrayList<>();
        }
        npcs.add(npc);
    }
}