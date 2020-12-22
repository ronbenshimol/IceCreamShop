package products.iceCream.iceCreamFlavors;

import products.iceCream.IceCream;

public class MintIceCream extends IceCreamFlavorDecorator {

    public MintIceCream(IceCream iceCream) {
	    this(iceCream,1);
    }
    
    public MintIceCream(IceCream iceCream, int numberOfScoops) {
	    super(iceCream, numberOfScoops);
        this.price = 1.20;
        this.description = "Mint ice cream";
    }

}
