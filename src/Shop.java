import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
	
private List<Bouquet>cart;
private Display display;
private List<Bouquet>bought;

public Shop() {
	this.display = new Display();
	this.cart = new ArrayList<Bouquet>();
	this.bought = new ArrayList<Bouquet>();
}

 private boolean see_cart() {
	 boolean check = false;
	 double sum = 0;
	 for(int i = 0; i < cart.size(); i++) {
		 sum+=cart.get(i).getPrice_hrn();
		 System.out.printf("%d) ",i+1);
		 System.out.println(cart.get(i));
		 check = true;
	 }
	 System.out.println("Загальна ціна всіх букетів : "+sum);
	 return check;
 }
 
 private boolean see_bought() {
	 boolean check = false;
	 for(int i = 0; i < bought.size(); i++) {
		 System.out.printf("%d) ",i+1);
		 System.out.println(bought.get(i));
		 check = true;
	 }
	 return check;
 }


 	public void work_with_bouquets() {
	Scanner input = new Scanner(System.in);
	int choice = 0;
	this.display.see_default_bouquets();
	System.out.println("Додати якись з цих букетів в корзину(0)");
	System.out.println("Повернутися в меню(1)");
	do {
	choice = input.nextInt();
	if(choice>1 || choice<0)
		System.out.println("Хибні дані, спробуйте ще");
	}while(choice>1 || choice<0);
	switch (choice) {
	case 0:
		System.out.println("Виберіть букет");
		do {
			choice = input.nextInt();
			if(choice>this.display.get_bouquets_quan() || choice<1)
				System.out.println("Хибні дані, спробуйте ще");
			}while(choice>this.display.get_bouquets_quan() || choice<1);
		this.cart.add(this.display.get_bouquet_by_index(choice-1));
		this.display.remove_bouquet_by_index(choice-1);
		System.out.println("Букет успішно додано в корзину");
	}
	}
 	
 	public void create_bouquet() {
 		int choice = 0;
 		Scanner input = new Scanner(System.in);
 		Bouquet temp = this.display.create_user_bouquet();
		System.out.println("Букет успішно додано створено\n\n");
		System.out.println("Додати букет в корзину(0)");
		System.out.println("Додати букет в готові букети(1)");
		System.out.println("Придбати букет(2)");
		
		do {
			choice = input.nextInt();
			if(choice>2 || choice<0)
				System.out.println("Хибні дані, спробуйте ще");
			}while(choice>2 || choice<0);
		
		switch (choice){
		case 0:
			this.cart.add(temp);
			System.out.println("Букет успішно додано в корзину");
			break;
		case 1:
			this.display.add_bouquet(temp);
			System.out.println("Букет успішно додано в готові букети");
			break;
		case 2:
			this.bought.add(temp);
			System.out.println("Букет успішно придбано");
			break;
		}
 	}
 	
 	public void work_with_cart() {
 		int choice = 0;
 		Scanner input = new Scanner(System.in);
 		
 		if(!this.see_cart()) {
			System.out.println("Корзина порожня");
			return;
		}
		System.out.println("Придбати якись з цих букетів(0)");
		System.out.println("Повернутися в меню(1)");
		System.out.println("Вилучити якись з цих букетів з корзини(2)");
		System.out.println("Придбати всі букети в корзині(3)");
		do {
		choice = input.nextInt();
		if(choice>3 || choice<0)
			System.out.println("Хибні дані, спробуйте ще");
		}while(choice>3 || choice<0);
		switch (choice) {
		case 0:
			System.out.println("Виберіть букет,який хочете придбати");
			do {
				choice = input.nextInt();
				if(choice>this.cart.size() || choice<1)
					System.out.println("Хибні дані, спробуйте ще");
				}while(choice>this.cart.size() || choice<1);
			this.bought.add(this.cart.get(choice-1));
			this.cart.remove(choice-1);
			break;
		case 1:
			break;
		case 2:
			do {
				choice = input.nextInt();
				if(choice>this.cart.size() || choice<1)
					System.out.println("Хибні дані, спробуйте ще");
				}while(choice>this.cart.size() || choice<1);
			this.display.add_bouquet(this.cart.get(choice-1));
			this.cart.remove(choice-1);
			break;
		case 3:
			for(int i = 0; i < this.cart.size();i++)
				this.bought.add(this.cart.get(i));
				this.cart.removeAll(cart);
		}
 	}
 	public void bought_bouquets() {
	if(!this.see_bought())
		System.out.println("Куплених букетів немає");
 	}

 	public void good_bye() {
	System.out.println("До побачення");
	return;
}
}

