package Library.creational.Prototype;
import java.util.Objects;

public class Reader implements Prototype {
    private final String name;
    private final int readerId;

    public Reader(String name, int readerId) {
        this.name = name;
        this.readerId = readerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return readerId == reader.readerId && Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, readerId);
    }

    @Override
    public Prototype doClone() {
        return new Reader(name, readerId);
    }


}
