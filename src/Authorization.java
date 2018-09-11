public  class Authorization {



    public static User authorization(User[] usersArr, String login, String pass) {
        User user = null;
        for (User user1 : usersArr) {
            if (user1 != null && user1.getLogin().equals(login)  && user1.getPass().equals(pass)) {
                user = user1;
            }
        }
        return user;
    }
}
