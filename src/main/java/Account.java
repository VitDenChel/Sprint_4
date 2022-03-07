public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        int spaces = name.length() - name.replace(" ", "").length();
        if (name.length() >= 3 && name.length() <= 19 && (!name.startsWith(" ")) && (!name.endsWith(" ")) && (name.indexOf(' ') != -1) && (spaces == 1 )) {
            return true;
        }
        return false;
    }
}









