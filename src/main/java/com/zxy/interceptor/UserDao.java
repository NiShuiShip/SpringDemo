package com.zxy.interceptor;

import org.apache.ibatis.session.SqlSession;


public class UserDao {

    SqlSession session = MybatisSessionUtil.getSession();

    public int insert(User user){
        int rint = session.insert("user.insertUser",user); // 第一个参数是mapper xml里的namespace+MappedStatement对应的id
        session.commit();// 不要忘记提交
        return rint;
    }
}
