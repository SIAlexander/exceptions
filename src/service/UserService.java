package service;

import exceptions.NotMathTheFormatException;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class UserService {

    public static void setLoginAndPassword(String login, String password, String confirmPassword) {
        try {
            isValidLoginAndPassword(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException | NotMathTheFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void isValidLoginAndPassword(String login, String password, String confirmPassword)
            throws Exception {
        if (checkThePasswordAndLoginFormat(login) && checkThePasswordAndLoginFormat(password)) {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            if (password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
        } else {
            throw new NotMathTheFormatException("Логин и пароль может содержать символы: (a-z, A-Z, 0-9, _)");
        }

    }

    private static boolean checkThePasswordAndLoginFormat(String string) {
        return string.matches("[a-zA-Z0-9]\\w+");
    }
}
