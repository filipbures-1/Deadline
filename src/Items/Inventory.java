package Items;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int Capacity;

    public ArrayList<Item> getItemsFromInventory(){
        return items;
    }
    public int getCapacity() {
        return Capacity;
    }
    public Inventory() {
        this.items = new ArrayList<>();
        Capacity = 5;
    }

    /**
     * Adds an item to the inventory if there is capacity.
     * @param item the item to add.
     * @return true if added successfully, false otherwise.
     */
    public boolean AddItem(Item item){
        if(item == null){
            return false;
        }
        if(items.size() >= Capacity){
            return false;
        }
        items.add(item);
        return true;
    }
    /**
     * Removes an item from the inventory.
     * @param item the item to remove.
     * @return true if removed successfully, false otherwise.
     */
    public boolean RemoveItem(Item item){
        if(item == null){
            return false;
        }
        return items.remove(item);
    }
}
