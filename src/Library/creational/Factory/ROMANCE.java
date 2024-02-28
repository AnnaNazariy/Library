package Library.creational.Factory;

public class ROMANCE extends Collection{
    @Override
    public void giveItem() {
        System.out.println("Don't forget to return!");
    }

    @Override
    public void returnItem() {
        System.out.println("Congratulations on return");
    }
}