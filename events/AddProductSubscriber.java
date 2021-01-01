package events;

import products.Product;

public interface AddProductSubscriber {
    public void addProductUpdate(Product product);
}
