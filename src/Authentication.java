import java.util.regex.Pattern;

public class Authentication {
    private static final Pattern REGEX = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void verificationAuthentication(String login, String password, String confirmedPassword) throws WrongLoginException, WrongPassException {
        verificationLogin(login);
        verificationPassword(password);
        verificationConfirmedPassword(password, confirmedPassword);
    }

    public static void verificationLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин должен быть меньше 20 символов");
        }
        if (!login.matches(REGEX.pattern())) {
            throw new WrongLoginException("Разрешены только латинские символы, цифры и нижнее подчеркивание");

        }
    }

    public static void verificationPassword(String password) throws WrongPassException {
        if (!password.matches(REGEX.pattern())) {
            throw new WrongPassException("пароль должен только латинские символы, цифры и нижнее подчеркивание и" +
                    "содержать меньше 20 символов");
        }
    }

    public static void verificationConfirmedPassword(String password, String confirmedPassword) throws WrongPassException {
        if (!password.equals(confirmedPassword)) {
            throw new WrongPassException("Пароли не совпдаают");
        }
    }
}
