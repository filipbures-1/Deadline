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

    public Item(String name, String description, boolean isPickable) {
        this.name = name;
        this.description = description;
        this.isPickable = isPickable;
    }
}
