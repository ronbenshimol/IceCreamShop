package main;

import Controller.MainController;
import Controller.OrderController;
import DeliveryServices.ConcreteDeliveryServiceFactory;
import DeliveryServices.DeliveryService;
import DeliveryServices.DeliveryServiceFactory;
import DeliveryServices.DeliveryServiceType;
import Order.IOrder;
import Order.Order;
import View.InputOutput;
import View.View;
import View.Cli.CliInputOutput;
import View.Cli.CliView;
import View.Cli.ProductMenus.ConcreteProductMenuFactory;
import View.Cli.ProductMenus.ProductMenuFactory;

public class main {
    public static void main(String[] args) {
        
        IOrder order = new Order();
        ProductMenuFactory cliMenuFactory = new ConcreteProductMenuFactory();
        InputOutput inputOutput = new CliInputOutput();
        
        View view = new CliView(inputOutput, cliMenuFactory);

        DeliveryServiceFactory deliveryServiceFactory = new ConcreteDeliveryServiceFactory();
        DeliveryService deliveryService = deliveryServiceFactory.createDeliveryService(DeliveryServiceType.Wolt);

        OrderController controller = new MainController(order, view, deliveryService);
        
        deliveryService.addDeliverySubscriber(view);
        view.addAddProductSubscriber(controller);
        view.addDoneOrderSubscriber(controller);

        controller.start();

    }
}
