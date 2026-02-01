
package Locations;

import Characters.NPC;
import Items.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> items;
    private ArrayList<Room> neighbors;
    private ArrayList<String> neighborIds;
    private ArrayList<String> requiredItems;
    private String ItemsRequiered;
    private boolean isLocked;
    private ArrayList<NPC> npcs;

    //private boolean isAvailable;

    public String ShowRoomDescription(String description) {
        return null;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getNeighborIds() {
        return neighborIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Room> getNeighbors() {
        if (neighbors == null) {
            neighbors = new ArrayList<>();
        }
        return neighbors;
    }

    public void AddNeighbors(Room room) {
        if (neighbors == null) {
            neighbors = new ArrayList<>();
        }
        neighbors.add(room);
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getItemsRequiered() {
        return ItemsRequiered;
    }

    // zjistujeme mistnot podle jmena do ktere se chceme dostat pomoci move commandu
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

    public String getDescription() {
        return description;
    }

    public void setNeighbors(ArrayList<Room> neighbors) {
        this.neighbors = neighbors;
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
    public ArrayList<String> getItemsInRoom(){
        if(items == null) {
            items = new ArrayList<>();
            System.out.println("There are no items in this room.");
        }
        return items;
    }
    public boolean removeItemFromRoom(String itemId){
        if (items == null){
            return false;
        }
        return items.remove(itemId);
    }
    public void addItemToRoom(String itemId){
        if(items == null){
            items = new ArrayList<>();
        }
        items.add(itemId);
    }
    public ArrayList<NPC> getNpcsInRoom() {
        if (npcs == null){
            npcs = new ArrayList<>();
        }
        return npcs;
    }
    public void AddNPCtoRoom(NPC npc){
        if (npcs == null){
            npcs = new ArrayList<>();
        }
        npcs.add(npc);
    }
    public boolean removeNPCFromRoom(NPC npc){
        if (npcs == null){
            return false;
        }
        return npcs.remove(npc);
    }
}