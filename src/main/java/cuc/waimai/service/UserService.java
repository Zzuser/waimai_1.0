package cuc.waimai.service;

import cuc.waimai.Dao.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUserName(String userName);
}
