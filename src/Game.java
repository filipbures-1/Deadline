import Characters.Player;
import Commands.Commands;

import java.util.HashMap;

public class Game {
    private GameData world;
    private Player player;
    private HashMap<String, Commands> commands;

    public void inicialization(){
        commands = new HashMap<>();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        System.out.println(world.characters.size());
        System.out.println(world.items.size());
        System.out.println(world.rooms.size());
        //TODO pridat commands
        //commands.put("pohyb", new Movementplayer));

    }

    public void start(){
        inicialization();
        //zde bude herni smycka
    }
}
