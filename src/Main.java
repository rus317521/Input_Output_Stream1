import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Список возможных продуктов
        String[] products = {
                "Молоко", "Хлеб", "Сыр", "Яйца", "Гречка", "Мука", "Макароны", "Курица", "Картошка", "Яблоки"
        };
        //Список цен на продукты
        int[] prices = {60, 50, 150, 80, 90, 120, 100, 200, 45, 130};

        // При старте программа должна искать этот файл в корне проекта
        File myFile = new File("basket.bin");
        //Создаем пустую корзину
        Basket basket = new Basket(prices, products);
        // и если он находится,
        if (myFile.exists())
        // восстанавливать корзину из него;
        {

            Basket basketN = basket.loadFromBinFile(myFile);
            System.out.println("Восстановленная из файла корзина:");
            basketN.printCart();
            basket = basketN;
        }

        int sumProducts = 0;
        Scanner scanner = new Scanner(System.in);

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
                    basket.printCart();
                }
                break;
            }

            String[] parts = input.split(" ");
            int number = Integer.parseInt(parts[0]) - 1;
            int count = Integer.parseInt(parts[1]);
            basket.addToCart(Integer.parseInt(parts[0]), count);
            //После ввода каждой покупки пользователем вам следует
            // сохранять пользовательскую корзину в файл basket.txt
            basket.saveBin(myFile);
            //basket.printCart();
            sumProducts = sumProducts + prices[number] * count;
        }
    }
}
