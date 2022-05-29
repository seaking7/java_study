package tk.designPattern.decorator.coffee.deco;

import tk.designPattern.decorator.coffee.Coffee;

public class Latte extends Decorator {

    public Latte(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print("Adding Milk ");
    }
}
