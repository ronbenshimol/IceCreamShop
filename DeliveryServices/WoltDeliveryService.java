package DeliveryServices;

import java.util.ArrayList;

import Order.IOrder;
import events.DeliverySubscriber;

public class WoltDeliveryService implements DeliveryService {

    private ArrayList<DeliverySubscriber> deliverySubscribers = new ArrayList<>();
    private IOrder order;
    @Override
    public void addDeliverySubscriber(DeliverySubscriber subscriber) {
        deliverySubscribers.add(subscriber);

    }

    @Override
    public void notifyDeliverySubscribers() {
       for (DeliverySubscriber deliverySubscriber : deliverySubscribers) {
            deliverySubscriber.deliveryUpdate(this.order);
       }

    }

    @Override
    public void deliver(IOrder order) {
        //delivering the Order
        this.order = order;
        notifyDeliverySubscribers();

    }


}
