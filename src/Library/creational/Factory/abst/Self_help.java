package Library.creational.Factory.abst;

import Library.creational.Factory.Collection;

public class Self_help extends Collection {
    @Override
    public void giveItem() {
        System.out.println("Don't forget to return!");
    }

    @Override
    public void returnItem() {
        System.out.println("Congratulations on return");
    }
}