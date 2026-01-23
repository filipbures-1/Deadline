
package Locations;

import Characters.NPC;
import Items.Item;

import java.util.ArrayList;

public class Room {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> items;
    private ArrayList<Room> neighbors;
    private ArrayList<String> neighborIds;

    //private boolean isAvailable;

    public String ShowRoomDescription(String description){
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
        return neighbors;
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

    public Room(String description, String name, String id, ArrayList<Room> neighbors) {
        this.description = description;
        this.name = name;
        this.id = id;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                ", neighbors=" + neighbors +
                '}';
    }
}
