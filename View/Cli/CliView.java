package View.Cli;

import java.util.ArrayList;
import java.util.Scanner;

import Order.IOrder;
import Order.OrderIterator;
import View.View;
import View.Cli.ProductMenus.IceCreamMenu;
import events.AddProductSubscriber;
import events.DoneOrderSubscriber;
import products.Product;

public class CliView implements View {

    private Scanner scanner;
    private boolean addAnotherProduct = true;
    private Product product;

    private ArrayList<DoneOrderSubscriber> doneOrderSubscribers = new ArrayList<>();
    private ArrayList<AddProductSubscriber> addProductSubscribers = new ArrayList<>();

    public CliView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        int numberChoice;

        // Adding a new Order
        System.out.println("Welcom to the Ice Cream Shop!");
        System.out.println("=============================");
        System.out.println("");

        do {

            System.out.println("what product do you want to add?");

            System.out.println("1. Ice Cream");
            numberChoice = this.scanner.nextInt();
            System.out.println("You chose option " + numberChoice);

            switch (numberChoice) {
                case 1:
                    product = (new IceCreamMenu()).displayMenue();
                    break;
                default:
                    product = (new IceCreamMenu()).displayMenue();
                    break;
            }

            if (product != null) {
                notifyAddProductSubscribers(product);
            }

            System.out.println("Great! do you want another product? ");
            System.out.println("1. no");
            System.out.println("2. yes");
            System.out.println("The default is no if you choose other number");
            numberChoice = this.scanner.nextInt();
            addAnotherProduct = numberChoice == 2 ? true : false;

        } while (addAnotherProduct);

        System.out.println("ok, we are preparing your order");

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
        
        System.out.println("Good news! your order was delivered and it's on the way to you");

        System.out.println("Here is the recipe for your order: ");
        System.out.println("==================================================================");
        for (OrderIterator iter = order.getIterator(); iter.hasNext();) {
			Product prod = iter.next();
            String desc = prod.getDescription();
            totalPrice += prod.getPrice();
            System.out.println(desc);
            System.out.println("product price: " + prod.getPrice());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - ");

        }
        System.out.println("the total price of your order is: " + totalPrice);
        System.out.println("==================================================================");
        
    }

}
