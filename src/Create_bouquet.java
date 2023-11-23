
public class Create_bouquet implements Command{
	Shop shop;
	
	public Create_bouquet(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void execute() {
		this.shop.create_bouquet();;
	}
	

}
