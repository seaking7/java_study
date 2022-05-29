package tk.designPattern.abstractFactory.factory;

import tk.designPattern.abstractFactory.domain.product.dao.ProductDao;
import tk.designPattern.abstractFactory.domain.product.dao.mysql.ProductMysqlDao;
import tk.designPattern.abstractFactory.domain.userinfo.dao.UserInfoDao;
import tk.designPattern.abstractFactory.domain.userinfo.dao.mysql.UserInfoMysqlDao;

public class MysqlDaoFactory implements DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoMysqlDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductMysqlDao();
    }
}
