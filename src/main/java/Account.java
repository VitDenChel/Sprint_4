public class Account {
    private final String name;
    int counter = 0;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name.length() >= 3 && name.length() <= 19) {
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == ' ') {
                    counter++;
                }
            }
        }
        if (counter == 1 && (!name.startsWith(" ") && !name.endsWith(" "))) {
            return true;
        }
        return false;
    }
}











        /*

             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */



