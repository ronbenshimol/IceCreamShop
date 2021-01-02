package main;

import Controller.MainController;
import Controller.OrderController;
import DeliveryServices.ConcreteDeliveryServiceFactory;
import DeliveryServices.DeliveryService;
import DeliveryServices.DeliveryServiceFactory;
import DeliveryServices.DeliveryServiceType;
import Order.IOrder;
import Order.Order;
import View.View;
import View.Cli.CliView;

public class main {
    public static void main(String[] args) {
        
        IOrder order = new Order();
        View view = new CliView();
        DeliveryServiceFactory deliveryServiceFactory = new ConcreteDeliveryServiceFactory();
        DeliveryService deliveryService = deliveryServiceFactory.createDeliveryService(DeliveryServiceType.Wolt);
        OrderController controller = new MainController(order, view, deliveryService);
        deliveryService.addDeliverySubscriber(view);
        view.addAddProductSubscriber(controller);
        view.addDoneOrderSubscriber(controller);

        controller.start();

    }
}
