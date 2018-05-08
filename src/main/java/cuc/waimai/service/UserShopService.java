package cuc.waimai.service;

import cuc.waimai.Dao.UserShop;

import java.util.List;

public interface UserShopService {
    int deleteByPrimaryKey(Integer userShopId);

    int insert(UserShop record);

    UserShop selectByPrimaryKey(Integer userShopId);

    List<UserShop> selectAll();

    int updateByPrimaryKey(UserShop record);

    List<UserShop> selectByUserId(Integer userId);
}
//selectByUserId