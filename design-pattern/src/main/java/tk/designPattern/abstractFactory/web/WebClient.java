package tk.designPattern.abstractFactory.web;

import tk.designPattern.abstractFactory.domain.product.Product;
import tk.designPattern.abstractFactory.domain.product.dao.ProductDao;
import tk.designPattern.abstractFactory.domain.userinfo.UserInfo;
import tk.designPattern.abstractFactory.domain.userinfo.dao.UserInfoDao;
import tk.designPattern.abstractFactory.factory.DaoFactory;
import tk.designPattern.abstractFactory.factory.MysqlDaoFactory;
import tk.designPattern.abstractFactory.factory.OracleDaoFactory;

public class WebClient {

    public static void main(String[] args) {

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("11");
        userInfo.setUserName("tom");
        userInfo.setPassword("aaa");

        Product product = new Product();
        product.setProductId("22");
        product.setProductName("mike");


        String dbType = "ORACLE";
        DaoFactory daoFactory = null;
        if(dbType.equals("MYSQL")) {
            daoFactory = new MysqlDaoFactory();
        }else if( dbType.equals("ORACLE")){
            daoFactory = new OracleDaoFactory();
        } else {
            System.out.println("error");
        }

        UserInfoDao userInfoDao = daoFactory.createUserInfoDao();
        userInfoDao.insertProduct(userInfo);
        userInfoDao.updateProduct(userInfo);

        ProductDao productDao = daoFactory.createProductDao();
        productDao.insertProduct(product);
        productDao.updateProduct(product);
    }
}
