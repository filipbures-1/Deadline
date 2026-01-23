package Commands;

public class Exit implements Commands{
    @Override
    public String execute(String commands) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
