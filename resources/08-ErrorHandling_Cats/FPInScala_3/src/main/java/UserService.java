package org.fpinscala;

import java.util.Collection;

public class UserService {
    public static UserData findUser(String name) {
        Collection<UserData> database = UserData$.MODULE$.databaseAsJava();
        for (UserData user: database) {
            if (user.name().equals(name)) return user;
        }
        throw new IllegalArgumentException("No user with name " + name);
    }

    public static UserData findUserNullable(String name) {
        Collection<UserData> database = UserData$.MODULE$.databaseAsJava();
        for (UserData user: database) {
            if (user.name().equals(name)) return user;
        }
        return null;
    }
    
    public static UserData findUserOrDefault(String name, UserData defaultUser) {
        Collection<UserData> database = UserData$.MODULE$.databaseAsJava();
        for (UserData user: database) {
            if (user.name().equals(name)) return user;
        }
        return defaultUser;
    }
}
