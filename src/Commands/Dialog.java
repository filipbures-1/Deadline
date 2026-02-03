package Commands;
import Characters.NPC;
import Characters.Player;
import Main.GameData;
import Items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Dialog implements Commands {
    private Player player;
    private GameData world;
    private Scanner scanner = new Scanner(System.in);

    public Dialog(Player player, GameData world) {
        this.player = player;
        this.world = world;
    }

    @Override
    public String execute(String commands) {
        String[] parts = commands.split(" ", 2);
        String NpcToTalkToName = null;
        NpcToTalkToName = parts[1];

        ArrayList<NPC> npcs = player.getCurrentRoom().getNpcsInRoom();
        if (npcs.isEmpty()) {
            return "Theres nobody here to talk to.";
        }

        NPC NpcToTalkTo = null;
            for (NPC npc : npcs) {
                if (npc.getName() != null && npc.getName().equalsIgnoreCase(NpcToTalkToName)) {
                    NpcToTalkTo = npc;
                    break;
                }
            }
            if (NpcToTalkTo == null) {
                return NpcToTalkToName + " is not here.";
            }


        switch (NpcToTalkTo.getId()) {
            case "npc_nerdandrew":
                return dialogueAndrew(NpcToTalkTo);
            case "npc_friendjacob":
                return dialogueJacob(NpcToTalkTo);
            case "npc_bullytheodore":
                return dialogueTheodore(NpcToTalkTo);
            case "npc_principal":
                return dialoguePrincipal(NpcToTalkTo);
            default:
                return "You dont want to talk to this person.";
        }
    }

    private String dialogueAndrew(NPC andrew) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println(andrew.getName() + ": What do you want?");
            System.out.println("1) I dont know what homework to do. Can you help me?");
            System.out.println("2) I was just wondering, how are you?");
            System.out.println("3) Leave");
            System.out.print(">>> ");
            String response = scanner.nextLine();
            switch (response) {
                case "1":
                    for (Item item : world.items) {
                        if ("item_homeworklist".equalsIgnoreCase(item.getId())) {
                            item.setPickable(true);
                            break;
                        }
                    }
                    return "Andrew: Ugh, fine, here is the list of homework you need to do." +
                            "\nYou can now pick up the homework list.";
                case "2":
                    return "You never ask me how I am, get out of my face.";
                case "3":
                    return "You left " + andrew.getName() + ".";
                default:
                    System.out.println("This choice doesnt exist.");
            }
        }
    }

    private String dialogueJacob(NPC jacob) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println(jacob.getName() + ": Hi friend! What do you need?");
            System.out.println("1) Can you let me take a picture of your homework?");
            System.out.println("2) What are you reading?");
            System.out.println("3) Leave");
            System.out.print(">>> ");
            String response = scanner.nextLine();
            switch (response) {
                case "1":
                    for (Item item : world.items) {
                        if ("item_homeworkphoto".equalsIgnoreCase(item.getId())) {
                            item.setPickable(true);
                            break;
                        }
                    }
                    return "Jacob: Yeah, sure, here you go. This isnt everything though. Theres a cheatsheet that helped me a lot. Theodore has it right now, hes in the Caffeteria." +
                            "\nYou can now pick up the homework photo.";
                case "2":
                    return "Jacob: Oh, just some sci-fi novel. Its pretty interesting!";
                case "3":
                    return "You left " + jacob.getName() + ".";
                default:
                    System.out.println("This choice doesnt exist.");
            }
        }
    }
    private String dialogueTheodore(NPC theodore) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println(theodore.getName() + ": What do you want small fry?");
            System.out.println("1) I was wondering if we could make a deal. I need that cheatsheet you have.");
            System.out.println("2) Give me the cheatsheet or else!");
            System.out.println("3) Leave");
            System.out.print(">>> ");
            String response = scanner.nextLine().trim();
            switch (response) {
                case "1":
                    return "Theodore: Alright, bring me my classmates drawing compass from our classroom and we have a deal.";
                case "2":
                    return "Theodore: Scram loser, before I make you regret it!";
                case "3":
                    return "You left " + theodore.getName() + ".";
                default:
                    System.out.println("This choice doesnt exist.");
            }
        }
    }
    private String dialoguePrincipal(NPC principal) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println(principal.getName() + ": What do you need, student?");
            System.out.println("1) Im here to hand over my homework.");
            System.out.println("2) I was wondering if i have to go to school on weekends?");
            System.out.println("3) Leave");
            System.out.print(">>> ");
            String response = scanner.nextLine().trim();
            switch (response) {
                case "1":
                    return "Principal: Alright, hand it over. But be a little faster next time!";
                case "2":
                    return "Principal: Are you drunk or something? Of course you dont have to go to school on weekends!";
                case "3":
                    return "You left " + principal.getName() + ".";
                default:
                    System.out.println("This choice doesnt exist.");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
