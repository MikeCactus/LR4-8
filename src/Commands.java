
public class Commands {
Command work_with_bouquets;
Command work_with_cart;
Command bought_bouquets;
Command good_bye;
Command create_bouquet;

public Commands(Command work_with_bouquets,Command work_with_cart,Command bought_bouquets,Command good_bye,Command create_bouquet) {
	this.work_with_bouquets = work_with_bouquets;
	this.work_with_cart = work_with_cart;
	this.bought_bouquets = bought_bouquets;
	this.good_bye = good_bye;
	this.create_bouquet = create_bouquet;
}

public void work_with_Bouquets() {
	work_with_bouquets.execute();
}
public void work_with_Cart() {
	work_with_cart.execute();
}
public void bought_Bouquets() {
	bought_bouquets.execute();
}
public void good_Bye() {
	good_bye.execute();
}
public void create_Bouquet() {
	create_bouquet.execute();
}
}