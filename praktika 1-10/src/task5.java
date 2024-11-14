import java.util.Scanner;
public class task5 {

    public class TelegramReceipt {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Запрашиваем стоимость одного слова
            System.out.print("Введите стоимость одного слова (в рублях): ");
            double costPerWord = scanner.nextDouble();

            // Запрашиваем количество слов
            System.out.print("Введите количество слов в телеграмме: ");
            int numberOfWords = scanner.nextInt();

            // Рассчитываем общую стоимость
            double totalCost = costPerWord * numberOfWords;

            // Выводим квитанцию
            System.out.println("\n--- Квитанция об оплате телеграммы ---");
            System.out.println("Стоимость одного слова: " + costPerWord + " руб.");
            System.out.println("Количество слов: " + numberOfWords);
            System.out.println("Итого к оплате: " + totalCost + " руб.");
            System.out.println("-------------------------------------");

            // Закрываем сканер
            scanner.close();
        }
    }

}
