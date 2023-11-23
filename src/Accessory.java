

public class Accessory {
	protected String Name = "Accessory";
	protected double Price = 0;
	
	public String getName() {
		return this.Name;
	}

	
	public double getPrice() {
		return this.Price;
	}

public Accessory() {}

@Override
public String toString() {
	return this.getName()+" "+ "(Ціна) "+this.getPrice();
}
}
