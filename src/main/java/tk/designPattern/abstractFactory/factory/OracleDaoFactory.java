package tk.designPattern.abstractFactory.factory;

import tk.designPattern.abstractFactory.domain.product.dao.ProductDao;
import tk.designPattern.abstractFactory.domain.product.dao.oracle.ProductOracleDao;
import tk.designPattern.abstractFactory.domain.userinfo.dao.UserInfoDao;
import tk.designPattern.abstractFactory.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class OracleDaoFactory implements DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoOracleDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductOracleDao();
    }
}
