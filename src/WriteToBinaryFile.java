import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToBinaryFile {

    public static void main(String[] args) {
        // Создаем массив, представляющий состояние игрового поля 3x3
        int[] gameBoard = {1, 0, 2, 3, 1, 2, 0, 3, 2};

        try (FileOutputStream fos = new FileOutputStream("game_board.bin")) {
            // Упаковываем данные и записываем их в бинарный файл
            int packedData = packGameBoard(gameBoard);
            fos.write(packedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int packGameBoard(int[] gameBoard) {
        // Инициализируем переменную для упакованных данных
        int packedData = 0;

        // Проходим по каждому элементу игрового поля
        for (int i = 0; i < gameBoard.length; i++) {
            // Ограничиваем значение до 2 бит
            int value = gameBoard[i] & 0b11;
            // Упаковываем значение, сдвигая его влево на i*2 бит
            packedData |= value << (i * 2);
        }

        // Возвращаем упакованные данные
        return packedData;
    }
}
