package DeliveryServices;

public interface DeliveryServiceFactory {
    DeliveryService createDeliveryService(DeliveryServiceType deliveryServiceType);
}
