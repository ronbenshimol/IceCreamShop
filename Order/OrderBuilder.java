package Order;

import products.Product;

public interface OrderBuilder {
    public void addProduct(Product product);
    public Order getOrder();
}