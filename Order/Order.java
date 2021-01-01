package Order;

import java.util.ArrayList;

import products.Product;

// public class Order implements IOrder, OrderPublisher, OrderAggregate {
public class Order implements IOrder {

    // Product
    private ArrayList<Product> products = new ArrayList<>();
   //  ArrayList<OrderSubscriber> subscribers = new ArrayList<>();
    public Order() {

    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }


    @Override
   public OrderIterator getIterator() {
      return new ConcreteOrderIterator();
   }

   private class ConcreteOrderIterator implements OrderIterator {

      int index;


      @Override
      public boolean hasNext() {
      
         if(index < products.size()){
            return true;
         }
         return false;
      }

      @Override
      public Product next() {
      
         if(this.hasNext()){
            return products.get(index++);
         }
         return null;
      }


   }
    
}
