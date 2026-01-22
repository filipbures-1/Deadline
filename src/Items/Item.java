package Items;

public class Item {
    private String name;
    private String description;
    private String id;
    private boolean isPickable;
    private boolean isDropable;

    public String ShowItemDescription(){
        return null;
    }

    public Item(String name, String description, String id, boolean isPickable, boolean isDropable) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.isPickable = isPickable;
        this.isDropable = isDropable;
    }
}
