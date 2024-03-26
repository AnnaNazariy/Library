package Library.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Фабрика для створення книг
public class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    private static FlyweightFactory instance;

    private FlyweightFactory() {}

    public static FlyweightFactory getInstance() {
        if (instance == null) {
            instance = new FlyweightFactory();
        }
        return instance;
    }

    public Flyweight getBook(String title, String author, String department) {
        String key = title + "_" + author + "_" + department;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new GetBooks(title, author, department));
        }
        return flyweights.get(key);

    }
}
