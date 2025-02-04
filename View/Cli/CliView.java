package View.Cli;

import java.util.ArrayList;
import Order.IOrder;
import Order.OrderIterator;
import View.InputOutput;
import View.View;
import View.Cli.ProductMenus.ProductCliMenu;
import View.Cli.ProductMenus.ProductMenuFactory;
import events.AddProductSubscriber;
import events.DoneOrderSubscriber;
import products.Product;

public class CliView implements View {

    private boolean addAnotherProduct = true;
    private Product product;
    InputOutput inputOutput;
    ProductMenuFactory productMenuFactory;

    private ArrayList<DoneOrderSubscriber> doneOrderSubscribers = new ArrayList<>();
    private ArrayList<AddProductSubscriber> addProductSubscribers = new ArrayList<>();

    public CliView(InputOutput ioHandler, ProductMenuFactory productMenuFactory) {
        this.inputOutput = ioHandler;
        this.productMenuFactory = productMenuFactory;
    }

    @Override
    public void display() {
        int numberChoice;

        // Adding a new Order
        this.inputOutput.display("Welcom to the Ice Cream Shop!");
        this.inputOutput.display("=============================");
        this.inputOutput.display("");

        do {

            this.inputOutput.display("What product do you want to add?");

            this.inputOutput.display("1. Ice Cream");
            numberChoice = this.inputOutput.inputInt();
            this.inputOutput.display("You have selected option " + numberChoice);

            ProductCliMenu  currentProductMenu = productMenuFactory.getProductMenu(numberChoice);
            product = currentProductMenu.displayMenu();

            if (product != null) {
                notifyAddProductSubscribers(product);
            }

            this.inputOutput.display("Great! Do you want another product? ");
            this.inputOutput.display("1. No");
            this.inputOutput.display("2. Yes");
            this.inputOutput.display("The default is No if you select another number");
            numberChoice = this.inputOutput.inputInt();
            addAnotherProduct = numberChoice == 2 ? true : false;

        } while (addAnotherProduct);

        this.inputOutput.display("Ok, we are preparing your order");

        notifyDoneOrderSubscribers();

    }

    @Override
    public void addDoneOrderSubscriber(DoneOrderSubscriber subscriber) {
        doneOrderSubscribers.add(subscriber);
    }

    @Override
    public void notifyDoneOrderSubscribers() {
        for (DoneOrderSubscriber doneOrderSubscriber : doneOrderSubscribers) {
            doneOrderSubscriber.doneOrderUpdate();
        }
    }

    @Override
    public void addAddProductSubscriber(AddProductSubscriber subscriber) {
        addProductSubscribers.add(subscriber);
    }

    @Override
    public void notifyAddProductSubscribers(Product product) {
        for (AddProductSubscriber addProductSubscriber : addProductSubscribers) {
            addProductSubscriber.addProductUpdate(product);
        }

    }

    @Override
    public void deliveryUpdate(IOrder order) {
        
        double totalPrice = 0;
        
        this.inputOutput.display("Good news! Your order has been delivered and is on it's way to you");

        this.inputOutput.display("Here is the receipt for your order: ");
        this.inputOutput.display("==================================================================");
        for (OrderIterator iter = order.getIterator(); iter.hasNext();) {
			Product prod = iter.next();
            String desc = prod.getDescription();
            totalPrice += prod.getPrice();
            this.inputOutput.display(desc);
            this.inputOutput.display("Product price: " + prod.getPrice());
            this.inputOutput.display("- - - - - - - - - - - - - - - - - - - - - - - - - - ");

        }
        this.inputOutput.display("The total price of your order is: " + totalPrice);
        this.inputOutput.display("==================================================================");
        
    }

}
