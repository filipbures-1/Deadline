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
        System.out.println(world.characters);
        System.out.println(world.items);
        System.out.println(world.rooms);
        //TODO pridat commands
        //commands.put("pohyb", new Movementplayer));
    }

    public void start(){
        inicialization();
        world.RoomConnection();
        //zde bude herni smycka
    }
}
