import Characters.NPC;
import Items.Item;
import Locations.Room;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as items, characters, locations, and quests.
 *
 */
public class GameData {

    public ArrayList<Item> items;
    public ArrayList<NPC> characters;
    public ArrayList<Room> rooms;
    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = Main.class.getResourceAsStream(resourcePath)) {

            //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Resource not found: " + resourcePath +
                        " (Check if file exists in src/main/resources).");
            }

            //Přečte celý JSON a vytvoří instanci GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }

    /**
     * Finds a specific location by its identifier.
     * @param id the identifier of the location to be found
     * @return the matching location
     */
    public  Room findLocation(String id) {
        for (Room r : rooms) {
            if (r.getId().equals(id)){
                return r;
            }
        }
        throw new IllegalArgumentException("Room with the following id does not exist: " + id);
    }
    public void RoomConnection(){
        for (Room room : rooms){
            for (Room room2 : rooms) {
                if (room.getNeighborIds().equals(room2.getId())){
                    room.getNeighbors().add(room2);
                }
            }
        }
    }
}
