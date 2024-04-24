package Library.behavioral.Mediator;
public class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveRequest(String message) {
        System.out.println("Received message: " + message);
    }

    @Override
    public void sendRequest(String message) {
        System.out.println("Sending message: " + message);
        mediator.sendRequest(message, this);
    }
}
