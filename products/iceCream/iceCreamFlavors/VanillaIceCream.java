package products.iceCream.iceCreamFlavors;

import products.iceCream.IceCream;

public class VanillaIceCream extends IceCreamFlavorDecorator {

    public VanillaIceCream(IceCream iceCream) {
	    this(iceCream, 1);
    }
    
    public VanillaIceCream(IceCream iceCream, int numberOfScoops) {
	    super(iceCream, numberOfScoops);
        this.price = 1.50;
        this.description = "Vanilla ice cream";
    }

}
