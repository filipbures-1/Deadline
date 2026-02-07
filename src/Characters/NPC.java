package Characters;
public class NPC {
    private String id;
    private String name;
    private String homeRoomId;
    private String description;

    public NPC(String id, String name, String homeRoomId, String description) {
        this.id = id;
        this.name = name;
        this.homeRoomId = homeRoomId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeRoomId() {
        return homeRoomId;
    }

}
