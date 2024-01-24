import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {

    public static void main(String[] args) {
        String sourceDirectory = "/directory";
        createBackup(sourceDirectory);
    }

    public static void createBackup(String sourceDirectory) {
        // Путь к новой папке для резервной копии
        String backupDirectory = "./backup";

        // Создаем объект File для исходной директории
        File sourceDir = new File(sourceDirectory);

        // Проверяем, существует ли исходная директория
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Указанная директория не существует или не является директорией.");
            return;
        }

        // Создаем новую папку для резервной копии, если ее еще нет
        File backupDir = new File(backupDirectory);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Получаем список файлов в исходной директории
        File[] files = sourceDir.listFiles();

        // Копируем каждый файл в новую папку
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Files.copy(file.toPath(), new File(backupDir, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Создана резервная копия файла: " + file.getName());
                    } catch (IOException e) {
                        System.out.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
        } else {
            System.out.println("Не удалось получить список файлов в директории.");
        }
    }
}
