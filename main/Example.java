// package main;

// import Order.Order;
// import Order.OrderIterator;
// import View.View;
// import View.Cli.CliView;
// import products.Product;
// import products.iceCream.IceCream;
// import products.iceCream.PlasticCup;
// import products.iceCream.WaffleCone;
// import products.iceCream.iceCreamFlavors.BananaIceCream;
// import products.iceCream.iceCreamFlavors.MintIceCream;

// public class Example {

// 	public static void main(String[] args) {

// 		// // view:
// 		// // do you want another prod? yes
// 		// IceCream iceCreamBananaMint = new BananaIceCream(new MintIceCream(new WaffleCone()));
// 		// // notify controller 1 -> controller: order.addProduct(iceCreamBananaMint)
// 		// // do you want another prod? yes
// 		// IceCream iceCreamBanana = new BananaIceCream(new PlasticCup(), 2);
// 		// // notify controller 2 -> controller: order.addProduct(iceCreamBananaMint)

// 		// Order order = new Order();
// 		// order.addProduct(iceCreamBananaMint); // in notification 1
// 		// order.addProduct(iceCreamBanana); // in notification 2

// 		// for (OrderIterator iter = order.getIterator(); iter.hasNext();) {
// 		// 	Product prod = iter.next();
// 		// 	String desc = prod.getDescription();
// 		// 	System.out.println(desc);
// 		// }

// 			View view = new CliView();
// 			view.display();

		
// 	}
// }
