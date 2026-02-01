package Items;

public class Item {
    private String name;
    private String description;
    private String id;
    private boolean isPickable;
    private boolean isDropable;
    private String PlacedRoomId;


    public String ShowItemDescription(){
        return null;
    }
    public Item(){

    }

    public Item(String name, String description, String id, boolean isPickable, boolean isDropable) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.isPickable = isPickable;
        this.isDropable = isDropable;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPickable() {
        return isPickable;
    }

    public void setPickable(boolean pickable) {
        isPickable = pickable;
    }

    public boolean isDropable() {
        return isDropable;
    }

    public String getPlacedRoomId() {
        return PlacedRoomId;
    }
}
