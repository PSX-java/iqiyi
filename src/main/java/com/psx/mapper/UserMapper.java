package com.psx.mapper;

import com.psx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();
    User queryUserById(User user);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
