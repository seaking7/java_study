package tk.designPattern.abstractFactory.domain.userinfo.dao.oracle;

import tk.designPattern.abstractFactory.domain.userinfo.UserInfo;
import tk.designPattern.abstractFactory.domain.userinfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {
    @Override
    public void insertProduct(UserInfo userInfo) {
        System.out.println("insertProduct into Oracle userInfo : "+userInfo.getUserId());
    }

    @Override
    public void updateProduct(UserInfo userInfo) {
        System.out.println("updateProduct into Oracle userInfo : "+userInfo.getUserId());
    }

    @Override
    public void deleteProduct(UserInfo userInfo) {
        System.out.println("deleteProduct into Oracle userInfo : "+userInfo.getUserId());
    }
}
