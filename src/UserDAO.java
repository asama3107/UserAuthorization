public class  UserDAO {

    public static User[] create(User[] usersArr, User user) {

        for (int i = 0; i < usersArr.length; i++) {
            if (usersArr[i] == null) {
                usersArr[i] = user;
                break;
            }
        }
        return usersArr;
    }

    public static User read(User[] usersArr, String login) {

        for (int i = 0; i < usersArr.length; i++) {
            if (usersArr[i] != null && usersArr[i].getLogin().equals(login)) return usersArr[i];
        }
        return null;
    }

    public static int read(User[] usersArr, int id) {

        for (int i = 0; i < usersArr.length; i++) {
            if (usersArr[i] != null && usersArr[i].getId() == id) return i;
        }
        return -1;
    }

    public static User[] update(User[] usersArr, User user) {

        int index = read(usersArr, user.getId());
        if (index != -1) {
            usersArr[index] = user;
        }
        return usersArr;
    }

    public static User [] delete(User[] usersArr, int id){
        int index = read(usersArr, id);
        if (index != -1){
            usersArr[index] = null;
        }
        return usersArr;
    }

    public static void readAll(User[] usersArr) {
        for (User user : usersArr) {
            LoggerUser.d(User.class.getName(), user.toString());
        }
    }
}