public class Main {


    public static void main(String[] args) {


        int lengthArr = 10;
        User[] usersArr = new User[lengthArr];
        User user = null;
        createUsers(usersArr);
        UserDAO.readAll(usersArr);
        do {
            user = MenuProgram.authorizationUser(usersArr);
        } while (user == null);

        if (user.getLogin().equals("admin") && user.getPass().equals("admin")) {
            user.getRoles().right = "ADMIN";
        } else {
            MenuProgram.menuUser(usersArr, user);
        }
        UserDAO.readAll(usersArr);


//        Authorization authorization = new Authorization();
//        User tmpUser;
//        User tmpUserWrong;
//
//        tmpUser = authorization.authorization(usersArr, "user1", "pass1");
//        tmpUserWrong = authorization.authorization(usersArr, "user10", "pass10");
//        System.out.println(tmpUser);
//        System.out.println(tmpUserWrong);
//        printUsers(usersArr);
    }

    private static void createUsers(User[] usersArr) {
        for (int i = 0; i < usersArr.length; i++) {
            usersArr[i] = new User("user" + i, "pass" + i);
        }
    }
}