package Commands;

import Characters.Player;
import Items.Item;

import java.util.Scanner;

public class Fight implements Commands {
    private Player player;
    private Scanner scanner = new Scanner(System.in);
    private boolean Exit = false;

    public Fight(Player player) {
        this.player = player;
    }

    @Override
    public String execute(String commands) {
        Exit = false;

        if (!"loc_adamshouse".equals(player.getCurrentRoom().getId())) {
            return "You can only do homework in Adams house.";
        }

        if (!hasRequiredItems()) {
            return "You need the cheatsheet, homework list, and homework photo to start doing your homework.";
        }

        if (hasEnergyDrink()) {
            System.out.println("------------------------------------------------");
            System.out.println("You have an Energy Drink in your inventory. Would you like to drink it to skip the homework fight?");
            System.out.println("------------------------------------------------");
            System.out.println("1) No");
            System.out.println("2) Yes");

            String energyChoice = scanner.nextLine().trim();

            switch (energyChoice) {
                case "1":
                    return startFight();
                case "2":
                    return "You can now use the energy drink.";
                default:
                    return "This choice doesnt exist.";
            }
        } else {
            return startFight();
        }
    }

    private boolean hasRequiredItems() {
        boolean hasCheatsheet = false;
        boolean hasHomeworkList = false;
        boolean hasHomeworkPhoto = false;

        for (Item item : player.getInventory().getItemsFromInventory()) {
            if ("item_cheatsheet".equals(item.getId())) {
                hasCheatsheet = true;
            } else if ("item_homeworklist".equals(item.getId())) {
                hasHomeworkList = true;
            } else if ("item_homeworkphoto".equals(item.getId())) {
                hasHomeworkPhoto = true;
            }
        }

        return hasCheatsheet && hasHomeworkList && hasHomeworkPhoto;
    }

    private boolean hasEnergyDrink() {
        for (Item item : player.getInventory().getItemsFromInventory()) {
            if ("item_energydrink".equals(item.getId())) {
                return true;
            }
        }
        return false;
    }

    private void removeEnergyDrink() {
        for (Item item : player.getInventory().getItemsFromInventory()) {
            if ("item_energydrink".equals(item.getId())) {
                player.getInventory().RemoveItem(item);
                break;
            }
        }
    }

    private void setCompletedHomeworkPickable() {
        for (Item item : player.getWorld().items) {
            if ("item_completedhomework".equals(item.getId())) {
                item.setPickable(true);
                break;
            }
        }
    }

    private String startFight() {
        System.out.println("------------------------------------------------");
        System.out.println("You ran into a few issues while doing your homework! What do you do?");

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("You started scrolling Instagram reels, what do you do?");
            System.out.println("1) Uninstall Instagram.");
            System.out.println("2) Scroll tiktok instead.");
            System.out.println("3) Scroll for a bit, you deserves a break.");
            System.out.print(">>> ");
            String response = scanner.nextLine().trim();
            switch (response) {
                case "1":
                    System.out.println("You started working on your homework again!");
                    break;
                case "2":
                    Exit = true;
                    return "Why would you do that? You didnt finish the homework in time!";
                case "3":
                    Exit = true;
                    return "Those '5 more minutes' turned into a few hours. You didnt finish the homework in time!";
                default:
                    System.out.println("This choice doesn't exist.");
                    continue;
            }
            break;
        }

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("Youre is getting tired. What do you do?");
            System.out.println("1) Get a quick nap.");
            System.out.println("2) Work anyway, you can sleep at night.");
            System.out.println("3) Give up on the homework.");
            System.out.print(">>> ");
            String response = scanner.nextLine().trim();
            switch (response) {
                case "1":
                    Exit = true;
                    return "You woke up at 8 AM the next day. Self explanatory.";
                case "2":
                    System.out.println("You pushed through the tiredness and continued working!");
                    break;
                case "3":
                    Exit = true;
                    return "You obviously didnt finish the homework in time!";
                default:
                    System.out.println("This choice doesn't exist.");
                    continue;
            }
            break;
        }

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("Youre getting really frustrated. What do you do?");
            System.out.println("1) Take a few deep breaths and relax.");
            System.out.println("2) Close your eyes and calm down.");
            System.out.println("3) Go for a quick walk.");
            System.out.print(">>> ");
            String response = scanner.nextLine().trim();
            switch (response) {
                case "1":
                    Exit = true;
                    return "You got even more frustrated so you threw your homework out the window. You didnt finish it in time!";
                case "2":
                    Exit = true;
                    return "You closed your eyes and fell asleep. You didnt finish the homework in time!";
                case "3":
                    System.out.println("Correct choice!");
                    setCompletedHomeworkPickable();
                    break;
                default:
                    return "This choice doesn't exist.";
            }
            break;
        }

        return "Congratulations! You have successfully completed your homework!" +
                "\nYou can now pick up the Completed homework.";
    }

    @Override
    public boolean exit() {
        return Exit;
    }
}
