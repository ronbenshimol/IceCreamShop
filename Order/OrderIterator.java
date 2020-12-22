package Order;

import products.Product;

public interface OrderIterator {
    public boolean hasNext();
    public Product next();
}
