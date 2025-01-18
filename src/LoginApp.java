import java.util.Scanner;

// Главный класс приложения
public class LoginApp {
    private static final String LOG_FILENAME = "user_log.txt";

    public static void main(String[] args) {
        User user = new User("хаф хаф", "хафхаф123");
        Authentication auth = new Authentication(user);
        Logger logger = new FileLogger(LOG_FILENAME);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();

        if (auth.login(inputUsername, inputPassword)) {
            System.out.println("Вход выполнен успешно!");
            logUserInfo(user, logger);
        } else {
            System.out.println("Неверный логин или пароль.");
        }

        scanner.close();
    }

    private static void logUserInfo(User user, Logger logger) {
        String logMessage = "Вход пользователя: " + user.getUsername();
        logger.log(logMessage);
        System.out.println("Информация о пользователе записана в файл " + LOG_FILENAME + ".");
    }
}
