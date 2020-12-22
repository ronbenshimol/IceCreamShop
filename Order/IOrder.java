package Order;

import products.Product;

public interface IOrder {
    void prepareOrder();
    void addProduct(Product product);
}
