package by.korzun.calculator.entity;

import by.korzun.calculator.exceptions.InvalidNameException;
import by.korzun.calculator.exceptions.InvalidPasswordException;

public class User {
    private String username;
    private String password;

    public User(String username, String password) throws InvalidPasswordException, InvalidNameException {

        this.username = UserValidation.checkName(username);
        this.password = UserValidation.checkPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
