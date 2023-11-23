
public class Bought implements Command{
	Shop shop;
	
	public Bought(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void execute() {
		this.shop.bought_bouquets();;
	}
	

}
