package DeliveryServices;

public class ConcreteDeliveryServiceFactory implements DeliveryServiceFactory{

    @Override
    public DeliveryService createDeliveryService(DeliveryServiceType deliveryServiceType) {
        switch (deliveryServiceType) {
            case Wolt:
                return new WoltDeliveryService();
            default:
                return new WoltDeliveryService();
        }
    }
    
}
