package products.iceCream.iceCreamFlavors;

import products.iceCream.IceCream;

public class BananaIceCream extends IceCreamFlavorDecorator {

    public BananaIceCream(IceCream iceCream) {
	    this(iceCream, 1);
    }
    
    public BananaIceCream(IceCream iceCream, int numberOfScoops) {
	    super(iceCream, numberOfScoops);
        this.price = 1.50;
        this.description = "Banana ice cream";
    }

}
