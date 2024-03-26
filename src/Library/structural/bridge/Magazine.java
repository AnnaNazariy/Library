package Library.structural.bridge;

public class Magazine implements LibraryItem {
    private String title;
    private String category;
    private Service service;

    public Magazine(String title, String category, Service service) {
        this.title = title;
        this.category = category;
        this.service = service;
    }

    @Override
    public void borrowItem() {
        System.out.println("Magazine \"" + title + "\" in " + category + " category is borrowed.");
    }

    @Override
    public void returnItem() {
        System.out.println("Magazine \"" + title + "\" in " + category + " category is returned.");
    }

    @Override
    public Service getService() {
        return service;
    }
}
