package DeliveryServices;

import Order.IOrder;
import events.DeliveryPublisher;

public interface DeliveryService extends DeliveryPublisher{
    public void deliver(IOrder order);
}
