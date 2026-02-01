
package Commands;

public class Dialog implements Commands {
    @Override
    public String execute(String commands) {
        return "I might need a little assistance with this command.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
