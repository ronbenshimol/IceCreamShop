package View;

import events.AddProductPublisher;
import events.DeliverySubscriber;
import events.DoneOrderPublisher;

public interface View extends AddProductPublisher, DoneOrderPublisher, DeliverySubscriber {
    public void display();
}
