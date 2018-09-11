import java.util.Scanner;

public class MenuProgram {

    private static String menuAdmin =
            "r - read \n" +
                    "d - delete \n" +
                    "exit - for finish program";

    private static String menuUser = "Change fields \n" +
            "n - name \n" +
            "l - login.";

    private static String newNameCommand = "Enter new Name: ";
    private static String newLoginCommand = "Enter new Login: ";
    private static String ok = "OK";
    private static String wrongOperation = "Wrong operation";


    public static User authorizationUser(User[] usersArr) {
        User user = null;
        String login;
        String pass;

        LoggerUser.i("", "Enter Data for Authorization");
        LoggerUser.i("", "Enter Login:");
        login = readConsoleValue();
        LoggerUser.i("", "Enter Password:");
        pass = readConsoleValue();
        user = Authorization.authorization(usersArr, login, pass);
        if (user == null) LoggerUser.w("", "WRONG Login or Pass ");
        return user;
    }

    public static User[] menuUser(User[] usersArr, User user) {
        class Local {
        }
        ;
        String nameMethod = Local.class.getEnclosingMethod().getName();
        String command;
        String value = null;

        LoggerUser.i(nameMethod, menuUser);
        command = readConsoleValue();
        if (command.equals("n")) {
            LoggerUser.i(nameMethod, newNameCommand);
            value = readConsoleValue();
            user.setName(value);
            LoggerUser.d(nameMethod, ok);
        } else if (command.equals("l")) {
            LoggerUser.i(nameMethod, newLoginCommand);
            value = readConsoleValue();
            user.setLogin(value);
            LoggerUser.d(nameMethod, ok);
        } else {
            LoggerUser.w(nameMethod, wrongOperation);
        }
        return usersArr;
    }

    public User[] menuAdmin(User[] usersArr) {

        LoggerUser.i(this.getClass().getName(), menuAdmin);
        String command = null;
        command = readConsoleValue();

        if (command.equals("r")) {
            UserDAO.readAll(usersArr);
        } else if (command.equals("d")) {
            int id;
            User user = null;
            LoggerUser.i("Delete", "Enter id for delete User");
            id = Integer.parseInt(readConsoleValue());
            UserDAO.delete(usersArr, id);

        } else if (command.equals("exit")) {

        } else {

        }


        return usersArr;
    }

    protected static String readConsoleValue() {
        String value;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        return value;
    }

}
