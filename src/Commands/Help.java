package Commands;

public class Help implements Commands{
    @Override
    public String execute(String commands) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
