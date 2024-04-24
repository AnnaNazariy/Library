package Library.behavioral.Strategy;

public class Library4 {
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void performSort() {
        sortStrategy.sort();
    }
}
