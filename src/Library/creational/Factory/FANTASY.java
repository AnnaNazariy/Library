package Library.creational.Factory;
public class FANTASY extends Collection{
    @Override
    public void giveItem() {
        System.out.println("Don't forget fantasy to return!");
    }

    @Override
    public void returnItem() {
        System.out.println("Congratulations on return fantasy");
    }
}