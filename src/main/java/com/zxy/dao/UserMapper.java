package com.zxy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 这里面的原理也是通过动态代理生成新的类，然后交给spring去管理，userMapper-->新生成的类，然后spring自动注入的对象就是代理类。
 * 现在要确定的是，mybatis中是通过注解在spring中实现动态代理，并且将代理类对象交给spring管理。
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<Map<String,String>> getUserAll();
}
