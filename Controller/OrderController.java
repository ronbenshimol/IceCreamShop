package Controller;

import events.AddProductSubscriber;
import events.DoneOrderSubscriber;

public interface OrderController extends AddProductSubscriber, DoneOrderSubscriber {
    public void start();
}
