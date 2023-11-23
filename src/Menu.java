import java.util.Scanner;

public class Menu {

	public Menu() {
		Shop shop = new Shop();
		Commands commands = new Commands(
				new Work_with_bouquets(shop),
				new Work_with_cart(shop),
				new Bought(shop),
				new Good_bye(shop),
				new Create_bouquet(shop));
		
		int choice = 0;
		
		while(true) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n#######################################################");
		
		System.out.println("Виберіть опцію:");
		System.out.println("Робота з готовими букетами(1)");
		System.out.println("Створити букет(2)");
		System.out.println("Робота з корзиною(3)");
		System.out.println("Переглянути придбані(4)");
		System.out.println("Завершити роботу програми(5)");
		
		
		choice = input.nextInt();
		switch(choice) {
		case 1:
			commands.work_with_Bouquets();
			break;
		case 2:
			commands.create_Bouquet();
			break;
		case 3:
		commands.work_with_Cart();
			break;
		case 4:
			commands.bought_Bouquets();
			break;
		case 5:
			commands.good_Bye();
			return;
		}
		}
	}
}
