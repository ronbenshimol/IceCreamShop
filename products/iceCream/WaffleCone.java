package products.iceCream;

public class WaffleCone implements IceCream {

    private double price;

    public WaffleCone(){
	this.price = 6.99;
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return this.price;
    }

    @Override
    public String getDescription() {
        return "waffle cone";
    }
}
