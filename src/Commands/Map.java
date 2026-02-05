package Commands;

import Characters.Player;
import com.google.gson.internal.bind.util.ISO8601Utils;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Map implements Commands{
    private Player player;
    public Map(Player player){
        this.player = player;
    }

    @Override
    public String execute(String commands) {
        String text = "";
        try { BufferedReader mapreader = new BufferedReader(new FileReader("Resources/map"));
            String line;
            while ((line = mapreader.readLine()) != null) {
                text += line + "\n";
            }
        } catch (IIOException e){
            System.out.println("Unable to load map");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
