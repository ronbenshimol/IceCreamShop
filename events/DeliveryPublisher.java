package events;

public interface DeliveryPublisher {
    public void addDeliverySubscriber(DeliverySubscriber subscriber);
    public void notifyDeliverySubscribers();
}
