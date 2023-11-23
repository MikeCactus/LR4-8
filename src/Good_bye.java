
public class Good_bye implements Command{
	Shop shop;
	
	public Good_bye(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void execute() {
		this.shop.good_bye();
	}
	

}
