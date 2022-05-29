package tk.designPattern.abstractFactory.domain.product.dao.oracle;

import tk.designPattern.abstractFactory.domain.product.Product;
import tk.designPattern.abstractFactory.domain.product.dao.ProductDao;

public class ProductOracleDao implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        System.out.println("insert into Oracle product : "+product.getProductId());
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("updateProduct into Oracle product : "+product.getProductId());
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("deleteProduct into Oracle product : "+product.getProductId());
    }
}
