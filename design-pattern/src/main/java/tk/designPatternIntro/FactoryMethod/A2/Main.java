package tk.designPatternIntro.FactoryMethod.A2;

import tk.designPatternIntro.FactoryMethod.A2.framework.Factory;
import tk.designPatternIntro.FactoryMethod.A2.framework.Product;
import tk.designPatternIntro.FactoryMethod.A2.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Heungmin Son");
        Product card3 = factory.create("Kane");
        card1.use();
        card2.use();
        card3.use();
    }
}
