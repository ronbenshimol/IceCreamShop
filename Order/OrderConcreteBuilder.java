package Order;

import products.Product;

public class OrderConcreteBuilder implements OrderBuilder {

    private Order order;

    public OrderConcreteBuilder() {
        this.order = new Order();
    }

    @Override
    public void addProduct(Product product) {
        this.order.addProduct(product);
    }

    @Override
    public Order getOrder() {
        return this.order;
    }
    
}
