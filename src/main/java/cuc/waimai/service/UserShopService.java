package cuc.waimai.service;

import cuc.waimai.entity.UserShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserShopService {
    int deleteByPrimaryKey(Integer userShopId);

    int insert(UserShop record);

    UserShop selectByPrimaryKey(Integer userShopId);

    List<UserShop> selectAll();

    int updateByPrimaryKey(UserShop record);

    List<UserShop> selectByUserId(Integer userId);

    UserShop selectByUserIdAndShopId(@Param("userId") Integer userId, @Param("shopId")Integer shopId);

}
//selectByUserId