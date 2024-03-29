package tk.designPatternIntro.factoryMethod.A2.idcard;

import tk.designPatternIntro.factoryMethod.A2.framework.Factory;
import tk.designPatternIntro.factoryMethod.A2.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
