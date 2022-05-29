package tk.designPattern.abstractFactory.domain.product.dao.mysql;

import tk.designPattern.abstractFactory.domain.product.Product;
import tk.designPattern.abstractFactory.domain.product.dao.ProductDao;

public class ProductMysqlDao implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        System.out.println("insert into Mysql product : "+product.getProductId());
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("updateProduct into Mysql product : "+product.getProductId());
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("deleteProduct into Mysql product : "+product.getProductId());
    }
}
