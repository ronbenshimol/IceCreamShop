package products.iceCream.iceCreamFlavors;

import products.iceCream.IceCream;

public abstract class IceCreamFlavorDecorator implements IceCream {

    protected IceCream iceCream;
    protected double price;
    protected String description;
    protected int numberOfScoops;


    public IceCreamFlavorDecorator(IceCream iceCream, int numberOfScoops) {
        this.iceCream = iceCream;
        this.numberOfScoops = numberOfScoops;
    }

    public double getPrice() {
        return iceCream.getPrice() + (this.price * numberOfScoops);
    }

    public String getDescription() {
        return iceCream.getDescription() + ", " + this.formatDescription();
    }

    protected String formatDescription(){
        if(this.numberOfScoops == 1)
            return this.numberOfScoops + " scoop of " + this.description;
        else
            return this.numberOfScoops + " scoops of " + this.description;
    }
}
