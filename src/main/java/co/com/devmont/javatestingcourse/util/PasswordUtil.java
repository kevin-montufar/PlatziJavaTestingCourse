package co.com.devmont.javatestingcourse.util;

import static co.com.devmont.javatestingcourse.util.SecurityLevel.*;

public class PasswordUtil {
    public static SecurityLevel assessPassword(String password){
        if (password.length() < 8 || password.matches("[a-zA-Z]+"))
            return WEAK;

        if (password.matches("[a-zA-Z0-9]+"))
            return MEDIUM;

        return STRONG;
    }
}
