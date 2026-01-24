package Characters;

import Items.Inventory;
import Items.Item;
import Locations.Room;

public class Player {
    private String name;
    private String description;
    private Inventory inventory;
    private Room CurrentRoom;
    private Item CurrentItem;

    public Item PickUpItem(Item item){
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
    }

    public Player(String name, String description, Inventory inventory, Room currentRoom, Item currentItem) {
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        CurrentRoom = currentRoom;
        CurrentItem = currentItem;
    }
}
