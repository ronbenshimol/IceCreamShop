package Order;

import products.Product;

public interface IOrder extends OrderAggregate{
    void addProduct(Product product);
}
