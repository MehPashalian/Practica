import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class task9 {

    private static final int FIELD_SIZE = 5; // Размер поля (5x5 клеток)
    private static final int CARD_COUNT = 52; // Количество карточек
    private static final int MAX_NUMBER = 13; // Максимальное число на карточке

    private int[][] field; // Двумерный массив для представления поля
    private List<Integer> cards; // Список карточек (чисел)
    private int playerScore; // Очки игрока
    private int computerScore; // Очки компьютера

    public Matematico() {
        field = new int[FIELD_SIZE][FIELD_SIZE]; // Инициализация поля
        cards = new ArrayList<>(); // Инициализация списка карточек
        for (int i = 0; i < CARD_COUNT; i++) { // Заполняем список карточек
            cards.add(i % MAX_NUMBER + 1); // Добавляем числа от 1 до 13 по 4 раза
        }
        playerScore = 0;
        computerScore = 0;
    }

    // Метод для имитации извлечения карты
    public int drawCard() {
        Random random = new Random();
        int cardIndex = random.nextInt(cards.size());
        int cardValue = cards.get(cardIndex);
        cards.remove(cardIndex);
        return cardValue;
    }

    // Метод для размещения числа на поле
    public void placeNumber(int row, int col, int number) {
        if (row >= 0 && row < FIELD_SIZE && col >= 0 && col < FIELD_SIZE && field[row][col] == 0) {
            field[row][col] = number;
        } else {
            System.out.println("Некорректные координаты или клетка уже занята.");
        }
    }

    // Метод для оценки заполненного поля
    private int calculateScore(int[][] field) {
        int score = 0;
        // Проверка строк
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][0] != 0 && field[i][1] != 0 && field[i][2] != 0 && field[i][3] != 0 && field[i][4] != 0) {
                score += field[i][0] * field[i][1] * field[i][2] * field[i][3] * field[i][4];
            }
        }
        // Проверка столбцов
        for (int j = 0; j < FIELD_SIZE; j++) {
            if (field[0][j] != 0 && field[1][j] != 0 && field[2][j] != 0 && field[3][j] != 0 && field[4][j] != 0) {
                score += field[0][j] * field[1][j] * field[2][j] * field[3][j] * field[4][j];
            }
        }
        // Проверка диагоналей
        if (field[0][0] != 0 && field[1][1] != 0 && field[2][2] != 0 && field[3][3] != 0 && field[4][4] != 0) {
            score += field[0][0] * field[1][1] * field[2][2] * field[3][3] * field[4][4];
        }
        if (field[0][4] != 0 && field[1][3] != 0 && field[2][2] != 0 && field[3][1] != 0 && field[4][0] != 0) {
            score += field[0][4] * field[1][3] * field[2][2] * field[3][1] * field[4][0];
        }
        return score;
    }

    // Метод для вывода поля
    public void printField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для хода игрока
    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        int number = drawCard();
        System.out.println("Выпало число: " + number);
        System.out.println("Введите координаты клетки (ряд, столбец) (0-4):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        placeNumber(row, col, number);
    }

    // Метод для хода компьютера
    public void computerTurn() {
        int number = drawCard();
        System.out.println("Компьютер вытянул число: " + number);
        // Простая стратегия для компьютера: размещает число в первую свободную клетку
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == 0) {
                    placeNumber(i, j, number);
                    return;
                }
            }
        }
    }

    // Метод для запуска игры
    public void playGame() {
        while (cards.size() > 0) {
            playerTurn();
            printField();
            computerTurn();
            printField();
        }
        // Оценка результата
        playerScore = calculateScore(field);
        // Компьютер автоматически заполняет оставшиеся клетки
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = drawCard();
                }
            }
        }
        computerScore = calculateScore(field);
        System.out.println("Игрок: " + playerScore + " очков.");
        System.out.println("Компьютер: " + computerScore + " очков.");
        if (playerScore > computerScore) {
            System.out.println("Поздравляем, вы выиграли!");
        } else if (playerScore < computerScore) {
            System.out.println("К сожалению, вы проиграли.");
        } else {
            System.out.println("Ничья!");
        }
    }

    public static void main(String[] args) {
        task9 game = new task9();
        System.out.println("Добро пожаловать в Математико!");
        game.playGame();
    }
}
