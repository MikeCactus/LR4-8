import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Bouquet {
	private double price;
	private List<Flower> flowers;
	private Accessory accessory;
	
public Bouquet() {
	this.price = 0;
	this.flowers = new ArrayList<Flower>();
	this.accessory = null;
};


public void changeFlower(Flower flower_del,Flower flower_add) {
this.deleteFlower(flower_del);
this.addFlower(flower_add);
}

public boolean isAccessory() {
	return this.accessory != null ?true:false;
}

public boolean changeAccessory(Accessory add) {
	if(this.accessory != add) {
	this.deleteAccessory();
	this.addAccessory(add);
	return true;
	}
	return false;
}

public boolean deleteAccessory() {
	if(this.accessory!=null) {
		this.accessory = null;
		return true;}
	return false;
}

public boolean addAccessory(Accessory accessory) {
	if(this.accessory==null) {
		this.accessory = accessory;
		this.price += accessory.Price;
		return true;}
	return false;
}

public void addFlower(Flower flower) {
	this.flowers.add(flower);
	this.price += flower.getPrice_hrn();
};

public void deleteFlower(Flower flower) {
	this.flowers.remove(flower);
	this.price -= flower.getPrice_hrn();
};

public String toString() {
	String flowersS="";
	for(int i = 0; i<this.flowers.size();i++)
		flowersS += this.flowers.get(i)+"\n";
	return flowersS+ "(Аксесуар) "+(this.accessory == null ?"Аксесуара немає ":this.accessory.toString())+"\n"+"(Загальна ціна букету) "+this.price;
}

public int getFlowers_size() {
	return this.flowers.size();
	}

public Flower getFlower(int index) {
	return this.flowers.get(index);
}
public double getPrice_hrn() {

	return this.price;
}
public void sort_by_date() {
	Collections.sort(this.flowers);
}
}