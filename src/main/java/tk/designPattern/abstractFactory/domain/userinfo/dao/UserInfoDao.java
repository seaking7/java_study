package tk.designPattern.abstractFactory.domain.userinfo.dao;

import tk.designPattern.abstractFactory.domain.userinfo.UserInfo;

public interface UserInfoDao {
    void insertProduct(UserInfo userInfo);
    void updateProduct(UserInfo userInfo);
    void deleteProduct(UserInfo userInfo);
}
