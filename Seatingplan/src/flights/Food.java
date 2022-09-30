package flights;

public class Food {

	String name;
	int stock;
	double price;
	
	
	public Food(String n,int s,double p) {
		name=n;
		stock=s;
		price=p;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

}
