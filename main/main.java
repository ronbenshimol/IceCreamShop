package main;

import Controller.MainController;
import Controller.OrderController;
import DeliveryServices.DeliveryService;
import DeliveryServices.WoltDeliveryService;
import Order.IOrder;
import Order.Order;
import View.View;
import View.Cli.CliView;

public class main {
    public static void main(String[] args) {
        
        IOrder order = new Order();
        View view = new CliView();
        DeliveryService deliveryService = new WoltDeliveryService();
        OrderController controller = new MainController(order, view, deliveryService);
        deliveryService.addDeliverySubscriber(view);
        view.addAddProductSubscriber(controller);
        view.addDoneOrderSubscriber(controller);

        controller.start();

    }
}
