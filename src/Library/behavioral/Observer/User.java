package Library.behavioral.Observer;

import java.util.List;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(List<String> newBooks) {
        System.out.println(name + ": New books available - " + newBooks);
    }
}

