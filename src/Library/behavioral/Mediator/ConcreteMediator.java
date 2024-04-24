package Library.behavioral.Mediator;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendRequest(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.receiveRequest(message);
            }
        }
    }
}