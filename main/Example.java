package main;

import Order.Order;
import Order.OrderIterator;
import products.Product;
import products.iceCream.IceCream;
import products.iceCream.PlasticCup;
import products.iceCream.WaffleCone;
import products.iceCream.iceCreamFlavors.BananaIceCream;
import products.iceCream.iceCreamFlavors.MintIceCream;

public class Example {

    public static void main(String[] args) {
    	
	// //Let's start with a barbecue pizza
	// BasePizza pizza = new Barbecue();
	// System.out.println("Barbecue has price: " + pizza.getPrice());
		
	// //Now we add some cheese
	// ExtraCheeseTopping ext = new ExtraCheeseTopping(pizza);
	// System.out.println("Barbecue with more cheese: " + ext.getPrice());
	
	// //And now we want some tune
	// TuneTopping tt = new TuneTopping(ext);
	// System.out.println("Barbacue with more cheese and tune: " + tt.getPrice());
	
		IceCream iceCreamBananaMint = new BananaIceCream(new MintIceCream(new WaffleCone()));
		IceCream iceCreamBanana = new BananaIceCream(new PlasticCup(), 2);

		Order order = new Order();
		order.addProduct(iceCreamBananaMint);
		order.addProduct(iceCreamBanana);

		for(OrderIterator iter = order.getIterator(); iter.hasNext();){
			Product prod = iter.next();
			String desc = prod.getDescription();
			System.out.println(desc);
		 } 

		
    }
}
