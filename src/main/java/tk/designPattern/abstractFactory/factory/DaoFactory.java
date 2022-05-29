package tk.designPattern.abstractFactory.factory;

import tk.designPattern.abstractFactory.domain.product.dao.ProductDao;
import tk.designPattern.abstractFactory.domain.userinfo.dao.UserInfoDao;

public interface DaoFactory {

    public UserInfoDao createUserInfoDao();
    public ProductDao createProductDao();
}
