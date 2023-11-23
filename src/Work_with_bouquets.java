
public class Work_with_bouquets implements Command{
	Shop shop;
	
	public Work_with_bouquets(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void execute() {
		this.shop.work_with_bouquets();
	}
	

}
