package products.iceCream;

public class PlasticCup implements IceCream {

    private double price;

    public PlasticCup(){
	this.price = 6.99;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return "plastic cup";
    }
}
