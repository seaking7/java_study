package tk.designPattern.decorator.coffee.deco;

import tk.designPattern.decorator.coffee.Coffee;

public class MochaCoffee extends Decorator {
    public MochaCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print("Adding Mocha syrup ");
    }
}
