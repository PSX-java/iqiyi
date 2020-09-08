package com.psx.mapper;


import com.psx.pojo.User1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface User1Mapper {

    User1 login(@Param("username") String username, @Param("password") String password) ;

}
