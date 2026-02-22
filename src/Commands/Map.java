package Commands;
import Characters.Player;
import javax.imageio.IIOException;
import java.io.*;

public class Map implements Commands{
    private Player player;
    public Map(Player player){
        this.player = player;
    }

    /**
     * Executes the map command, reading the map file.
     * @param commands command in the format "map".
     * @return map file.
     */
    @Override
    public String execute(String commands) {
        String helpLine = "";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("map");
        if (inputStream == null) {
            return "Unable to load map file.";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                helpLine += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return helpLine;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
