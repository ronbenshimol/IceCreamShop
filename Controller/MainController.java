package Controller;

import DeliveryServices.DeliveryService;
import Order.IOrder;
import View.View;
import products.Product;

public class MainController implements OrderController {

    private View view;
    private IOrder order;
    private DeliveryService deliveryService;

    public MainController(IOrder order, View view, DeliveryService deliveryService) {
        this.view = view;
        this.deliveryService = deliveryService;
        this.order = order;
    }

    @Override
    public void start() {
        view.display();
    }

    @Override
    public void doneOrderUpdate() {
        deliveryService.deliver(order);

    }

    @Override
    public void addProductUpdate(Product product) {
        order.addProduct(product);
    }
    
}
