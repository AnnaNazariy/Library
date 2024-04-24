package Library.behavioral.Mediator;
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receiveRequest(String message);
    public abstract void sendRequest(String message);
}