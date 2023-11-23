import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Display {

	private List<Bouquet> Bouquets;
	private List<Flower> Flowers;
	private List<Accessory> Accessories;
	public Display() {
		this.Bouquets = new ArrayList<Bouquet>();
		this.Flowers = new ArrayList<Flower>();
		this.Accessories = new ArrayList<Accessory>();
		this.generate_defaultFlowers();
		this.generate_default_accessories();
		this.generate_default_Bouquets();
	}
	
	public void add_bouquet(Bouquet item) {
		this.Bouquets.add(item);
	}
	private void generate_default_Bouquets() {
this.Bouquets.add(create_default_Bouquet(5,"Chamomile",10,"Paper","White","20/11/2023"));
this.Bouquets.add(create_default_Bouquet(5,"Rose",7,"Сellophane","Red","20/11/2023"));
this.Bouquets.add(create_default_Bouquet(7,"Lavender",4,"Bow","Red","20/11/2023"));
this.Bouquets.add(create_default_Bouquet(3,"Orchid",11,"Paper","Red","20/11/2023"));
this.Bouquets.add(create_default_Bouquet(9,"Tulip",8,"Paper","Pink","19/11/2023"));
	}
	
	
public Bouquet get_bouquet_by_index(int index) {
	return this.Bouquets.get(index);
}
public Bouquet remove_bouquet_by_index(int index) {
	return this.Bouquets.remove(index);
}
	private Bouquet create_default_Bouquet(int size,String typeF,double stem_length,String typeA,String color,String date_of_cut) {
		Bouquet bouquet = new Bouquet();
		Flower flower = null;
		
		
		for(int i = 0; i < size; i++) {
			switch (typeF) {
			case "Chamomile":
				flower = new Chamomile(stem_length,color,date_of_cut,30);
				break;
			case "Lavender":
				flower = new Lavender(stem_length,color,date_of_cut,30);
				break;
			case "Orchid":
				flower = new Orchid(stem_length,color,date_of_cut,30);
				break;
			case "Rose":
				flower = new Rose(stem_length,color,date_of_cut,30);
				break;
			case "Tulip":
				flower = new Tulip(stem_length,color,date_of_cut,30);
				break;
			}
			bouquet.addFlower(flower);
			
		}
		Accessory accessory = null;
		switch (typeA){
		case "Bow":
			accessory = new Bow();
			break;
		case "Paper":
			accessory = new Paper();
			break;
		case "Сellophane":
			accessory = new Сellophane();
			break;
		}
		bouquet.addAccessory(accessory);
		
		return bouquet;
	}
	private void generate_defaultFlowers() {
		for(int i = 0 ; i<5; i++)
			this.Flowers.add(new Chamomile(8,"Red","17/11/2023",15));
		for(int i = 0 ; i<5; i++)
			this.Flowers.add(new Rose(7,"White","18/11/2023",30));
		for(int i = 0 ; i<5; i++)
			this.Flowers.add(new Lavender(4,"Purple","16/11/2023",25));
		for(int i = 0 ; i<5; i++)
			this.Flowers.add(new Orchid(8,"White","15/11/2023",20));
		for(int i = 0 ; i<5; i++)
			this.Flowers.add(new Tulip(10,"Pink","20/11/2023",40));
	}
	
	private void generate_default_accessories() {
		for(int i = 0 ; i<2; i++)
			this.Accessories.add(new Paper());
		for(int i = 0 ; i<2; i++)
			this.Accessories.add(new Сellophane());
		for(int i = 0 ; i<2; i++)
			this.Accessories.add(new Bow());
	}
	
	public Bouquet create_user_bouquet() {
		return form_user_Bouquet();
	}
	
	private Bouquet form_user_Bouquet() {
		Bouquet bouquet = new Bouquet();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("Ціна букета: "+ bouquet.getPrice_hrn());
		System.out.println("Додати квітку в букет(0)");
		System.out.println("Вилучити квітку з букета(1)");
		System.out.println("Додати аксесуар(2)");
		System.out.println("Завершити створення букета(3)");
		
		choice = input.nextInt();
		switch(choice) {
		case 0:
			if(this.Flowers.size()>0) {
			System.out.println("Виберіть квітку, яку хочете додати в букет(виберіть номер)");
			for(int i = 0; i < this.Flowers.size();i++)
				System.out.println((i+1)+") "+this.Flowers.get(i));
			do {
				choice = input.nextInt();
				if(choice>this.Flowers.size() || choice<1)
					System.out.println("Хибні дані, спробуйте ще");
				}while(choice>this.Flowers.size() || choice<1);
		bouquet.addFlower(this.Flowers.get(choice-1));
		this.Flowers.remove(choice-1);
		}
			else 
				System.out.println("Нема квіток для додавання");
			break;
			
	case 1:
		if(bouquet.getFlowers_size()>0) {
		System.out.println("Виберіть квітку, яку хочете вилучити з букету(виберіть номер)");
		for(int i = 0; i < bouquet.getFlowers_size();i++)
			System.out.println((i+1)+") "+ bouquet.getFlower(i));
		do {
			choice = input.nextInt();
			if(choice>bouquet.getFlowers_size() || choice<1)
				System.out.println("Хибні дані, спробуйте ще");
			}while(choice>bouquet.getFlowers_size() || choice<1);
		this.Flowers.add(bouquet.getFlower(choice-1));
	bouquet.deleteFlower(this.Flowers.get(choice-1));
	}
		else
			System.out.println("Нема квіток для видалення");
		break;
		
	case 2:
		if(bouquet.isAccessory()) {
			System.out.println("Аксесуар вже додано");
		}
		else {
			System.out.println("Виберіть аксесуар, який хочете додати до букету(виберіть номер)");
		this.see_default_accessories();
		do {
				choice = input.nextInt();
				if(choice>this.Accessories.size() || choice<1)
					System.out.println("Хибні дані, спробуйте ще");
				}while(choice>this.Accessories.size() || choice<1);
		bouquet.addAccessory(this.Accessories.get(choice-1));
		this.Accessories.remove(choice-1);
		}
		break;
	case 3:
		bouquet.sort_by_date();
		return bouquet;
	}
}
}
	
	public void see_default_accessories() {
		for(int i = 0; i < this.Accessories.size();i++) {
			System.out.println((i+1)+")"+this.Accessories.get(i));
		}
	}
	
public void see_default_bouquets(){
	System.out.println("############################");
	for(int i = 0; i < this.Bouquets.size();i++) {
		System.out.println((i+1) + ")" + this.Bouquets.get(i));
		System.out.println("############################");}
}

public int get_bouquets_quan() {
	return this.Bouquets.size();
}
}