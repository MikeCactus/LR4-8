

public class Flower implements Comparable<Flower>{
	
protected String Name = "Flower";
protected double Stem_length;
protected String Color;
protected String Date_of_cut;
protected double Price_hrn;


public Flower(double Stem_length, String Color,String Date_of_cut,double Price_hrn) {
	this.setColor(Color);
	this.setStem_length(Stem_length);
	this.setDate_of_cut(Date_of_cut);
	this.setPrice_hrn(Price_hrn);
}

@Override	 
public String toString() {
	return "(Квітка)"+this.getName()+"\t"+ "(Колір) "+this.getColor() + "\t"+ "(Довжина стебла) "+this.getStem_length()+"\t"+"(Дата зрізу) "+this.getDate_of_cut()+"\t"+"(Ціна) "+this.getPrice_hrn();
};

public String getName() {
	return this.Name;
}
public double getStem_length() {
	return this.Stem_length;
}
public void setStem_length(double stem_length) {
	this.Stem_length = stem_length;
}
public String getColor() {
	return this.Color;
}
public void setColor(String color) {
	this.Color = color;
}

public String getDate_of_cut() {
return this.Date_of_cut;
}
public void setDate_of_cut(String date_of_cut2) {
	this.Date_of_cut = date_of_cut2;
}
public double getPrice_hrn() {
	return this.Price_hrn;
	}

public void setPrice_hrn(double price) {
		this.Price_hrn = price;
}

public int date_to_int() {
    int res = 0;
    int num = 0;
    String[] dateComponents = this.Date_of_cut.split("/");
    for (int i = dateComponents.length - 1; i >= 0; i--) {
        res += Integer.parseInt(dateComponents[i]) * Math.pow(10, num++);
    }

    return res;
}

@Override
public int compareTo(Flower flower) {
   return this.date_to_int() - flower.date_to_int();
}
}
