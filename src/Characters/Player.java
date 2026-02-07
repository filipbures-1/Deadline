package Characters;
import Items.Inventory;
import Items.Item;
import Locations.Room;
import Main.GameData;
import java.util.ArrayList;

public class Player {
    private String name;
    private String description;
    private Inventory inventory;
    private Room CurrentRoom;
    private Item CurrentItem;
    private GameData world;

    public Item PickUpItem(Item item){
        if (item == null){
            return null;
        }
        if (!item.isPickable()) {
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
        return null;
    }

    public Room getCurrentRoom() {
        return CurrentRoom;
    }
    public Inventory getInventory(){
        return inventory;
    }

    public GameData getWorld(){
        return world;
    }
    public void GetItemInfoFromRoom(){
        ArrayList<String> itemsInRoom = CurrentRoom.getItemsInRoom();
        if (itemsInRoom == null || itemsInRoom.isEmpty()) {
            System.out.println("Items in the room: none");
        } else {
            StringBuilder StringItems = new StringBuilder("Items in the room: ");
            for (String id : itemsInRoom) {
                String ItemDisplayName = id;
                for (Item item : world.items) {
                    if (item.getId().equals(id)) {
                        ItemDisplayName = item.getName();
                        break;
                    }
                }
                StringItems.append(ItemDisplayName).append(", ");
            }
            System.out.println(StringItems.toString());
        }
    }
    public void GetNpcInfoFromRoom(){
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
    public void GetNeighbourInfoFromRoom(){
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
    }

    public void setCurrentRoom(Room currentRoom) {
        CurrentRoom = currentRoom;
        System.out.println("You are in: " + CurrentRoom.getName());
        GetNeighbourInfoFromRoom();
        GetNpcInfoFromRoom();
        GetItemInfoFromRoom();
    }

    public Player(String name, String description, Inventory inventory, Room currentRoom, Item currentItem, GameData world) {
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        CurrentRoom = currentRoom;
        CurrentItem = currentItem;
        this.world = world;

        for (Item item : world.items){
            if (item.getId().equals("item_phone")){
                inventory.AddItem(item);
                break;
            }
        }
        setCurrentRoom(currentRoom);
    }
}
