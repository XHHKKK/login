import java.util.Scanner;
import java.io.BufferedWriter;////BufferedWriter буферезирует символы
import java.io.FileWriter;//производный от класса Writer
import java.io.IOException;//исключение, представляет ошибку ввода/вывода

// Интерфейс для логирования
interface Logger {
    void log(String message);
}

// Класс, реализующий логирование в файл
class FileLogger implements Logger {
    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {//BufferedWriter буферезирует символы
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());//возвращает сообщение, которое при создании исключения
        }
    }
}

// Класс User для представления пользователя
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Класс Authentication для управления аутентификацией
class Authentication {
    private User user;

    public Authentication(User user) {
        this.user = user;
    }

    public boolean login(String username, String password) {
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}
