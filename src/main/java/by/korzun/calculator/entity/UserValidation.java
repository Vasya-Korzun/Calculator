package by.korzun.calculator.entity;

import by.korzun.calculator.exceptions.InvalidNameException;
import by.korzun.calculator.exceptions.InvalidPasswordException;
import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

public class UserValidation {
    public static String checkName(String name) throws InvalidNameException {
        Pattern p = Pattern.compile("(^[a-zA-Z\\d]{3,100}$)");
        if (Strings.isNotEmpty(name) && p.matcher(name).matches()) {
            return name;
        } else {
            throw new InvalidNameException("User name Bob!");
        }
    }

    public static String checkPassword(String password) throws InvalidPasswordException {
        return password;
    }
}
