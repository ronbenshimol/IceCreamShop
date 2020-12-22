package Order;

import java.util.ArrayList;

import products.Product;

public class Order implements IOrder, OrderPublisher, OrderAggregate {

    // Product
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<OrderSubscriber> subscribers = new ArrayList<>();
    public Order() {

    }

    @Override
    public void prepareOrder() {
        // TODO:

        //when done preparing order
        notifySubscribers();
    }

    @Override
    public void addSubscriber(OrderSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (OrderSubscriber subscriber : subscribers) {
            subscriber.update(this);
        }

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
