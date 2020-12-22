package Order;

public interface OrderPublisher {
    void addSubscriber(OrderSubscriber subscriber);
    void notifySubscribers();
}
