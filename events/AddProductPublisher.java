package events;

import products.Product;

public interface AddProductPublisher {
    public void addAddProductSubscriber(AddProductSubscriber subscriber);
    public void notifyAddProductSubscribers(Product product);
}
