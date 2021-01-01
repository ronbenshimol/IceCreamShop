package events;

public interface DoneOrderPublisher {
    public void addDoneOrderSubscriber(DoneOrderSubscriber subscriber);
    public void notifyDoneOrderSubscribers();
}
