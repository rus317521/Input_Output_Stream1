import java.net.SocketOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sumProducts = 0;
        Scanner scanner = new Scanner(System.in);
        String[] products = {
                "Молоко 1л", "Хлеб", "Сыр 200 гр", "Яйца 10 шт", "Гречка 1 кг", "Мука 1 кг", "Макароны 800 гр", "Курица 1кг", "Картошка 1 кг", "Яблоки 1 кг"
        };
        int[] prices = {60, 50, 150, 80, 90, 120, 100, 200, 45, 130};
        int[] productsCount = new int[10];
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + "  " + products[i] + "  " + prices[i] + " руб/шт");
        }
        ;
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                if (sumProducts > 0) {
                    System.out.println("Ваша корзина:");
                    for (int j = 0; j < products.length; j++) {
                        if (productsCount[j] > 0) {
                            System.out.println(products[j] + " " + productsCount[j] + " шт " + prices[j] + " руб/шт " + prices[j] * productsCount[j] + " руб. в сумме");
                        }
                        ;
                    }
                    ;
                    System.out.println("Итого: " + sumProducts + " руб");
                }
                ;
                break;
            }
            ;
            String[] parts = input.split(" ");
            int number = Integer.parseInt(parts[0]) - 1;
            int count = Integer.parseInt(parts[1]);
            productsCount[number] = productsCount[number] + count;
            sumProducts = sumProducts + prices[number] * count;
        }
    }
}
