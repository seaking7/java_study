package tk.designPattern.decorator.coffee;

public class KeyaCoffee extends Coffee{
    @Override
    public void brewing() {
        System.out.print("Keya Americano ");
    }
}
