package Main;
import Characters.NPC;
import Items.Item;
import Locations.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {
    private GameData gameData;

    @BeforeEach
    void setUp() {
        gameData = new GameData();
        gameData.rooms = new ArrayList<>();
        gameData.characters = new ArrayList<>();
        gameData.items = new ArrayList<>();
    }

    @Test
    void roomConnection() {
        Room room1 = new Room("Room 1 desc", "Room 1", "room1");
        Room room2 = new Room("Room 2 desc", "Room 2", "room2");
        room1.getNeighborIds().add("room2");

        gameData.rooms.add(room1);
        gameData.rooms.add(room2);

        gameData.RoomConnection();

        assertEquals(1, room1.getNeighbors().size());
        assertTrue(room1.getNeighbors().contains(room2));
    }

    @Test
    void NPCConnection() {
        Room room1 = new Room("Room 1 desc", "Room 1", "room1");
        NPC npc1 = new NPC("npc1", "Andrew", "room1", "NPC desc");

        gameData.rooms.add(room1);
        gameData.characters.add(npc1);

        gameData.NPCConnection();

        assertEquals(1, room1.getNpcsInRoom().size());
        assertTrue(room1.getNpcsInRoom().contains(npc1));
    }

    @Test
    void itemConnection() {
        Room room1 = new Room("Room 1 desc", "Room 1", "room1");
        Item item1 = new Item("Item One", "Item desc", "item1", true, true, "room1");

        gameData.rooms.add(room1);
        gameData.items.add(item1);

        gameData.ItemConnection();

        assertEquals(1, room1.getItemsInRoom().size());
        assertTrue(room1.getItemsInRoom().contains("item1"));
    }
}