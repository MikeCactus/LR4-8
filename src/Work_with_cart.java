
public class Work_with_cart implements Command{
	Shop shop;
	
	public Work_with_cart(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void execute() {
		this.shop.work_with_cart();
	}
	

}
