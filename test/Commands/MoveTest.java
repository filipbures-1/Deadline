package Commands;
import Characters.Player;
import Items.Inventory;
import Locations.Room;
import Main.GameData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    private Player player;
    private Move move;
    private Room room1, room2;

    @BeforeEach
    void setUp() {
        GameData gameData = new GameData();
        gameData.rooms = new ArrayList<>();
        gameData.items = new ArrayList<>();
        gameData.characters = new ArrayList<>();

        room1 = new Room("Room 1 desc", "Room 1", "room1");
        room2 = new Room("Room 2 desc", "Room 2", "room2");

        room1.AddNeighbors(room2);
        room2.AddNeighbors(room1);

        gameData.rooms.add(room1);
        gameData.rooms.add(room2);

        player = new Player("Adam", "Test player", new Inventory(), room1, null, gameData);
        move = new Move(player);
    }

    @Test
    void execute() {
        move.execute("move Room 2");
        assertEquals(room2, player.getCurrentRoom());
    }
}