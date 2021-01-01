package events;

import Order.IOrder;

public interface DeliverySubscriber {
    public void deliveryUpdate(IOrder order);
}
