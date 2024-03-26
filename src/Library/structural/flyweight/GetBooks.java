package Library.structural.flyweight;
public class GetBooks implements Flyweight {

    private String title;
    private String author;
    private String department;

    public GetBooks(String title, String author, String department) {
        this.title = title;
        this.author = author;
        this.department = department;
    }

    @Override
    public void display() {
        System.out.println("Title: " + title + ", " + "author: " + author + ", " + "department: " + department);
    }
}
