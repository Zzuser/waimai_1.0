package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.UserShop;
import cuc.waimai.mapper.UserShopMapper;
import cuc.waimai.service.UserShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShopServiceImpl implements UserShopService {
    @Autowired
    UserShopMapper userShopMapper;
    @Override
    public int deleteByPrimaryKey(Integer userShopId) {
        return userShopMapper.deleteByPrimaryKey(userShopId);
    }

    @Override
    public int insert(UserShop record) {
        return userShopMapper.insert(record);
    }

    @Override
    public UserShop selectByPrimaryKey(Integer userShopId) {
        return userShopMapper.selectByPrimaryKey(userShopId);
    }

    @Override
    public List<UserShop> selectAll() {
        return userShopMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserShop record) {
        return userShopMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserShop> selectByUserId(Integer userId) {
        return userShopMapper.selectByUserId(userId);
    }
}
