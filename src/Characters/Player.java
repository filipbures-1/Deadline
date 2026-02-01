package Characters;

import Items.Inventory;
import Items.Item;
import Locations.Room;

import java.util.ArrayList;

public class Player {
    private String name;
    private String description;
    private Inventory inventory;
    private Room CurrentRoom;
    private Item CurrentItem;

    public Item PickUpItem(Item item){
        if (item == null){
            return null;
        }
        if (!item.isPickable()) {
            //System.out.println("You cannot pick up this item.");
            return null;
        }
        if (inventory == null){
            return null;
        }
        boolean added = inventory.AddItem(item);
        if (added == true){
            if (CurrentRoom != null){
                CurrentRoom.removeItemFromRoom(item.getId());
            }
            return item;
        }
        //System.out.println("Your inventory is full.");
        return null;
    }


    public Item DropItem(Item item){
        return null;
    }
    public Item StealItem(Item item){
        return null;
    }
    public Item GiveItem(Item item){
        return null;
    }
    public Item UseItem(Item item){
        return null;
    }
    public Room MoveRooms(String roomMoveName){
        CurrentRoom = CurrentRoom.GetNeighborByName(roomMoveName);
        return CurrentRoom;
    }
    public String Talk(NPC npc){
        return null;
    }

    public Room getCurrentRoom() {
        return CurrentRoom;
    }
    public Inventory getInventory(){
        return inventory;
    }
    public Item getCurrentItem(){
        return CurrentItem;
    }

    public void setCurrentRoom(Room currentRoom) {
        CurrentRoom = currentRoom;
        System.out.println("You are in: " + CurrentRoom.getName());
        ArrayList<Room> neighbors = CurrentRoom.getNeighbors();
        if (neighbors == null || neighbors.isEmpty()) {
            System.out.println("Neighbours: none");
        } else {
            StringBuilder StringNeighbours = new StringBuilder("Neighbours: ");
            for (Room room : neighbors) {
                if (room != null && room.getName() != null) {
                    StringNeighbours.append(room.getName()).append(", ");
                }
            }
            System.out.println(StringNeighbours.toString());
        }
        ArrayList<NPC> npcsInRoom = CurrentRoom.getNpcsInRoom();
        if (npcsInRoom == null || npcsInRoom.isEmpty()) {
            System.out.println("People in the room: none");
        } else {
            StringBuilder StringNPCs = new StringBuilder("People in the room: ");
            for (NPC npc : npcsInRoom) {
                if (npc != null && npc.getName() != null) {
                    StringNPCs.append(npc.getName()).append(", ");
                }
            }
            System.out.println(StringNPCs.toString());
        }
    }

    public Player(String name, String description, Inventory inventory, Room currentRoom, Item currentItem) {
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        CurrentRoom = currentRoom;
        CurrentItem = currentItem;
        setCurrentRoom(currentRoom);
    }
}
